package com.example.to_doapp;

public class Task {
    private String title;
    private String category;
    private boolean isCompleted;

    public Task(String title, String category, boolean isCompleted) {
        this.title = title;
        this.category = category;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
