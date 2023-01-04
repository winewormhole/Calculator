import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    private static double a;
    private static double b;
    private static String operation;
    private static final String NUMBER = "Введи число: ";
    private static final String OPERATION = "Операция: ";
    private static String[] operations = new String[]{"+", "-", "*", "/"};

    public static void UserWork() {
        start();
        Scanner scanner = new Scanner(System.in);

        System.out.print(NUMBER);
        try {a = scanner.nextDouble();}
        catch (Exception e){
            System.out.println("Введи число");
            System.exit(0);               // это я захотел, чтобы программа завершилась, если ввести не число, хз, наверно можно как-то прикольней это сделать
        }

        System.out.print(OPERATION);
        boolean found = false;
        while (found == false) {                // а тут я типа проверяю есть ли такая операция в арсенале моего охуевшего калькулятора
            operation = scanner.next();
            found = Arrays.asList(operations).contains(operation);
            if (found == false) {
                System.out.println("Выбери операцию из списка!");
                System.out.print(OPERATION);
            }
        }

        System.out.print(NUMBER);
        try {b = scanner.nextDouble();}
        catch (Exception e){
            System.out.println("Введи число");
            System.exit(0);
        }

        System.out.println("Результат: " + calculatorWork());
    }
    private static double calculatorWork() {     // создал отдельный метод для расчетов
        double result = 0;
        switch (operation) {                     // свич для тебя специально ♥
            case "+" :
                result = a + b;
                break;
            case "-" :
                result = a - b;
                break;
            case "*" :
                result = a * b;
                break;
            case "/" :
                result = a / b;
                break;
        }
        return result;
    }

    private static void start() {    // нах не нужный метод, на случай, если добавлю еще операцию в массив с операциями, то он сам выведет на экран
        System.out.print("В этом крутом калькуляторе можно использовать знаки:");
        for (String str : operations) {
            System.out.print(" " + str);
        }
        System.out.println();
    }
}
