import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> todoList = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("0. Выход");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить по номеру");
            System.out.println("4. Удалить по названию");
            System.out.print("Ваш выбор: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 0:
                        System.out.println("Программа завершена.");
                        return;
                    case 1:
                        System.out.print("Введите задачу: ");
                        String task = scanner.nextLine();
                        if (!todoList.contains(task)) {
                            todoList.add(task);
                            System.out.println("Добавлено.");
                        } else {
                            System.out.println("Эта задача уже есть.");
                        }
                        break;
                    case 2:
                        System.out.println("Ваш список дел:");
                        if (todoList.isEmpty()) {
                            System.out.println("Список пуст.");
                        } else {
                            for (int i = 0; i < todoList.size(); i++) {
                                System.out.println((i + 1) + ". " + todoList.get(i));
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Введите номер для удаления: ");
                        try {
                            int index = Integer.parseInt(scanner.nextLine());
                            if (index > 0 && index <= todoList.size()) {
                                todoList.remove(index - 1);
                                System.out.println("Удалено.");
                            } else {
                                System.out.println("Неверный номер.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный формат ввода.");
                        }
                        break;
                    case 4:
                        System.out.print("Введите задачу для удаления: ");
                        String taskToRemove = scanner.nextLine();
                        if (todoList.remove(taskToRemove)) {
                            System.out.println("Удалено.");
                        } else {
                            System.out.println("Задача не найдена.");
                        }
                        break;
                    default:
                        System.out.println("Неверный ввод. Попробуйте ещё раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода. Пожалуйста, введите число.");
            }
        }
    }
}
