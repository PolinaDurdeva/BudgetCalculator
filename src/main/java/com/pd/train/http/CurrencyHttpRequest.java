package com.pd.train.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.train.currency.ExchangeRate;
import com.pd.train.currency.Symbol;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class CurrencyHttpRequest {

    private static final String CURRENCY_API_ENDPOINT = "http://data.fixer.io/api/";

    private final Path accessTokenFilename = FileSystems.getDefault().getPath("resources", "token");

    private final String accessToken;

    public CurrencyHttpRequest() throws IOException {
        accessToken = getAccessToken().orElse("");
    }

    private Optional<String> getAccessToken() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(accessTokenFilename.toString()));
        return Optional.of(reader.readLine());
    }
    // TODO
    public Optional<ExchangeRate> requestLatestCurrency(Symbol base) throws IOException {
        String query = new StringBuilder()
                .append(CURRENCY_API_ENDPOINT)
                .append("?latest")
                .append("access_key=")
                .append(accessToken)
                .append("base=")
                .append(base.name())
                .append(String.join(",", Symbol.getAsStrings()))
                .toString();
        SimpleHttpRequestUtil.ResponseResult result = new SimpleHttpRequestUtil().performGetRequest(query);
        if (result.isSuccess()) {
            return Optional.ofNullable(new ObjectMapper().readValue(result.getContent(), ExchangeRate.class));
        } else {
            System.out.println(result.getStatusCode());
            return Optional.empty();
        }

    }
}
