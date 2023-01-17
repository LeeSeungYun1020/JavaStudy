package com.leeseungyun1020.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.leeseungyun1020.fragment.databinding.FragmentBasicBinding;

public class BasicFragment extends Fragment {
    private FragmentBasicBinding binding;

    public BasicFragment() {
        // Required empty public constructor
    }

    public static BasicFragment newInstance() {
        BasicFragment fragment = new BasicFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBasicBinding.inflate(inflater, container, false);

        binding.editButton.setOnClickListener((button) -> {
            ((MainActivity) requireActivity()).binding.statusText.setText(binding.editText.getText().toString());
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}