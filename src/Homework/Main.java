package Homework;

import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CodingText codingText = new CodingText();
        String text = new String("Зашифровать этот текс и поместить в файл");
        String fileName = new String("MyFile.txt");
        File file = new File(fileName);
        write(file, text);
        write(file, codingText.caesar(read(fileName, file)));
        System.out.println(read(fileName, file));
        write(file, codingText.caesarDeshifrator(read(fileName, file)));
        System.out.println(read(fileName, file));
    }

    public static void write(File file, String text) throws FileNotFoundException {

        if (!file.exists()) {
            System.out.println("Такого файла не существует!");
        } else {
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            out.print(text);
            out.close();
        }
    }

    public static String read(String fileName, File file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        exists(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void delete(String nameFile) throws FileNotFoundException {
        exists(nameFile);
        new File(nameFile).delete();
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
}
