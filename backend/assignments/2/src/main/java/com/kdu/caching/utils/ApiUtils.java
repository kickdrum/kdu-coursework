package com.kdu.caching.utils;

import lombok.experimental.UtilityClass;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Utility class for helper functions used during position stack api calls
 */
@UtilityClass
public class ApiUtils {

    /**
     * Method to make an API call to the input url and return the response as a string
     * @param urlString Complete API request url
     * @return API response string
     * @throws IOException
     */
    public String makeRequest(String urlString) throws IOException{
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
        return Integer.toString(responseCode);
    }


    /**
     * Method to convert API Response string to JSON object and get the best matching address.
     * @param response API response string
     * @return best address
     */
    public JSONObject getJsonResponse(String response) {
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray results = jsonResponse.getJSONArray("data");
        JSONObject result;
        if (!results.isEmpty()) {
            result = results.getJSONObject(0);
        }
        else {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }
}
