package com.kdu.smartHome.controller;

import com.kdu.smartHome.utility.TestSuiteDataManager;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.kdu.smartHome.utility.RequestBuilders.buildAddRoomRequest;

public class RoomControllerTest {

    /**
     * Test adding room with invalid authentication.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void addRoomWithInvalidAuth(MockMvc mockMvc) throws Exception {
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/room")
                            .param("houseId", "testHouseId")
                            .content(buildAddRoomRequest("testRoom"))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                    .andDo(result -> {
                        System.out.println("addRoomWithInvalidAuth TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("addRoomWithInvalidAuth TEST FAILED " + ex.getLocalizedMessage()));
        }
    }


    /**
     * Test adding room with invalid authentication.
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void addRoomByAdmin(MockMvc mockMvc) throws Exception {
        try {

            // Read admin user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get("user1");
            String userToken = (String) userData.get("token");

            // Read house id from testSuiteData
            Map<String, Object> registeredHousesMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredHouses");
            Map<String, Object> houseData = (Map<String, Object>) registeredHousesMap.get("user1");
            String houseId = houseData.get("id").toString();

            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/room")
                            .param("houseId", houseId)
                            .header("Authorization", "Bearer " + userToken)
                            .content(buildAddRoomRequest("room1"))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.room.id").exists())
                    .andDo(result -> {
                        // Extract the roomId from the response
                        String response = result.getResponse().getContentAsString();
                        //COMPULSORY return : room.id
                        String roomId = JsonPath.read(response, "$.room.id");

                        // Create a mutable copy of houseData
                        Map<String, Object> mutableHouseData = new HashMap<>(houseData);

                        List<Map<String, Object>> rooms = (List<Map<String, Object>>) houseData.get("rooms");

                        if (rooms == null) {
                            rooms = new ArrayList<>();
                            mutableHouseData.put("rooms", rooms);
                        }

                        // Create the new room data
                        Map<String, Object> newRoom = new HashMap<>();
                        newRoom.put("id", roomId);
                        newRoom.put("roomName", "room1");

                        // Add the new room to the list of rooms for the house
                        rooms.add(newRoom);

                        // Update the registered houses data in testSuiteData
                        TestSuiteDataManager.writeData("registeredHouses", Map.of("user1", mutableHouseData));

                        System.out.println("addRoomByAdmin TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("addRoomByAdmin TEST FAILED " + ex.getLocalizedMessage()));
        }
    }

    /**
     * Test adding room to invalid house
     *
     * @param mockMvc The MockMvc instance.
     * @throws Exception If an error occurs during the test.
     */
    public static void addRoomForInvalidHouse(MockMvc mockMvc) throws Exception {
        try {

            // Read admin user token from testSuiteData
            Map<String, Object> registeredUsersMap = (Map<String, Object>) TestSuiteDataManager.readData("registeredUsers");
            Map<String, Object> userData = (Map<String, Object>) registeredUsersMap.get("user1");
            String userToken = (String) userData.get("token");


            mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/room")
                            .param("houseId", "invalidHouseId")
                            .header("Authorization", "Bearer " + userToken)
                            .content(buildAddRoomRequest("room1"))
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andDo(result -> {
                        System.out.println("addRoomForInvalidHouse TEST PASSED");
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Error(("addRoomForInvalidHouse TEST FAILED " + ex.getLocalizedMessage()));
        }
    }


}
