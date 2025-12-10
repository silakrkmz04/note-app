package com.example.to_doapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.example.to_doapp.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class ToDoListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_todo_list);  //activity xml'ini yükler

        taskList = new ArrayList<>();  //yeni array listim


        createTestData();  //test verilerini hazırlamak için

        recyclerView = findViewById(R.id.rv_tasks);

        taskAdapter = new TaskAdapter(this,taskList);
        recyclerView.setAdapter(taskAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FloatingActionButton fabAddTask = findViewById(R.id.fab_add_task); //artı butonum

        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            QuickActionMenuFragment menuFragment = new QuickActionMenuFragment();
            menuFragment.show(getSupportFragmentManager(), "QuickActionMenuTag");

               // bunu test etmek için ekliyorum: çalıştı: Toast.makeText(ToDoListActivity.this, "artı butonuna tıkladım", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void createTestData(){ // Test verilerini oluşturan metod

        // Örnek görev verileri:
        taskList.add(new Task("Read for bookclub", "Personal", false));
        taskList.add(new Task("Proje teklifi gözden geçir", "Work", false));
        taskList.add(new Task("Sabah yogasını kaçırma", "Health", false));
        taskList.add(new Task("Yeni şapka tasarımı", "School", false));
        taskList.add(new Task("E-posta kutusunu temizle", "Work", false));
        taskList.add(new Task("Aylık raporu bitir", "Work", false));
        taskList.add(new Task("Ailenle görüş", "Personal", false));
        taskList.add(new Task("10000 adım at", "Health", false));
        taskList.add(new Task("Android kodunu bitir", "School", false));
        taskList.add(new Task("Yeni bir dil öğren ", "School", true));
    }
}