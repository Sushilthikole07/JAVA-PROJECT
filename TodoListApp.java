import java.util.ArrayList;
import java.util.Scanner;

class TodoItem {
    String task;
    boolean isCompleted;

    public TodoItem(String task) {
        this.task = task;
        this.isCompleted = false;
    }

    public void markAsComplete() {
        this.isCompleted = true;
    }

    public String toString() {
        return (isCompleted ? "[Completed] " : "[Not Completed] ") + task;
    }
}

public class TodoListApp {
    static ArrayList<TodoItem> todoList = new ArrayList<>();

    public static void displayMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add a task");
        System.out.println("2. View all tasks");
        System.out.println("3. Mark a task as complete");
        System.out.println("4. Remove a task");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    public static void addTask(Scanner scanner) {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        TodoItem newItem = new TodoItem(task);
        todoList.add(newItem);
        System.out.println("Task added!");
    }

    public static void viewTasks() {
        if (todoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("\n--- To-Do List ---");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    public static void markTaskAsComplete(Scanner scanner) {
        viewTasks();
        if (!todoList.isEmpty()) {
            System.out.print("Enter the task number to mark as complete: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (taskNumber > 0 && taskNumber <= todoList.size()) {
                todoList.get(taskNumber - 1).markAsComplete();
                System.out.println("Task marked as complete!");
            } else {
                System.out.println("Invalid task number!");
            }
        }
    }

    public static void removeTask(Scanner scanner) {
        viewTasks();
        if (!todoList.isEmpty()) {
            System.out.print("Enter the task number to remove: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (taskNumber > 0 && taskNumber <= todoList.size()) {
                todoList.remove(taskNumber - 1);
                System.out.println("Task removed!");
            } else {
                System.out.println("Invalid task number!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsComplete(scanner);
                    break;
                case 4:
                    removeTask(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the to-do list app. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }
}
