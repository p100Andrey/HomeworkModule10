package Homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    public static void write(File file, String text) {
        PrintWriter out = null;
        try {
            if (!file.exists()) {
                System.out.println("Файла с таким названием не существует! Создаем данный файл.");
                file.createNewFile();
            }
            out = new PrintWriter(file);
            out.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static String read(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}