package com.kdu.smartHome.controller;

import com.kdu.smartHome.utility.TestSuiteDataManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.hamcrest.Matchers;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kdu.smartHome.utility.RequestBuilders.buildAddDeviceRequest;
import static com.kdu.smartHome.utility.RequestBuilders.buildAddUserToHouseRequestJson;
import static com.kdu.smartHome.utility.RequestBuilders.buildHouseRequestJson;
import static com.kdu.smartHome.utility.RequestBuilders.buildUpdateAddressRequest;


public class HouseControllerTest {

    /**
     * Test to display all registered houses.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void displayAllHouses(MockMvc mockMvc, String... args) throws Exception {
        try {
            String username = (args.length > 0) ? args[0].trim() : "user1";
            String expectedHouseName = (args.length > 1) ? args[1].trim() : "house1";
            String expectedAddress = (args.length > 2) ? args[2].trim() : "123 Street";


            // Read user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get(username);
            String userToken = (String) userData.get("token");


            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/house")
                            .header("Authorization", "Bearer " + userToken)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.houses").value(Matchers.containsString(expectedHouseName)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.houses").value(Matchers.containsString(expectedAddress)))
                    .andDo(result -> {
                        System.out.println("displayAllHouses TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("displayAllHouses TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

    /**
     * Test un-authenticated request to display all registered houses.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void displayAllHousesWithInvalidAuth(MockMvc mockMvc) throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/house")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                    .andDo(result -> {
                        System.out.println("displayAllHousesWithInvalidAuth TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("displayAllHousesWithInvalidAuth TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

    /**
     * Test request to display all registered houses by non-admin.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void displayAllHousesByNonAdmin(MockMvc mockMvc, String... args) throws Exception {
        try {
            // Read non-admin user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get("user2");
            String userToken = (String) userData.get("token");

            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/house")
                            .header("Authorization", "Bearer " + userToken)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.houses").value(Matchers.containsString("house1")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.houses").value(Matchers.containsString("123 Street")))
                    .andDo(result -> {
                        System.out.println("displayAllHousesByNonAdmin TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("displayAllHousesByNonAdmin TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

    /**
     * Test house registration with invalid authentication.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void houseRegisterWithInvalidAuth(MockMvc mockMvc) throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/house")
                            .content(buildHouseRequestJson("houseTest", "addressTest"))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                    .andDo(result -> {
                        System.out.println("houseRegisterWithInvalidAuth TEST PASSED");
                    });
        } catch (Exception ex) {
            throw new Error(("houseRegisterWithInvalidAuth TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

    /**
     * Test house registration with valid request data.
     *
     * @param mockMvc The MockMvc instance.
     * @param args    Optional comma-separated values containing house registration details:
     *                [houseName,houseAddress]
     *                If values are not provided, default values will be used.
     */
    public static void houseRegisterWithValidRequestData(MockMvc mockMvc, String... args) {
        try {
            String houseName = (args.length > 0) ? args[0].trim() : "house1";
            String houseAddress = (args.length > 1) ? args[1].trim() : "123 Street";
            String username = (args.length > 2) ? args[2].trim() : "user1";

            // Read user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get(username);
            String userToken = (String) userData.get("token");

            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/house")
                            .content(buildHouseRequestJson(houseName, houseAddress))
                            // Add the Authorization header with the user token
                            .header("Authorization", "Bearer " + userToken)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.house.id").exists())
                    .andDo(result -> {
                        // Extract the houseId from the response
                        String response = result.getResponse().getContentAsString();
                        //COMPULSORY return : house.id
                        String houseId = JsonPath.read(response, "$.house.id");

                        // Fetch existing data
                        Map<String, Object> existingData = (Map<String, Object>) TestSuiteDataManager.readData("registeredHouses");
                        // Check if there is any existing data
                        if (existingData == null) {
                            existingData = new HashMap<>();
                        }

                        // Add new user data to the existing data
                        existingData.put(username, Map.of(
                                "id", houseId,
                                "address", houseAddress,
                                "houseName", houseName,
                                "adminUsers", Collections.singletonList(username),
                                "users", Arrays.asList(username)
                        ));

                        // Write user data and token to the test suite data manager
                        TestSuiteDataManager.writeData("registeredHouses", existingData);

                        System.out.println("houseRegisterWithValidRequestData TEST PASSED");
                    });

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("houseRegisterWithValidRequestData TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

    /**
     * Test adding user to house by a non-admin.
     *
     * @param mockMvc The MockMvc instance.
     * @param args    Optional comma-separated values containing house registration details:
     *                [houseName,houseAddress]
     *                If values are not provided, default values will be used.
     */
    public static void addUserToHouseByNonAdmin(MockMvc mockMvc, String... args) throws Exception {
        try {
            // Use default values if no input is provided
            String firstName = (args.length > 0) ? args[0].trim() : "Jin";
            String lastName = (args.length > 1) ? args[1].trim() : "Seok";
            String username = (args.length > 2) ? args[2].trim() : "user2";
            String password = (args.length > 3) ? args[3].trim() : "defaultPassword2";
            String email = (args.length > 4) ? args[4].trim() : "jin@example.com";

            //Register above user and save
            AuthControllerTest.registerUser(mockMvc, firstName, lastName, username, password, email);

            // Read non-admin user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get(username);
            String userToken = (String) userData.get("token");

            // Read house id from testSuiteData
            Map<String, Object> registeredHousesMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredHouses");
            Map<String, Object> houseData = (Map<String, Object>) registeredHousesMap.get("user1");
            String houseId = (String) houseData.get("id");

            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/house/{houseId}/add-user", houseId)
                            .content(buildAddUserToHouseRequestJson(username))
                            // Add the Authorization header with the user token
                            .header("Authorization", "Bearer " + userToken)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                    .andDo(result -> {
                        System.out.println("addUserToHouseByNonAdmin TEST PASSED");
                    });

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("addUserToHouseByNonAdmin TEST FAILED " + ex.getLocalizedMessage()));
        }

    }

    /**
     * Test adding user to house by an admin.
     * Expected : User being added is already registered
     *
     * @param mockMvc The MockMvc instance.
     * @param args    Optional comma-separated values containing house registration details:
     *                [houseName,houseAddress]
     *                If values are not provided, default values will be used.
     */
    public static void addUserToHouseByAdmin(MockMvc mockMvc, String... args) throws Exception {
        try {
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get("user1");
            String userToken = (String) userData.get("token");

            Map<String, Object> registeredHousesMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredHouses");
            Map<String, Object> houseData = (Map<String, Object>) registeredHousesMap.get("user1");
            String houseId = (String) houseData.get("id");

            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/house/{houseId}/add-user", houseId)
                            .content(buildAddUserToHouseRequestJson("user2"))
                            .header("Authorization", "Bearer " + userToken)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(result -> {
                        Map<String, Object> mutableHouseData = new HashMap<>(houseData);

                        List<String> users = (List<String>) mutableHouseData.computeIfAbsent("users", k -> new ArrayList<>());
                        users = new ArrayList<>(users);
                        users.add("user2");

                        mutableHouseData.put("users", users);

                        registeredHousesMap.put("user1", mutableHouseData);
                        TestSuiteDataManager.writeData("registeredHouses", registeredHousesMap);

                        System.out.println("addUserToHouseByAdmin TEST PASSED");
                    });

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("addUserToHouseByAdmin TEST FAILED " + ex.getLocalizedMessage()));
        }
    }


    /**
     * Test adding un-registered user to house by an admin.
     *
     * @param mockMvc The MockMvc instance.
     * @param args    Optional comma-separated values containing house registration details:
     *                [houseName,houseAddress]
     *                If values are not provided, default values will be used.
     */
    public static void addUnregisteredUserToHouseByAdmin(MockMvc mockMvc, String... args) throws Exception {
        try {
            // Read admin user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get("user1");
            String userToken = (String) userData.get("token");

            // Read house id from testSuiteData
            Map<String, Object> registeredHousesMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredHouses");
            Map<String, Object> houseData = (Map<String, Object>) registeredHousesMap.get("user1");
            String houseId = (String) houseData.get("id");

            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/house/{houseId}/add-user", houseId)
                            .content(buildAddUserToHouseRequestJson("unregisteredUser"))
                            // Add the Authorization header with the user token
                            .header("Authorization", "Bearer " + userToken)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andDo(result -> {
                        System.out.println("addUnregisteredUserToHouseByAdmin TEST PASSED");
                    });

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("addUnregisteredUserToHouseByAdmin TEST FAILED " + ex.getLocalizedMessage()));
        }

    }

