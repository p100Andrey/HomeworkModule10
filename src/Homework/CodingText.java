package Homework;

import java.util.List;

public class CodingText {
    protected static char[] largeSimvoly =
            {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р',
                    'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

    protected static char[] smallSimbol =
            {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
                    'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};

    public static final int n = 33;
    public static final int k = 3;

    String caesar(String input) {
        char[] outPutArr;
        outPutArr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (findIndLargeSymbol(c) != -1) {
                if ((findIndLargeSymbol(c) + k) < n) outPutArr[i] = largeSimvoly[findIndLargeSymbol(c) + k];
                else outPutArr[i] = largeSimvoly[(findIndLargeSymbol(c) + k) - n];
            }
            if (findIndSmallSymbol(c) != -1) {
                if ((findIndSmallSymbol(c) + k) < n) outPutArr[i] = smallSimbol[findIndSmallSymbol(c) + k];
                else outPutArr[i] = smallSimbol[(findIndSmallSymbol(c) + k) - n];
            }
            if (c < 'А' || c > 'я') {
                outPutArr[i] = c;
            }
        }
        return new String(outPutArr);
    }

    String caesarDeshifrator(String input) {
        char[] outPutArr;
        outPutArr = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (findIndLargeSymbol(c) != -1) {
                if ((findIndLargeSymbol(c) - k) >= 0) outPutArr[i] = largeSimvoly[findIndLargeSymbol(c) - k];
                else outPutArr[i] = largeSimvoly[(findIndLargeSymbol(c) - k) + n];
            }
            if (findIndSmallSymbol(c) != -1) {
                if ((findIndSmallSymbol(c) - k) >= 0) outPutArr[i] = smallSimbol[findIndSmallSymbol(c) - k];
                else outPutArr[i] = smallSimbol[(findIndSmallSymbol(c) - k) + n];
            }
            if (c < 'А' || c > 'я') {
                outPutArr[i] = c;
            }
        }
        return new String(outPutArr);
    }

    public static int findIndLargeSymbol(char c) {
        int rez = -1;

        for (int i = 0; i < largeSimvoly.length; ++i) {
            if (c == largeSimvoly[i]) {
                rez = i;
            }
        }
        return rez;
    }

    public static int findIndSmallSymbol(char c) {
        int rez = -1;

        for (int i = 0; i < smallSimbol.length; ++i) {
            if (c == smallSimbol[i]) rez = i;
        }
        return rez;
    }
}
