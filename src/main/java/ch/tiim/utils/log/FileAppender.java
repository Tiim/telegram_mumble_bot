package ch.tiim.utils.log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileAppender implements Appender {

    private final BufferedWriter writer;

    public FileAppender(String toAppend) {
        BufferedWriter w = null;
        try {
            w = Files.newBufferedWriter(Paths.get(toAppend), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.err.println("Can't open " + toAppend);
            e.printStackTrace(System.err);
        }
        writer = w;
    }

    @Override
    public void appendString(String str) {
        try {
            if (writer != null) {
                writer.write(str);
                writer.write("\n");
                writer.flush();
            }
        } catch (IOException ignore) {
        }
    }
}
