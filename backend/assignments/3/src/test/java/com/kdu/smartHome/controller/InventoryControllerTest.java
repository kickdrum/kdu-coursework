package com.kdu.smartHome.controller;

import com.kdu.smartHome.utility.TestSuiteDataManager;
import org.hamcrest.Matchers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.kdu.smartHome.utility.RequestBuilders.buildInventoryCreateRequest;

public class InventoryControllerTest {

    /**
     * Test to display inventory.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void displayInventory(MockMvc mockMvc, String... args) throws Exception {
        try {
            String kickstoneId = (args.length > 0) ? args[0].trim() : "111";
            String deviceName = (args.length > 1) ? args[1].trim() : "device1";
            String devicePassword = (args.length > 2) ? args[2].trim() : "pwd";
            String username = (args.length > 3) ? args[3].trim() : "user1";

            // Read user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get(username);
            String userToken = (String) userData.get("token");


            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/inventory")
                            .header("Authorization", "Bearer " + userToken)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.inventory").value(Matchers.containsString(kickstoneId)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.inventory").value(Matchers.containsString(deviceName)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.inventory").value(Matchers.containsString(devicePassword)))
                    .andDo(result -> {
                        System.out.println("displayInventory TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("displayInventory TEST FAILED " + ex.getLocalizedMessage()));
        }
    }


    /**
     * Test to add device in inventory.
     *
     * @param mockMvc The MockMvc instance.
     * @param args    Optional comma-separated values containing device details:
     *                If values are not provided, default values will be used.
     */
    public static void addDeviceToInventory(MockMvc mockMvc, String... args) throws Exception {
        try {
            String kickstoneId = (args.length > 0) ? args[0].trim() : "111";
            String deviceName = (args.length > 1) ? args[1].trim() : "device1";
            String devicePassword = (args.length > 2) ? args[2].trim() : "pwd";
            String username = (args.length > 3) ? args[3].trim() : "user1";

            // Read user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get(username);
            String userToken = (String) userData.get("token");


            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/inventory")
                            .header("Authorization", "Bearer " + userToken)
                            .content(buildInventoryCreateRequest(kickstoneId, deviceName, devicePassword, String.valueOf(LocalDateTime.now()), "BLR"))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(result -> {
                        // Fetch existing data
                        Map<String, Object> existingData = (Map<String, Object>) TestSuiteDataManager.readData("inventory");
                        // Check if there is any existing data
                        if (existingData == null) {
                            existingData = new HashMap<>();
                        }

                        // Add new user data to the existing data
                        existingData.put(kickstoneId, Map.of(
                                "kickstoneId", kickstoneId,
                                "devicePassword", devicePassword,
                                "manufactureDateTime", LocalDateTime.now(),
                                "manufactureFactoryPlace", "BLR"
                        ));

                        // Write user data and token to the test suite data manager
                        TestSuiteDataManager.writeData("inventory", existingData);

                        System.out.println("addDeviceToInventory TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("addDeviceToInventory TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

}
