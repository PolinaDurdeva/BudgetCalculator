package com.pd.train.currency;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum Symbol {
    USD, EUR, RUB;

    public static List<String> getAsStrings(){
        return Arrays.stream(Symbol.values()).map(Enum::name).collect(toList());
    }
}
