package com.leeseungyun1020.messaging;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Gravity;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.leeseungyun1020.messaging.databinding.ActivityMainBinding;
import com.leeseungyun1020.messaging.databinding.CustomLayoutBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.function.ObjIntConsumer;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final String channelId = "Channel_0";
    private static final String channelName = "styled";

    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        binding.toastButton.setOnClickListener(this::toast);
        binding.snackbarButton.setOnClickListener(this::snackbar);
        binding.snackbarCustomButton.setOnClickListener(this::snackbarCustom);
        binding.commonDialogButton.setOnClickListener(this::commonDialog);
        binding.customDialogButton.setOnClickListener(this::customDialog);
        binding.datepickerDialogButton.setOnClickListener(this::datePickerDialog);
        binding.timepickerDialogButton.setOnClickListener(this::timePickerDialog);
        binding.listDialogButton.setOnClickListener(this::listDialog);
        binding.customListDialogButton.setOnClickListener(this::customListDialog);
        binding.singleChoiceDialogButton.setOnClickListener(this::singleChoiceDialog);
        binding.multiChoiceDialogButton.setOnClickListener(this::multiChoiceDialog);
        binding.notificationButton.setOnClickListener(this::notification);
        binding.bigPictureNotificationButton.setOnClickListener(this::bigPictureNotification);
        binding.bigTextNotificationButton.setOnClickListener(this::bigTextNotification);
        binding.inBoxNotificationButton.setOnClickListener(this::inBoxNotification);
        binding.messagingNotificationButton.setOnClickListener(this::messagingNotification);
    }

    private void toast(View view) {
        Toast toast = Toast.makeText(this, "TOAST", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 100);
        CustomLayoutBinding customBinding = CustomLayoutBinding.inflate(getLayoutInflater());
        customBinding.getRoot().setBackgroundResource(android.R.drawable.toast_frame);
        customBinding.customImage.setImageResource(R.drawable.ic_launcher_foreground);
        customBinding.customText.setText("TOAST!");
        toast.setView(customBinding.getRoot());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            toast.addCallback(new Toast.Callback() {
                @Override
                public void onToastShown() {
                    super.onToastShown();
                    binding.statusText.setText("toast shown");
                }

                @Override
                public void onToastHidden() {
                    super.onToastHidden();
                    binding.statusText.setText("toast hidden");
                }
            });
        }
        toast.show();
    }

    private void snackbar(View view) {
        Snackbar snackbar = Snackbar.make(view, "Snackbar", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_FADE);
        snackbar.addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
            @Override
            public void onShown(Snackbar transientBottomBar) {
                super.onShown(transientBottomBar);
                binding.statusText.setText("snackbar shown");
            }

            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
                binding.statusText.setText("snackbar dismissed(" + event + ")");
            }
        });
        snackbar.setAction("확인", button -> {
            snackbar.dismiss();
        });
        snackbar.show();
    }

    private void snackbarCustom(View view) {
        Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG);
        CustomLayoutBinding customBinding = CustomLayoutBinding.inflate(getLayoutInflater());
        customBinding.customImage.setImageResource(R.drawable.ic_launcher_foreground);
        customBinding.customText.setText("Snackbar!");
        customBinding.customText.setTextColor(Color.WHITE);
        Snackbar.SnackbarLayout layout = ((Snackbar.SnackbarLayout) snackbar.getView());
        layout.addView(customBinding.getRoot());
        layout.setVisibility(View.INVISIBLE);
        snackbar.addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
            @Override
            public void onShown(Snackbar transientBottomBar) {
                super.onShown(transientBottomBar);
                binding.statusText.setText("snackbar(custom) shown");
            }

            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
                binding.statusText.setText("snackbar(custom) dismissed(" + event + ")");
            }
        });
        snackbar.show();
    }

    private void commonDialog(View view) {
        ObjIntConsumer<DialogInterface> bc = (dialog, which) -> {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    binding.statusText.setText("Common dialog closed(positive)");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    binding.statusText.setText("Common dialog closed(neutral)");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    binding.statusText.setText("Common dialog closed(negative)");
                    break;
            }
        };
        new AlertDialog.Builder(this)
                .setTitle("Common dialog")
                .setMessage("This is basic dialog")
                .setIcon(R.drawable.ic_baseline_rabbit_24)
                .setPositiveButton("Positive", bc::accept)
                .setNeutralButton("Neutral", bc::accept)
                .setNegativeButton("Negative", bc::accept)
                .show();
    }

    private void customDialog(View view) {
        ObjIntConsumer<DialogInterface> bc = (dialog, which) -> {
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    binding.statusText.setText("Custom dialog closed(positive)");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    binding.statusText.setText("Custom dialog closed(neutral)");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    binding.statusText.setText("Custom dialog closed(negative)");
                    break;
            }
        };
        CustomLayoutBinding customBinding = CustomLayoutBinding.inflate(getLayoutInflater());
        customBinding.customImage.setImageResource(R.drawable.ic_baseline_rabbit_24);
        customBinding.customText.setText("Custom Dialog!");
        new AlertDialog.Builder(this)
                .setTitle("Custom dialog")
                .setView(customBinding.getRoot())
                .setIcon(R.drawable.ic_baseline_rabbit_24)
                .setPositiveButton("Positive", bc::accept)
                .setNeutralButton("Neutral", bc::accept)
                .setNegativeButton("Negative", bc::accept)
                .show();
    }

    private void datePickerDialog(View view) {
        DatePickerDialog dialog = new DatePickerDialog(this);
        dialog.setTitle("Pick date!");
        dialog.setOnDateSetListener((picker, year, month, date) -> {
            binding.statusText.setText(String.format("Date picker(%d/%d/%d)", year, month + 1, date));
        });
        dialog.show();
    }

    private void timePickerDialog(View view) {
        Calendar calendar = Calendar.getInstance();
        new TimePickerDialog(
                this,
                (picker, hour, minute) -> {
                    binding.statusText.setText(String.format("Time picker (%d:%d)", hour, minute));
                },
                calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),
                false)
                .show();
    }

    private void listDialog(View view) {
        String[] items = new String[]{"Apple", "Orange", "Banana", "Strawberry"};
        new AlertDialog.Builder(this)
                .setTitle("List dialog")
                .setItems(items, (dialog, which) -> {
                    binding.statusText.setText("List dialog - " + items[which]);
                })
                .show();
    }

    private void customListDialog(View view) {
        String[] data2 = new String[]{"title1", "title2", "title3"};
        int[] data3 = new int[]{R.drawable.ic_baseline_rabbit_24, R.drawable.ic_baseline_rabbit_24, R.drawable.ic_baseline_rabbit_24};

        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < data2.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("data2", data2[i]);
            map.put("data3", data3[i]);
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.list_item,
                new String[]{"data2", "data3"},
                new int[]{R.id.item_text, R.id.item_image}
        );

        new AlertDialog.Builder(this)
                .setTitle("List dialog")
                .setAdapter(adapter, (dialog, which) -> {
                    binding.statusText.setText("Custom list dialog - " + data2[which]);
                })
                .show();
    }

    private void singleChoiceDialog(View view) {
        String[] items = new String[]{"Apple", "Orange", "Banana", "Strawberry"};
        new AlertDialog.Builder(this)
                .setTitle("Single choice dialog")
                .setSingleChoiceItems(items, 0, (dialog, which) -> {
                    binding.statusText.setText("Single choice dialog - " + items[which]);
                    dialog.dismiss();
                })
                .show();
    }

    private void multiChoiceDialog(View view) {
        String[] items = new String[]{"Apple", "Orange", "Banana", "Strawberry"};
        boolean[] checked = new boolean[items.length];
        new AlertDialog.Builder(this)
                .setTitle("Single choice dialog")
                .setMultiChoiceItems(items, checked, (dialog, which, isChecked) -> {
                    binding.statusText.setText("Multi choice dialog - ");
                    if (isChecked)
                        binding.statusText.append("checked " + items[which]);
                    else
                        binding.statusText.append("unchecked " + items[which]);
                })
                .setPositiveButton("선택", (dialog, which) -> {
                    binding.statusText.setText("Multi choice dialog - ");
                    SparseBooleanArray arr = ((AlertDialog) dialog).getListView().getCheckedItemPositions();
                    for (int i = 0; i < items.length; i++) {
                        if (arr.get(i))
                            binding.statusText.append(items[i] + " ");
                    }
                })
                .show();
    }

    private void createNotificationChannel(String id, String name) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = manager.getNotificationChannel(id);
            if (channel == null) {
                channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
                channel.enableVibration(true);
                manager.createNotificationChannel(channel);
            }
        }
    }

    private void notification(View view) {
        final String channelId = "CHANNEL_1";
        final String channelName = "general";
        final int messageId = 10;

        createNotificationChannel(channelId, channelName);
        PendingIntent contentIntent = PendingIntent.getActivity(
                this,
                10,
                new Intent(this, MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        PendingIntent browserIntent = PendingIntent.getActivity(
                this,
                10,
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")),
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        PendingIntent dialIntent = PendingIntent.getActivity(
                this,
                10,
                new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678")),
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.ic_baseline_rabbit_24)
                        .setNumber(1)
                        .setContentTitle("Notification title")
                        .setContentText("Notification text!")
                        .setContentIntent(contentIntent)
                        .addAction(
                                new NotificationCompat.Action.Builder(
                                        android.R.drawable.ic_menu_compass, "Browse", browserIntent
                                ).build()
                        )
                        .addAction(
                                new NotificationCompat.Action.Builder(
                                        android.R.drawable.ic_menu_call, "Dial", dialIntent
                                ).build()
                        )
                        .setAutoCancel(true);
        manager.notify(messageId, builder.build());
    }

    private void bigPictureNotification(View view) {
        createNotificationChannel(channelId, channelName);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.orange);
        Notification notification =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(android.R.drawable.ic_menu_camera)
                        .setContentTitle("Notification title")
                        .setContentText("Notification text!")
                        .setAutoCancel(true)
                        .setLargeIcon(bitmap)
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(bitmap)
                                .bigLargeIcon(null)
                                .setBigContentTitle("Big Picture Title")
                                .setSummaryText("Delicious orange!"))
                        .build();
        manager.notify(11, notification);
    }

    private void bigTextNotification(View view) {
        createNotificationChannel(channelId, channelName);
        Notification notification =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(android.R.drawable.ic_menu_camera)
                        .setContentTitle("Notification title")
                        .setContentText("Notification text!")
                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .setBigContentTitle("Big Text Title")
                                .setSummaryText("Summary Text")
                                .bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam odio erat, gravida vel dignissim nec, rutrum sed eros. Mauris leo dui, placerat non odio a, pharetra tristique risus. Vestibulum nec lorem quis tellus venenatis aliquam. Ut sit amet ante in dui ornare tincidunt. Nam non massa dolor. Mauris tempus interdum dolor, a sollicitudin lorem imperdiet eu. Vivamus risus nulla, viverra sit amet mollis scelerisque, tincidunt vel lectus. Nam in aliquam nisi.")
                        )
                        .build();
        manager.notify(11, notification);
    }

    private void inBoxNotification(View view) {
        createNotificationChannel(channelId, channelName);
        Notification notification =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(android.R.drawable.ic_menu_camera)
                        .setContentTitle("Notification title")
                        .setContentText("Notification text!")
                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.InboxStyle()
                                .setBigContentTitle("Inbox Title")
                                .setSummaryText("Summary Text")
                                .addLine("11111111111111111111111")
                                .addLine("11111111111111111111111"))
                        .build();
        manager.notify(11, notification);
    }

    private void messagingNotification(View view) {
        createNotificationChannel(channelId, channelName);

        Person person1 = new Person.Builder()
                .setIcon(IconCompat.createWithResource(this, android.R.drawable.ic_menu_help))
                .setName("person1")
                .build();
        Person person2 = new Person.Builder()
                .setIcon(IconCompat.createWithResource(this, android.R.drawable.ic_menu_agenda))
                .setName("person2")
                .build();

        Notification notification =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(android.R.drawable.ic_menu_camera)
                        .setContentTitle("Notification title")
                        .setContentText("Notification text!")
                        .setAutoCancel(true)
                        .setStyle(
                                new NotificationCompat.MessagingStyle(person1)
                                        .addMessage("첫 번째 메시지", System.currentTimeMillis(), person1)
                                        .addMessage("두 번째 메시지", System.currentTimeMillis(), person2)
                                        .addMessage("세 번째 메시지", System.currentTimeMillis(), person1)
                                        .addMessage("네 번째 메시지", System.currentTimeMillis(), person2)
                        )
                        .build();

        manager.notify(11, notification);
    }
}