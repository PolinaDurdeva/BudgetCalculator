package com.pd.train.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class CsvReader {
    private final boolean hasHeader;
    private final int skipLines;
    private final String delimiter;
    private final Path pathToCsvFile;
    private BufferedReader reader;
    private List<String> header = null;

    private CsvReader(Path pathToCsvFile, boolean hasHeader, int skipLines, String delimiter) throws IOException {
        this.hasHeader = hasHeader;
        this.skipLines = skipLines;
        this.delimiter = delimiter;
        this.pathToCsvFile = pathToCsvFile;
        this.reader = new BufferedReader(new FileReader(pathToCsvFile.toString()));
        if (hasHeader){
            String firstLine = reader.readLine();
            this.header = Arrays.asList(firstLine.split(delimiter));
        }
    }

    public boolean getHasHeader() {
        return hasHeader;
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


    public List<String> getHeader() {
        if (hasHeader){
            return header;
        } else {
            return null;
        }
    }

    public static class Builder{
        private boolean hasHeader = false;
        private int skipLines = 0;
        private String delimiter = ",";
        private Path pathToCsvFile = null;

        public Builder skipLines(int lineNumbers){
            this.skipLines = lineNumbers;
            return this;
        }

        public Builder hasHeader(boolean hasHeader){
            this.hasHeader = hasHeader;
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

        public CsvReader build() throws IOException {
            if (pathToCsvFile == null){
                throw new IllegalArgumentException("Path to csv file should be assigned");
            }
            return new CsvReader(pathToCsvFile, hasHeader, skipLines, delimiter);
        }

    }

    private class CsvResult{
        private CsvResult() {
        }
        public HashMap<String, String> getResult(){
            LinkedHashMap map = new LinkedHashMap();
        }
    }



    public CsvResult readNextLine() throws IOException {
        if (hasHeader){

        }
        return new CsvResult();
    }

}
