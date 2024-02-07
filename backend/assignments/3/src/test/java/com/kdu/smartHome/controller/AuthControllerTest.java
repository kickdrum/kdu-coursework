package com.kdu.smartHome.controller;


import com.kdu.smartHome.utility.TestSuiteDataManager;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static com.kdu.smartHome.utility.RequestBuilders.buildUserRegistrationJson;

public class AuthControllerTest {

    /**
     * Test user registration with valid payload.
     *
     * @param mockMvc The MockMvc instance.
     * @param args    Optional comma-separated values containing user registration details:
     *                [firstName,lastName,username,password,email,userKey]
     *                If values are not provided, default values will be used.
     * @throws Exception If an error occurs during the test.
     */
    public static void registerUser(MockMvc mockMvc, String... args) throws Exception {

        try { // Use default values if no input is provided
            String firstName = (args.length > 0) ? args[0].trim() : "John";
            String lastName = (args.length > 1) ? args[1].trim() : "Doe";
            String username = (args.length > 2) ? args[2].trim() : "user1";
            String password = (args.length > 3) ? args[3].trim() : "defaultPassword";
            String email = (args.length > 4) ? args[4].trim() : "john.doe@example.com";

            // Manually construct the JSON payload
            String jsonPayload = buildUserRegistrationJson(username, password, firstName, lastName, email);

            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/register")
                            .content(jsonPayload)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.token").exists())
                    .andDo(result -> {
                        // Extract the token from the response
                        String response = result.getResponse().getContentAsString();
                        //COMPULSORY return : token
                        String token = JsonPath.read(response, "$.token");

                        // Fetch existing data
                        Map<String, Object> existingData = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
                        // Check if there is any existing data
                        if (existingData == null) {
                            existingData = new HashMap<>();
                        }

                        // Create a Map to hold user details and token
                        Map<String, Object> userDetails = new HashMap<String, Object>() {{
                            put("username", username);
                            put("password", password);
                            put("name", firstName + " " + lastName);
                            put("firstName", firstName);
                            put("lastName", lastName);
                            put("emailId", email);
                        }};
                        Map<String, Object> userData = new HashMap<String, Object>() {{
                            put("userDetails", userDetails);
                            put("token", token);
                        }};

                        // Add new user data to the existing data
                        existingData.put(username, userData);

                        // Write user data and token to the test suite data manager
                        TestSuiteDataManager.writeData("registeredUsers", existingData);

                        System.out.println("registerUser TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("registerUser TEST FAILED " + ex.getLocalizedMessage()));
        }
    }
}