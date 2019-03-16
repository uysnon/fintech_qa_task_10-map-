import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Главный класс работы.
 *
 * @author Gorkin Alexander
 * @version 0.1 16.03.2019
 */
public final class Main {
    /**
     * Хранилище пользовательских
     * логинов и паролей.
     */
    private static Map<String, String> logPassMap;

    /**
     * Приватный конструтор, недоступность
     * создать экзепляр данного класса извне.
     */
    private Main() {

    }

    /**
     * Запускааемый метод класса.
     *
     * @param args аргумент командной строки
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        logPassMap = new HashMap<>();
        String searchLogin;
        String searchPassword = null;
        System.out.println("Введи кол-во пользователей");
        int numRecords = scanner.nextInt();
        for (int i = 0; i < numRecords; i++) {
            String login;
            String password;
            System.out.println("(" + (i + 1) + ")");
            System.out.print("Введи логин:  ");
            login = scanner.next();
            System.out.print("Введи пароль:  ");
            password = scanner.next();
            logPassMap.put(login, password);
        }
        System.out.println();
        System.out.println("Список пользователей");
        for (Map.Entry<String, String> record : logPassMap.entrySet()) {
            System.out.println("логин: " + record.getKey()
                    + " пароль: " + record.getValue());
        }
        System.out.print("\nВведи логин для поиска: ");
        searchLogin = scanner.next();
        for (Map.Entry<String, String> record : logPassMap.entrySet()) {
            if (record.getKey().equals(searchLogin)) {
                searchPassword = record.getValue();
            }
        }
        if (searchPassword == null) {
            System.out.println("Пользователь не найден");
        } else {
            System.out.println("логин: " + searchLogin
                    + " пароль: " + searchPassword);
        }
        scanner.close();

    }

}