    /**
     * Test to update address for house.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void updateAddressForHouse(MockMvc mockMvc) throws Exception {
        try {
            // Read admin user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get("user1");
            String userToken = (String) userData.get("token");

            // Read house id from testSuiteData
            Map<String, Object> registeredHousesMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredHouses");
            Map<String, Object> houseData = (Map<String, Object>) registeredHousesMap.get("user1");
            String houseId = houseData.get("id").toString();

            mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/house")
                            .header("Authorization", "Bearer " + userToken)
                            .content(buildUpdateAddressRequest("New Street 999"))
                            .param("houseId", houseId)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                    .andDo(result -> {
                        Map<String, Object> mutableHouseData = new HashMap<>(houseData);
                        mutableHouseData.put("address", "New Street 999");

                        // Update the registeredHousesMap with the modified houseData
                        TestSuiteDataManager.writeData("registeredHouses", Map.of("user1", mutableHouseData));

                        //Re-verify if the address has been modified successfully
                        displayAllHouses(mockMvc, "user1", "house1", "New Street 999");

                        System.out.println("updateAddressForHouse TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("updateAddressForHouse TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

    /**
     * Test to update address for invalid house.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void updateAddressForInvalidHouse(MockMvc mockMvc) throws Exception {
        try {
            // Read admin user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get("user1");
            String userToken = (String) userData.get("token");

            mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/house")
                            .header("Authorization", "Bearer " + userToken)
                            .content(buildUpdateAddressRequest("New Street 999"))
                            .param("houseId", "invalidHouse")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andDo(result -> {
                        displayAllHouses(mockMvc, "user1", "house1", "New Street 999");

                        System.out.println("updateAddressForInvalidHouse TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("updateAddressForInvalidHouse TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

    /**
     * Test to display all rooms and devices in the house.
     *
     * @param mockMvc The MockMvc instance.
     * @param args    Optional comma-separated values containing device registration details:
     *                If values are not provided, default values will be used.
     */
    public static void listRoomsAndDevices(MockMvc mockMvc, String... args) {
        try {
            String kickstoneId = (args.length > 0) ? args[0].trim() : "111";
            String username = (args.length > 1) ? args[1].trim() : "user1";

            System.out.println(TestSuiteDataManager.showAllData());

            // Read user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get(username);
            String userToken = (String) userData.get("token");

            // Read house data from testSuiteData
            Map<String, Object> registeredHousesMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredHouses");
            Map<String, Object> houseData = (Map<String, Object>) registeredHousesMap.get(username);
            String houseId = houseData.get("id").toString();
            String houseName = houseData.get("houseName").toString();
            String address = houseData.get("address").toString();

            // Read room data from testSuiteData
            List<Map<String, Object>> rooms = (List<Map<String, Object>>) houseData.get("rooms");
            String roomId = (rooms.get(0)).get("id").toString();

            mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/house/{houseId}", houseId)
                            // Add the Authorization header with the user token
                            .header("Authorization", "Bearer " + userToken)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.roomsAndDevices").value(Matchers.containsString(houseId)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.roomsAndDevices").value(Matchers.containsString("house1")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.roomsAndDevices").value(Matchers.containsString("New Street 999")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.roomsAndDevices").value(Matchers.containsString(roomId)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.roomsAndDevices").value(Matchers.containsString("room1")))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.roomsAndDevices").value(Matchers.containsString(kickstoneId)))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.roomsAndDevices").value(Matchers.containsString("device1")))
                    .andDo(result -> {
                        System.out.println("listRoomsAndDevices TEST PASSED");
                    });

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("listRoomsAndDevices TEST FAILED " + ex.getLocalizedMessage()));
        }
    }
}
