package com.pd.train.csv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CsvResultMapBased extends CsvResult{

    private HashMap<String, String> map;

    public CsvResultMapBased(List<String> values, List<String> fieldNames) {
        super(values);
        this.map = new HashMap<>();
        for(int i = 0; i < fieldNames.size(); i++){
            this.map.put(fieldNames.get(i), values.get(i));
        }
    }

    @Override
    public Optional<String> get(String key) {
        return Optional.ofNullable(map).map(map -> map.get(key));
    }

    @Override
    public Optional<String> get(int index) {
        return Optional.ofNullable(values).map(values -> values.get(index));
    }
}
