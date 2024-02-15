package codingchallanges.wctool;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class WCToolMain {

    public static void main(String[] args) {
        log.info("Running WC Tool...");
        log.info("args: {}", Arrays.toString(args));

        if (args.length < 1) {
            throw new IllegalArgumentException("File name is required");
        }

        FileHandler handler = new FileHandler(args[args.length - 1]);

        boolean showSize = false;
        boolean showLineCount = false;
        boolean showWordsCount = false;
        boolean showCharCount = false;

        if (args.length > 1) {
            for (String arg : args) {
                if (arg.equals("-c")) {
                    showSize = true;
                }

                if (arg.equals("-l")) {
                    showLineCount = true;
                }

                if (arg.equals("-w")) {
                    showWordsCount = true;
                }

                if (arg.equals("-l")) {
                    showCharCount = true;
                }
            }
        } else {
            showSize = true;
            showLineCount = true;
            showWordsCount = true;
            showCharCount = true;
        }

        if (showSize) {
            log.info("File size: {} bytes", handler.getFileSize());
        }

        if (showLineCount || showCharCount || showWordsCount) {
            FileStats stats = handler.loadFileStats();

            if (showLineCount) {
                log.info("Line count: {}", stats.lineCount());
            }

            if (showWordsCount) {
                log.info("Word count: {}", stats.wordCount());
            }

            if (showCharCount) {
                log.info("Char count: {}", stats.charCount());
            }
        }
    }
}
