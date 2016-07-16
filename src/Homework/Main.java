package Homework;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        CodingText codingText = new CodingText();
        String text = "Зашифровать этот текс и поместить в файл";
        String fileName = "MyFile.txt";
        File file = new File(fileName);
        write(file, text);
        String fileNameCoded = "fileNameCoded.txt";
        File fileCoded = new File(fileNameCoded);
        String fileNameDeCoded = "fileNameDeCoded.txt";
        File fileDecoded = new File(fileNameDeCoded);
        String textCoded = codingText.caesar(read(fileName, file));
        write(fileCoded, textCoded);
        System.out.println(read(fileNameCoded, fileCoded));
        String textDeCoded = codingText.caesarDeshifrator(read(fileNameCoded, fileCoded));
        write(fileDecoded, textDeCoded);
        System.out.println(read(fileNameDeCoded, fileDecoded));
    }

    private static void write(File file, String text) {

        if (!file.exists()) {
            try {
                System.out.println("Файла с таким названием не существует! Создаем данный файл.");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        out.print(text);
        out.close();
    }


    private static String read(String fileName, File file) {
        String sb = new String();
        exists(fileName);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            String s;
            while ((s = in.readLine()) != null) {
                sb = sb + s + "\n";
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static void exists(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                throw new FileNotFoundException(file.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
