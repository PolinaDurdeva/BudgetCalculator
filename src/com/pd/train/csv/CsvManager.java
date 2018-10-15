package com.pd.train.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CsvManager {
    private final boolean header;
    private final int skipLines;
    private final String delimiter;
    private final Path pathToCsvFile;
    private BufferedReader reader;

    private CsvManager(Path pathToCsvFile, boolean header, int skipLines, String delimiter) {
        this.header = header;
        this.skipLines = skipLines;
        this.delimiter = delimiter;
        this.pathToCsvFile = pathToCsvFile;
    }

    public boolean isHeader() {
        return header;
    }

    public int getSkipLines() {
        return skipLines;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public Path getPathToCsvFile() {
        return pathToCsvFile;
    }

    public static class Builder{
        private boolean header = false;
        private int skipLines = 0;
        private String delimiter = ",";
        private Path pathToCsvFile = null;

        public Builder skipLines(int lineNumbers){
            this.skipLines = lineNumbers;
            return this;
        }

        public Builder hasHeader(boolean header){
            this.header = header;
            return this;
        }

        public Builder delimiter(String delimiter){
            this.delimiter = delimiter;
            return this;
        }

        public Builder csvFile(String path) throws FileNotFoundException {
            this.pathToCsvFile = Paths.get(path);
            return this;
        }

        public CsvManager build(){
            if (pathToCsvFile == null){
                throw new IllegalArgumentException("Path to csv file should be assigned");
            }
            return new CsvManager(pathToCsvFile, header, skipLines, delimiter);
        }

    }

    private class CsvResult{

    }

    public CsvResult readNextLine() throws FileNotFoundException {
        if (reader == null){
            reader = new BufferedReader(new FileReader(pathToCsvFile.toString()));
        }
        return new CsvResult();
    }

}
