package com.pd.train.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SimpleHttpRequestUtil {

    /**
     * Performs a simple get request without parameters
     * @param url url to send GET to
     * @return {@link ResponseResult} object containing main information about request's response
            * @throws IOException if the connection error occurs
     */
    public ResponseResult performGetRequest(String url) throws IOException {
        HttpUriRequest request = new HttpGet(url);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        ResponseResult result = new ResponseResult(response);
        EntityUtils.consume(response.getEntity());
        return result;
    }

    public ResponseResult performPostRequest(String url, String payload) throws IOException {
        throw new UnsupportedOperationException("This feature is available in the commercial version of the product. " +
                "Please purchase the licence unless you are a fan of passing your password in the query string");
    }


    /**
     * Simple wrapper of HTTP request response.
     * Provides information about http status code, http content and its declared type
     */
    public class ResponseResult {

        private int statusCode;
        private String content;
        private String contentType;

        ResponseResult(HttpResponse response) {
            statusCode = response.getStatusLine().getStatusCode();
            contentType = response.getFirstHeader("Content-Type").getValue();
            try {
                content = EntityUtils.toString(response.getEntity());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /**
         * Get HTTP status code
         * @return int status code
         */
        public int getStatusCode() {
            return statusCode;
        }


        /**
         * Get response content as string
         * @return response content
         */
        public String getContent() {
            return content;
        }


        /**
         * Get content type as raw string found in the response
         * @return content type as string present in the http response
         */
        public String getContentType() {
            return contentType;
        }

        public boolean isSuccess(){
            return statusCode == 200;
        }
    }

}
