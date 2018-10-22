package com.pd.train.currency;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ExchangeRate {
    private boolean success;
    private Long timestamp;
    private Symbol base;
    private Date date;
    private HashMap<Symbol, Double> rates;

    public boolean isSuccess() {
        return success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Symbol getBase() {
        return base;
    }

    public Date getDate() {
        return date;
    }

    public HashMap<Symbol, Double> getRates() {
        return rates;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setBase(Symbol base) {
        this.base = base;
    }

    public void setDate(String date) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.date = ft.parse(date);
    }

    public void setRates(HashMap<Symbol, Double> rates) {
        this.rates = rates;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}
