package controller;

import entity.Task;
import tasksRepository.TasksRepository;
import java.sql.SQLException;
import java.util.ArrayList;

public class TasksController {
    TasksRepository tasksRepository = new TasksRepository();
    ArrayList<Task> tasks = new ArrayList<Task>();
    Task task = new Task();

    public String addTask(Task task) {
        try {
            tasksRepository.addTask(task);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with adding task";
        }
        return "Task added successfully";
    }

    public ArrayList<Task> getAll() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        try {
            tasks = tasksRepository.getAll();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tasks;
    }


    public ArrayList<Task> findActiveTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        try {
            tasks = tasksRepository.findActiveTasks();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tasks;
    }

    public String delete(Task task) {
        try {
            tasksRepository.delete(task);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with deleting task";
        }
        return "Task Nr.  " + task.getID() + " deleted successfully";
    }


    public String markTaskAsDone(Task task) {
        try {
            task = tasksRepository.markTaskAsDone(task);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "Task Nr. " + task.getID() + " is DONE";
    }


}
