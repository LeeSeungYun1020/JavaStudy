package com.leeseungyun1020.messaging;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.leeseungyun1020.messaging.databinding.ActivityMainBinding;
import com.leeseungyun1020.messaging.databinding.CustomLayoutBinding;

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
}