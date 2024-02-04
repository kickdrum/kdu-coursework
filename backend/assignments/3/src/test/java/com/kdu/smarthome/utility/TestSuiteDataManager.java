package com.kdu.smarthome.utility;

import java.util.HashMap;
import java.util.Map;

public class TestSuiteDataManager {

    // Your data structure
    private static Map<String, Object> testSuiteData = new HashMap<>();

    // Function to write data to the data structure
    public static void writeData(String key, Object value) {
        testSuiteData.put(key, value);
    }

    // Function to read data from the data structure
    public static Object readData(String key) {
        return testSuiteData.get(key);
    }

    // Function to clear the data structure (useful for test setup)
    public static void clearData() {
        testSuiteData.clear();
    }

    // Function to display complete data structure
    public static Map<String, Object> showAllData() {
        return testSuiteData;
    }
}
