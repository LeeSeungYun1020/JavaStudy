package com.leeseungyun1020.messaging;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.leeseungyun1020.messaging.databinding.ActivityMainBinding;
import com.leeseungyun1020.messaging.databinding.CustomLayoutBinding;

import java.util.Calendar;
import java.util.function.ObjIntConsumer;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toastButton.setOnClickListener(this::toast);
        binding.snackbarButton.setOnClickListener(this::snackbar);
        binding.snackbarCustomButton.setOnClickListener(this::snackbarCustom);
        binding.commonDialogButton.setOnClickListener(this::commonDialog);
        binding.customDialogButton.setOnClickListener(this::customDialog);
        binding.datepickerDialogButton.setOnClickListener(this::datePickerDialog);
        binding.timepickerDialogButton.setOnClickListener(this::timePickerDialog);
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
}