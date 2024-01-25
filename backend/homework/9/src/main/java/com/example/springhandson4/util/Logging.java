package com.example.springhandson4.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Logging {
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public void logInfo(String msg) {
        logger.info(msg);
    }

    public void logDebug(String msg) {
        logger.debug(msg);
    }

    public void logError(String msg) {
        logger.error(msg);
    }

    public void logApiRequest(String apiEndpoint, String method, String requestBody) {
        logInfo("API Request - Endpoint: " + apiEndpoint + ", Method: " + method + ", Request Body: " + requestBody);
    }

    public void logApiResponse(String apiEndpoint, String responseBody) {
        logInfo("API Response - Endpoint: " + apiEndpoint + ", Response Body: " + responseBody);
    }

    public void logException(String exceptionMessage) {
        logError("Exception: " + exceptionMessage);
    }
}