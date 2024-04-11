package com.dmm.task.service;

import java.util.List;

import com.dmm.task.data.entity.Task;
import com.dmm.task.data.repository.TaskRepository;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getUserTasks(String username) {
        // usernameから登録されたタスクを取得する
        return taskRepository.findByUsername(username);
    }
}