package com.example.to_doapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.w3c.dom.Text;


public class QuickActionMenuFragment extends BottomSheetDialogFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_quick_action_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        TextView btnNewTask = view.findViewById(R.id.btn_new_task);
        btnNewTask.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), EnterTaskActivity.class);
            startActivity(intent);
            dismiss();
        });
        TextView btnNewManifest = view.findViewById(R.id.btn_new_manifest);
        btnNewManifest.setOnClickListener(v->{
            Intent intent = new Intent(getActivity(), EnterTaskActivity.class);
            startActivity(intent);
            dismiss();
        });
    }
}