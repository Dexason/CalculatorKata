import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerException {
        calc();
    }

    public static String calc() throws ScannerException {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите нужную операцию: ");
        var strOp = s.nextLine();
        List<String> symbolList = new ArrayList<>(Arrays.asList(strOp.split(" ")));
        if((Roman.isRoman(symbolList.get(0)) && !(Roman.isRoman(symbolList.get(2)))) || !(Roman.isRoman(symbolList.get(0)) && Roman.isRoman(symbolList.get(2)))) {
            throw new ScannerException("Оба числа должны быть либо римскими, либо арабскими");
        }
        if(symbolList.size() > 3) {
            throw new ScannerException("Формат математической операции не удовлетворяет требованиям - два операнда и один оператор (+, -, /, *)");
        }
        var oneNumber = Integer.parseInt(RomanNumeral.romanToArabic(symbolList.get(0)));
        var operationSymbol = symbolList.get(1);
        var twoNumber = Integer.parseInt(RomanNumeral.romanToArabic(symbolList.get(2)));
        int result;
        if ((oneNumber > 10 || oneNumber < 1) || (twoNumber > 10 || twoNumber < 1)) {
            throw new ScannerException("Введите число от 1 до 10 или от I до X");
            }
            switch (operationSymbol) {
                case "*" -> {
                    result = oneNumber * twoNumber;
                    if((Roman.isRoman(symbolList.get(0)) && Roman.isRoman(symbolList.get(2)))) {
                        System.out.println("Результат: " + IntegerConverter.intToRoman(result));
                        break;
                    }
                    System.out.println("Результат: " + result);
                }
                case "/" -> {
                    result = oneNumber / twoNumber;
                    if((Roman.isRoman(symbolList.get(0)) && Roman.isRoman(symbolList.get(2)))) {
                        System.out.println("Результат: " + IntegerConverter.intToRoman(result));
                        break;
                    }
                    System.out.println("Результат: " + result);
                }
                case "+" -> {
                    result = oneNumber + twoNumber;
                    if((Roman.isRoman(symbolList.get(0)) && Roman.isRoman(symbolList.get(2)))) {
                        System.out.println("Результат: " + IntegerConverter.intToRoman(result));
                        break;
                    }
                    System.out.println("Результат: " + result);
                }
                case "-" -> {
                    result = oneNumber - twoNumber;
                    if((Roman.isRoman(symbolList.get(0)) && Roman.isRoman(symbolList.get(2))) && result < 0) {
                        throw new ScannerException("В римской системе нет отрицательных чисел");
                    }
                    if((Roman.isRoman(symbolList.get(0)) && Roman.isRoman(symbolList.get(2)))) {
                        System.out.println("Результат: " + IntegerConverter.intToRoman(result));
                        break;
                    }
                    System.out.println("Результат: " + result);
                }
                default -> throw new ScannerException("Введите *, /, -, +");
            }
        return String.valueOf(result);
        }
    }
