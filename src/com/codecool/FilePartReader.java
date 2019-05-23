package com.codecool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        filePath = "";
        fromLine = 0;
        toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) throw new IllegalArgumentException("toLine can't be smaller than fromLine");
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;
    }

    public String read() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        while (line != null) {
            sb.append(line + " ");
            line = reader.readLine();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String readLines() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        for (int i = 0; i < fromLine - 1; i++) {
            reader.readLine();
        }
        for (int i = fromLine - 1; i < toLine; i++) {
            sb.append(reader.readLine() + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String getFilePath() {
        return filePath;
    }

    public int getFromLine() {
        return fromLine;
    }

    public int getToLine() {
        return toLine;
    }
}
