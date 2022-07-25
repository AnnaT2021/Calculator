import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int operanda1, operanda2;
    public static char operator;
    public static int res;
    static String result;
    public static String[] arabNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static String[] latinNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] latinResult = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); //объявляем сканнер
        System.out.println("Введите арифметическое выражение в формате '1 + 2' или 'I * V' и нажмите Enter");
        String vvod = scanner.nextLine(); //Считываем введенное выражение из консоли
        System.out.println(calc(vvod)); //вывод результата
    }

    public static String calc(String input) throws IOException {
        String[] massInput = input.split(" "); //делим массив на тря элимента пробелом
        if (massInput.length != 3) {  //если больше или меньше 3х элементов, то программа выбрасывает исключение
            throw new IOException();
        }
        String str1 = massInput[0];// делим массив на 3 элемента
        String str2 = massInput[1];
        String str3 = massInput[2];
        operator = str2.charAt(0);  // вытаскиваем элемент [1] char, в str2 один элемент, поэтому (0)

        boolean flag1 = false; //ставим флаги
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;

        for (int i = 0; i < latinNum.length; i++) //проверяем str1 и str3 латинская или арабская цифра введена
            if (latinNum[i].equals(str1)) {
                flag1 = true;
            }
        for (int i = 0; i < latinNum.length; i++)
            if (latinNum[i].equals(str3)) {
                flag2 = true;
            }
        for (int i = 0; i < arabNum.length; i++)
            if (arabNum[i].equals(str1)) {
                flag3 = true;
            }
        for (int i = 0; i < arabNum.length; i++)
            if (arabNum[i].equals(str3)) {
                flag4 = true;
            }
        if (flag1 && flag2) { //если введены обе цифры латинские
            operanda1 = Integer.parseInt(latinToArab(str1)); //преобразуем String в int
            operanda2 = Integer.parseInt(latinToArab(str3));
            methodCalc(operanda1, operanda2); //вызываем метод, в кт считаем
            if (res >= 1) {
                result = latinResult[res - 1];
            } else {
                throw new IOException(); // выкидываем искл
            }
        } else {
            if (flag3 && flag4) { // если введены обе цифры арабские
                for (int i = 0; i < arabNum.length; i++) {
                    if (arabNum[i].equals(str1)) {
                        operanda1 = i + 1;
                    }
                    if (arabNum[i].equals(str3)) {
                        operanda2 = i + 1;
                    }
                }
                methodCalc(operanda1, operanda2); //вызываем метод для рассчета
                result = String.valueOf(res);
            } else {
                throw new IOException(); //выбрасываем исключ
            }
        }
        return result;
    }
    static String latinToArab(String str) { //создаем метод: преобразуе латинские цифры в арабские
        for (int i = 0; i < latinNum.length; i++) {
            if (latinNum[i].equals(str)) {
                str = arabNum[i];
            }
        }
        return str;
    }

    static int methodCalc(int op1, int op2) throws IOException { // создаем метод: для выполнения арифм опер
        switch (operator) {
            case ('+'):
                res = op1 + op2;
                break;
            case ('-'):
                res = op1 - op2;
                break;
            case ('*'):
                res = op1 * op2;
                break;
            case ('/'):
                res = op1 / op2;
                break;
            default: {
                throw new IOException(); // выбрасываем исключ
            }
        }
        return res;
    }
}
