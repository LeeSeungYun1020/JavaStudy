package com.leeseungyun1020.fragment;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.leeseungyun1020.fragment.databinding.FragmentDialogBinding;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    FragmentDialogBinding binding;

    public DialogFragment() {
        // Required empty public constructor
    }


    public static DialogFragment newInstance() {
        DialogFragment fragment = new DialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDialogBinding.inflate(inflater, container, false);
        binding.dialogCancelButton.setOnClickListener((button) -> {
            this.dismiss();
        });
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int style = DialogFragment.STYLE_NO_TITLE, theme = 0;
        setStyle(style, theme);
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        Window window = getDialog().getWindow();
        Point size = new Point();
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        window.setLayout((int) (width * 0.75), (int) (height * 0.5));
        window.setGravity(Gravity.CENTER);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requireDialog().setTitle("New Dialog");
    }

//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        AlertDialog dialog = new AlertDialog.Builder(requireActivity())
//                .setTitle("Title")
//                .setMessage("Message")
//                .setPositiveButton("ok", (dialogInterface, i) -> {
//
//                })
//                .create();
//        return dialog;
//    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}