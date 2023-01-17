package com.leeseungyun1020.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.leeseungyun1020.fragment.databinding.FragmentListBinding;

public class ListFragment extends androidx.fragment.app.ListFragment {

    private final String[] items = {
            "항목1", "항목2", "항목3", "항목4", "항목5", "항목6"
    };
    private FragmentListBinding binding;

    public ListFragment() {
        // Required empty public constructor
    }

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, items
        );
        setListAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        binding.listSelectText.setText(items[position]);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}