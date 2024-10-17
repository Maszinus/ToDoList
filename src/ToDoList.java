import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj nowe zadanie");
            System.out.println("2. Oznacz zadanie jako zakończone");
            System.out.println("3. Usuń zadanie");
            System.out.println("4. Wyświetl listę zadań");
            System.out.println("5. Wyjście");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    markTaskAsCompleted(scanner);
                    break;
                case 3:
                    removeTask(scanner);
                    break;
                case 4:
                    displayTasks();
                    break;
                case 5:
                    System.out.println("Koniec programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja. Spróbuj ponownie.");
            }

        } while (option != 5);

        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Podaj nazwę zadania: ");
        String name = scanner.nextLine();
        System.out.print("Podaj opis zadania: ");
        String description = scanner.nextLine();
        tasks.add(new Task(name, description));
        System.out.println("Zadanie \"" + name + "\" zostało dodane do listy.");
    }

    private static void markTaskAsCompleted(Scanner scanner) {
        displayTasks();
        System.out.print("Podaj numer zadania do oznaczenia jako zakończone: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).markAsCompleted();
            System.out.println("Zadanie \"" + tasks.get(taskNumber - 1).getName() + "\" zostało oznaczone jako zakończone.");
        } else {
            System.out.println("Nieprawidłowy numer zadania.");
        }
    }

    private static void removeTask(Scanner scanner) {
        displayTasks();
        System.out.print("Podaj numer zadania do usunięcia: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            System.out.println("Zadanie \"" + tasks.get(taskNumber - 1).getName() + "\" zostało usunięte z listy.");
            tasks.remove(taskNumber - 1);
        } else {
            System.out.println("Nieprawidłowy numer zadania.");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("(brak zadań)");
        } else {
            System.out.println("Lista zadań:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}