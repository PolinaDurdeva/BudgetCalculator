package com.pd.train.csv;

import java.util.List;
import java.util.Optional;

public class CsvResultListBased extends CsvResult{

    public CsvResultListBased(List<String> values) {
        super(values);
    }

    @Override
    public Optional<String> get(int index) {
        return Optional.ofNullable(values).map(values -> values.get(index));
    }

    @Override
    public Optional<String> get(String key) {
        return Optional.empty();
    }
}
