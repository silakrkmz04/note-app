package com.example.to_doapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.ColorStateList;
                                                                                                                                                                                                                                                                                                                                                                                                               import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList;
    private final Context context;

    public TaskAdapter(Context context, List<Task> taskList){
        this.context = context;
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_task_card, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position){
        Task task = taskList.get(position);

        holder.titleTxtVw.setText(task.getTitle());
        holder.categoryTxtVw.setText(task.getCategory());

        int drawableResId = getCategoryDrawable(task.getCategory());
        if (holder.cardBackgroundLayout != null){
            holder.cardBackgroundLayout.setBackgroundResource(drawableResId);
        }

        if (task.isCompleted()){
            holder.titleTxtVw.setPaintFlags(holder.titleTxtVw.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.checkImageView.setBackgroundTintList(
                    ColorStateList.valueOf(context.getColor(R.color.completed_check_bg)));

        }else {
             drawableResId = getCategoryDrawable(task.getCategory());
            holder.cardBackgroundLayout.setBackgroundResource(drawableResId);
            holder.titleTxtVw.setPaintFlags(holder.titleTxtVw.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.checkImageView.setBackgroundTintList(
                    ColorStateList.valueOf(context.getColor(R.color.color_check_default)));

        }

        holder.checkImageView.setOnClickListener(v->{
            boolean newStatus = !task.isCompleted();
            task.setCompleted(newStatus);

            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount(){

        return taskList.size();
    }

    private int getCategoryDrawable(String category){
        if (category == null) return R.drawable.bg_card_personal;
        switch (category){

            case "Work":
                return R.drawable.bg_card_work;
            case "Health":
                return R.drawable.bg_card_health;
            case "School":
                return R.drawable.bg_card_school;
            default:
                return R.drawable.bg_card_personal;
        }
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        public TextView titleTxtVw;
        public TextView categoryTxtVw;
        public ConstraintLayout cardBackgroundLayout;

        public ImageView checkImageView;
        public TaskViewHolder(@NonNull View itemView){
            super(itemView);
            titleTxtVw = itemView.findViewById(R.id.tv_task_title);
            categoryTxtVw = itemView.findViewById(R.id.tv_task_category);
            cardBackgroundLayout = itemView.findViewById(R.id.card_background_layout);
            checkImageView = itemView.findViewById(R.id.check_circle);
        }
    }
}
