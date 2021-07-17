import controller.TasksController;
import entity.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    Scanner scanner = new Scanner(System.in);
    TasksController tasksController = new TasksController();

    public void showHomeScreen() {

        String Option = "";
        do {
            System.out.println("\nTO DO LIST\n\n" +
                    "1. Add new task to the list \n2. Delete task from the list\n" +
                    "3. Mark task as DONE\n4. See all active tasks on your list\n5. View all Tasks\n" +
                    "6. Exit");


            System.out.print("\nChoose Option: ");
            Option = scanner.nextLine();

            switch (Option) {

                case "1":
                    addTask();
                    break;
                case "2":
                    delete();
                    break;
                case "3":
                    markTaskAsDone();
                    break;
                case "4":
                    findActiveTasks();
                    break;
                case "5":
                    getAll();
                    break;
                case "6":
                    System.out.println("Have a great day!");
                    return;
                default:
                    break;

            }
        } while (!Option.equals("6"));

        return;
    }


    public void addTask() {
        Task newTask = new Task();
        System.out.println("\nAdd a new Task");
        System.out.println("What is the TASK?:");
        newTask.taskName = scanner.nextLine();
        System.out.println("When is the DEADLINE?:");
        newTask.deadline = scanner.nextLine();
        System.out.println(tasksController.addTask(newTask));
    }

    public void delete() {
        Task delete = new Task();
        System.out.println("\nDelete a task");
        System.out.println("Enter task's ID:");
        delete.ID = Integer.parseInt(scanner.nextLine());
        System.out.println(tasksController.delete(delete));
    }

    public void markTaskAsDone() {
        Task update = new Task();
        System.out.println("\nMark task as DONE");
        System.out.println("Enter task's ID:");
        update.ID = Integer.parseInt(scanner.nextLine());
        System.out.println(tasksController.markTaskAsDone(update));
    }

    public void findActiveTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks = tasksController.findActiveTasks();
        System.out.println("\nThis is your active TODO list\n");
        System.out.println(
                "Tasks ID\t||\tWHAT TODO\t\t||\t\tWHEN TODO\t||\t\tSTATUS\n");

        for (Task currentTask : tasks) {
            System.out.println(
                    "\t" + currentTask.ID + "\t\t\t" + currentTask.taskName +
                            "\t\t\t" + currentTask.deadline + "\t\t\t\t" + currentTask.getStatusText());
        }
    }

    public void getAll() {
        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks = tasksController.getAll();
        System.out.println("\nAll tasks on your TODO list:\n");
        System.out.println(
                "Tasks ID\t||\t\tWHAT todo\t\t||\t\t\tWHEN TODO\t||\t\tSTATUS\n");

        for (Task currentTask : tasks) {
            System.out.println(
                    "\t"+ currentTask.ID + "\t\t\t\t" + currentTask.taskName +
                            "\t\t\t\t" + currentTask.deadline + "\t\t\t\t" + currentTask.getStatusText());
        }
    }
}