package codingchallanges.wctool;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.Objects;

@Slf4j
class FileHandler {

    private final File file;

    FileHandler(String file) {
        if (file.isBlank()) {
            throw new IllegalArgumentException("File name is required");
        }

        this.file = new File(file);
        if (!this.file.exists()) {
            throw new IllegalArgumentException("File not found: " + file);
        }
    }

    FileStats loadFileStats() {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (java.util.Scanner scanner = new java.util.Scanner(this.file)) {
            while (scanner.hasNextLine()) {
                lineCount++;

                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] words = line.split("[ \t\n\r]+");
                wordCount += words.length;

                //when wc counts characters it also counts new line characters. So adding line count to char count
                charCount += line.length();
            }
        } catch (java.io.FileNotFoundException e) {
            log.error("File not found, exiting...");
        }
        return new FileStats(lineCount, wordCount, charCount);
    }

    long getFileSize() {
        return file.length();
    }
}
