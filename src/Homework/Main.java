package Homework;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        CodingText codingText = new CodingText();
        FileManager fileManager = new FileManager();

        String text = "Зашифровать этот текс и поместить в файл";
        String fileName = "MyFile.txt";

        File file = new File(fileName);
        fileManager.write(file, text);

        File fileCoded = new File("fileNameCoded.txt");
        File fileDecoded = new File("fileNameDeCoded.txt");

        String textCoded = codingText.caesar(fileManager.read(file));
        fileManager.write(fileCoded, textCoded);
        String codedFromFile = fileManager.read(fileCoded);
        System.out.println(codedFromFile);
        String textDeCoded = codingText.caesarDeshifrator(codedFromFile);
        fileManager.write(fileDecoded, textDeCoded);
        System.out.println(fileManager.read(fileDecoded));
    }
}
