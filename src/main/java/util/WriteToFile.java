package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    private static final String PATH_TO_FILE = "src/main/resources/file.txt";

    private WriteToFile() {
    }

    public static void write(String input) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH_TO_FILE))) {
            writer.write(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
