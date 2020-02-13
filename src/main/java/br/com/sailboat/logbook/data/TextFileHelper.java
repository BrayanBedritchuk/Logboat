package br.com.sailboat.logbook.data;

import java.io.*;

public class TextFileHelper {

    public static void createFile(String path, String content) throws IOException {
        PrintWriter writer = new PrintWriter(path, "UTF-8");
        if (isNotEmpty(content)) {
            writer.append(content);
        }
        writer.close();
    }

    public static String getFirstLineFromTextFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                if (isNotEmpty(line)) {
                    reader.close();
                    return line;
                }
                line = reader.readLine();
            }
            reader.close();
            return null;
        }
    }

    private static boolean isNotEmpty(String text) {
        return text != null && !text.trim().isEmpty();
    }

}
