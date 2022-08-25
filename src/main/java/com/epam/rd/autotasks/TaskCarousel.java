package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {
    private final int MAX_COUNTER;
    private int taskSpinCounter = 0;
    private final List<Task> taskList = new ArrayList<>();

    public TaskCarousel(int capacity) {
        if (capacity < 0) {
            throw new UnsupportedOperationException();
        }
        MAX_COUNTER = capacity;
    }

    public boolean addTask(Task task) {
        if (!isFull() && !task.isFinished()) {
            taskList.add(task);
            return true;
        }
        return false;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        rewriteSpinCounter();
        taskList.get(taskSpinCounter).execute();
        if (taskList.get(taskSpinCounter).isFinished()) {
            taskList.remove(taskSpinCounter);
        } else {
            taskSpinCounter++;
        }
        return true;
    }

    public boolean isFull() {
        return taskList.size() == MAX_COUNTER;
    }

    public boolean isEmpty() {
        return taskList.size() == 0;
    }

    private void rewriteSpinCounter() {
        if (taskSpinCounter >= taskList.size()) {
            taskSpinCounter = 0;
        }
    }

}
