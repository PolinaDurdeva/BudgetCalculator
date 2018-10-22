package com.pd.train.csv;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CsvResult {
    protected ArrayList<String> values;

    CsvResult(List<String> values) {
        this.values = (ArrayList<String>) values;
    }

    public abstract Optional<String> get(String key);

    public abstract Optional<String> get(int index);

    public List<String> getValues(){
        return values;
    }
}
