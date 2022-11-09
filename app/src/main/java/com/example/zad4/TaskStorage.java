package com.example.zad4;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {

    private static final TaskStorage taskStorage = new TaskStorage();

    private final List<Task> tasks;

    public static TaskStorage getInstance() {
        return taskStorage;
    }

    private TaskStorage() {
        tasks = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {

            Task task = new Task();
            task.setDone(i % 3 == 0);
            if(i % 3 == 0){
                task.setName("Zadanie na studia " + i);
                task.setCategory(Category.STUDIES);
                task.setDetails("STUDIA");
                task.setDone(true);
            }
            else{
                task.setName("Zadanie do domu " + i );
                task.setCategory(Category.HOME);
                task.setDetails("DOM");
            }
            tasks.add(task);
        }

    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public Task getTask(UUID taskId) {
        Task task = new Task();
        for (Task t : tasks) {
            if (t.getId().equals(taskId)) task = t;
        }
        return task;
    }

}
