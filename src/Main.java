import java.util.Scanner;
public class Main {
    static int a;
    static int b;
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);          // создаем объект сканнер
        System.out.println("Введите арифметическое выражение"); // просим ввести строку с арифметическим выражением
        String input = sc.nextLine();               // считываем введенную строку
        String output = calc(input);               // вызываем метод calc для строки c ответом, которую будем выводить в консоль
        System.out.println(output);               // выводим в консоль строку с ответом
    }
    public static String calc(String input) {           // инициируем метод calc
        String[] strings = input.split("\\+");   // метод делит введенную строку на две подстроки с помощью разделителя +
        if (strings.length == 2) {                    // создаем условие: если длина массива - 2 строки,
            a = convertToInt(input, strings [0]);    // то вызывается функция convertToInt,
            b = convertToInt(input, strings [1]);   // которая преобразует а и b в int
            throwException();                       // выбрасываем исключение, если а или b меньше 1 и больше 10.
            int x = a + b;                         // считаем операцию со знаком, по которому делили строку на две
            return convertToString(input,x);      // переводим int в строку с римскими или арабскими и возвращаем строку с ответом
        }
        strings = input.split("-");         // метод делит введенную строку на две подстроки с помощью разделителя -
        if (strings.length == 2) {
            a = convertToInt(input, strings [0]);
            b = convertToInt(input, strings [1]);
            throwException();
            int x = a - b;
            return convertToString(input,x);
        }
        strings = input.split("\\*");            //метод делит введенную строку на две подстроки с помощью разделителя *
        if (strings.length == 2) {
            a = convertToInt(input, strings [0]);
            b = convertToInt(input, strings [1]);
            throwException();
            int x = a * b;
            return convertToString(input,x);
        }
       strings = input.split("/");       // метод делит введенную строку на две подстроки с помощью разделителя /
        if (strings.length == 2) {
            a = convertToInt(input, strings [0]);
            b = convertToInt(input, strings [1]);
            throwException();
            int x = a / b;
            return convertToString(input,x);
        }                       // если условие не выполняется, выбрасывается исключение
        throw new IllegalArgumentException("Вы ввели некорректный символ операции или операция не соответствует заданию");
    }
    public static int convertToInt(String input, String y) { // инициируем функцию convertToInt, чтобы перевести а и b в int
        if (input.contains("I") || input.contains("V") || input.contains("X")) { // ставим условие, что если строка содержит один из этих символов,
            return Romans.valueOf(y).arab;      //то нужно найти элемент в энаме и вернуть соответствющее ему число
        } else {                               // если строка не содержит подобных символов, то
            return Integer.parseInt(y);       // преобразуем их в числа
        }
    }
    public static void throwException() {
        if (a <= 0 || a > 10 || b <= 0 || b > 10) {
            throw new IllegalArgumentException("Вы ввели некорректное число");
        }
    }
    public static String convertToString(String input, int x) { // инициируем функцию convertToString, чтобы перевести результат операции в строку
        if (input.contains("I") || input.contains("V") || input.contains("X")) {//создаем условие: если введенная строка содержала римские цифры,
            for (Romans num : Romans.values()) { // то нужно зайти в энам и
                if (num.arab == x) {             // найти соотвествия между арабским результатом и римским числом в энаме
                    return num.name();          // и вернуть строку с римским числом = результату операции
                }
            }
        } else {
            return Integer.toString(x); // если строка не содержала римских цифр, значит, результат - это арабское число и его просто преобразовавыем в строку
        }
        throw new IllegalArgumentException("Результат невозможен"); //если полученный результат не попадает ни под одно из условий, выбрасывается исключение
    }
}