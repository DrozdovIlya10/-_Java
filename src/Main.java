import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException{
        while (true){
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String output;
            int c = calc(input);
            if (input.contains("I")==true || input.contains("V")==true || input.contains("X")==true ){
                if (c <= 0) throw new MyException(" В римской системе нет отрицательных чисел");  // Проверка на отрицательные значения в римском изчислении
                output = arabicToRoman(c);     // Функция перевод из Int в String(римское изчисление)
               System.out.println(output);
            }else{
                System.out.println(Integer.toString(c));// Функция перевод из Int в String(арабское изчисление)
            }
        }

    }

    public static int calc(String input) throws MyException {
        int a = 0,b = 0,c = 0;
        String plus = "+";
        String minus = "-";
        String multiply = "*";
        String separate = "/";
        String[] array = input.split(" "); // Массив для проверки правильности вырожений
        String[] arraytest = new String[4];
        int j = 0;
        try {                           // Проверка на правильность вырожения
            arraytest[0] = array[0];
            arraytest[1] = array[1];
            arraytest[2] = array[2];
        }catch (ArrayIndexOutOfBoundsException e) {
            throw new MyException("Cтрока не является математической операцией");
        }
        try {                           // Проверка на правильность вырожения
            arraytest[3] = array[3];
            throw new MyException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        }catch (ArrayIndexOutOfBoundsException e) {
        }

        if (array[1].equals(plus) || array[1].equals(minus) || array[1].equals(multiply) || array[1].equals(separate)){}      // Проверка на правильность оператора
        else throw new MyException(" Операнд не соответствует заданию (+, -, *, /)");
        if (array[0] == null ||array[1] == null || array[2] == null) throw new MyException(" Cтрока не является математической операцией ");
        int x = 0;
        if (input.contains("I")==true || input.contains("V")==true || input.contains("X")==true ){         // Определение в каком изчислении проводится операция
            if (input.contains("1") == true || input.contains("2") == true || input.contains("3") == true||
                    input.contains("4") == true || input.contains("0") == true ||
                    input.contains("5") == true|| input.contains("6") == true ||
                    input.contains("7") == true || input.contains("8") == true || input.contains("9") == true){
                throw new MyException("Используются одновременно разные системы счисления");
            }
            for (int i = 0; i < 3; i++){            // Цикл перевода вырожения в римском изчислении из String в Int
                if (array[i].equals(plus) || array[i].equals(minus) || array[i].equals(multiply) || array[i].equals(separate)) {
                } else {
                    if (x == 0) {
                        a = Array(array[i]);
                        x++;
                    }else {
                        b = Array(array[i]);
                    }
                }

            }
        }else {
            for (int i = 0; i < 3; i++) {           // Цикл перевода вырожения в арабском изчислении из String в Int
                if (array[i].equals(plus) || array[i].equals(minus) || array[i].equals(multiply) || array[i].equals(separate)) {
                } else {
                    if (x == 0) {
                        a = Integer.parseInt(array[i].trim());
                        if (a > 10) throw new MyException(" Запрещено использовать числа больше 10");
                        x++;
                    } else {
                        b = Integer.parseInt(array[i].trim());
                        if (b > 10) throw new MyException(" Запрещено использовать числа больше 10");
                    }
                }
            }
        }
            if (array[1].equals(plus)) // Выполнение сложения
                c = a + b;
            if (array[1].equals(minus))// Выполнение вычитание
                c = a - b;
            if (array[1].equals(multiply))// Выполнение умножение
                c = a * b;
            if (array[1].equals(separate))// Выполнение деление
                c = a / b;

            return c;
    }
    public static int Array (String array)throws MyException{ // Функция для перевода из римского изчислени в арабское
        int arr = 0;
        if (array.equals("I")){
            arr = 1;
        }
        if (array.equals("II")){
            arr = 2;
        }
        if (array.equals("III")){
            arr = 3;
        }
        if (array.equals("IV")){
            arr = 4;
        }
        if (array.equals("V")){
            arr = 5;
        }
        if (array.equals("VI")){
            arr = 6;
        }
        if (array.equals("VII")){
            arr = 7;
        }
        if (array.equals("VIII")){
            arr = 8;
        }
        if (array.equals("IX")){
            arr = 9;
        }
        if (array.equals("X")) {
            arr = 10;
        }
        if (arr == 0) throw new MyException(" Запрещено использовать числа больше X");
        return arr;
    }
    public static String arabicToRoman( int number){  // Функция для перевода из арбского изчислени в римское
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s = roman[number];
        return s;
    }
    public static class MyException extends Exception{ // Функция для вызова исключения
        public MyException(String description){
            super(description);
        }
    }
}
