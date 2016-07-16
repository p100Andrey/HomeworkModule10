package Homework;


public class CodingText {
    private final static char[] largeSimvoly =
            {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
                    'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    private final static char[] smallSimbol =
            {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
                    'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};

    private static final int numberLetters = 33;
    private static final int kay = 3;

    public String caesar(String input) {

        char[] outPutArr;
        outPutArr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int indexOfLargeSymbol = findLargeSymbol(c);
            int indexOfSmallSymbol = findSmallSymbol(c);
            if (c < 'А' || c > 'я') {
                outPutArr[i] = c;
            } else if (indexOfLargeSymbol != -1) {
                if ((indexOfLargeSymbol + kay) < numberLetters) {
                    outPutArr[i] = largeSimvoly[indexOfLargeSymbol + kay];
                } else outPutArr[i] = largeSimvoly[(indexOfLargeSymbol + kay) - numberLetters];
            } else {
                if ((indexOfSmallSymbol + kay) < numberLetters) {
                    outPutArr[i] = smallSimbol[indexOfSmallSymbol + kay];
                } else outPutArr[i] = smallSimbol[(indexOfSmallSymbol + kay) - numberLetters];
            }
        }
        return new String(outPutArr);
    }

    public String caesarDeshifrator(String input) {
        char[] outPutArr;
        outPutArr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int indexOfLargeSymbol = findLargeSymbol(c);
            int indexOfSmallSymbol = findSmallSymbol(c);
            if (c < 'А' || c > 'я') {
                outPutArr[i] = c;
            } else if (indexOfLargeSymbol != -1) {
                if ((indexOfLargeSymbol - kay) >= 0) outPutArr[i] = largeSimvoly[indexOfLargeSymbol - kay];
                else outPutArr[i] = largeSimvoly[(indexOfLargeSymbol - kay) + numberLetters];
            } else {
                if ((indexOfSmallSymbol - kay) >= 0) outPutArr[i] = smallSimbol[indexOfSmallSymbol - kay];
                else outPutArr[i] = smallSimbol[(indexOfSmallSymbol - kay) + numberLetters];
            }
        }
        return new String(outPutArr);
    }

    private static int findLargeSymbol(char c) {
        int rez = -1;

        for (int i = 0; i < largeSimvoly.length; ++i) {
            if (c == largeSimvoly[i]) {
                rez = i;
                break;
            }
        }
        return rez;
    }

    private static int findSmallSymbol(char c) {
        int rez = -1;

        for (int i = 0; i < smallSimbol.length; ++i) {
            if (c == smallSimbol[i]) {
                rez = i;
                break;
            }
        }
        return rez;
    }
}
