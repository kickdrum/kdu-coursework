package com.kdu.smarthome.utility;

import com.kdu.smarthome.DTO.AddDeviceRequest;
import com.kdu.smarthome.DTO.AddRoomRequest;
import com.kdu.smarthome.DTO.AddUserToHouseRequest;
import com.kdu.smarthome.DTO.DeviceRegisterRequest;
import com.kdu.smarthome.DTO.HouseRegisterRequest;
import com.kdu.smarthome.DTO.UpdateAddressRequest;
import com.kdu.smarthome.DTO.UserRegisterRequest;
import com.kdu.smarthome.DTO.InventoryRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestBuilders {

    /**
     * Builds the JSON payload for user registration.
     *
     * @param username  The username.
     * @param password  The password.
     * @param firstName The first name.
     * @param lastName  The last name.
     * @param email     The email.
     * @return A JSON string representing the user registration payload.
     */
    public static String buildUserRegistrationJson(String username, String password, String firstName, String lastName, String email) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UserRegisterRequest request = UserRegisterRequest.builder()
                .username(username)
                .password(password)
                .name(firstName + " " + lastName)
                .firstName(firstName)
                .lastName(lastName)
                .emailId(email)
                .build();
        return objectMapper.writeValueAsString(request);
    }

    /**
     * Builds a JSON representation of a house registration request.
     *
     * @param houseName    The name of the house.
     * @param houseAddress The address of the house.
     * @return A JSON string representing the house registration request.
     */
    public static String buildHouseRequestJson(String houseName, String houseAddress) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        HouseRegisterRequest request = HouseRegisterRequest.builder()
                .houseName(houseName)
                .address(houseAddress)
                .build();
        return objectMapper.writeValueAsString(request);
    }


    /**
     * Builds a JSON representation of an AddUserToHouseRequest.
     *
     * @param username The username to add to the house.
     * @return A JSON string representing the AddUserToHouseRequest.
     */
    public static String buildAddUserToHouseRequestJson(String username) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AddUserToHouseRequest request = AddUserToHouseRequest.builder().username(username).build();
        return objectMapper.writeValueAsString(request);
    }

    /**
     * Builds a JSON representation of an AddRoomRequest.
     *
     * @param roomName The room name to be added.
     * @return A JSON string representing the AddRoomRequest.
     */
    public static String buildAddRoomRequest(String roomName) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AddRoomRequest addRoomRequest = AddRoomRequest.builder().roomName(roomName).build();
        return objectMapper.writeValueAsString(addRoomRequest);
    }

    /**
     * Builds a JSON representation of an UpdateAddressRequest.
     *
     * @param address The new address to be added.
     * @return A JSON string representing the UpdateAddressRequest.
     */
    public static String buildUpdateAddressRequest(String address) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        UpdateAddressRequest updateAddressRequest = UpdateAddressRequest.builder().address(address).build();
        return objectMapper.writeValueAsString(updateAddressRequest);
    }

    /**
     * Builds a JSON string representing an InventoryCreateRequest.
     *
     * @param kickstonId              The kickstonId for the Inventory.
     * @param deviceUsername          The device username for the Inventory.
     * @param devicePassword          The device password for the Inventory.
     * @param manufactureDateTime     The manufacture date and time for the Inventory.
     * @param manufactureFactoryPlace The manufacture factory place for the Inventory.
     * @return The JSON string representing the InventoryCreateRequest.
     * @throws JsonProcessingException If there is an issue processing the JSON.
     */
    public static String buildInventoryCreateRequest(String kickstonId, String deviceUsername, String devicePassword, String manufactureDateTime, String manufactureFactoryPlace) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        InventoryRequest inventoryRequest = InventoryRequest.builder()
                .kickstonId(kickstonId)
                .deviceUsername(deviceUsername)
                .devicePassword(devicePassword)
                .manufactureDateTime(manufactureDateTime)
                .manufactureFactoryPlace(manufactureFactoryPlace)
                .build();
        return objectMapper.writeValueAsString(inventoryRequest);
    }


    /**
     * Builds a JSON request for Device registration.
     *
     * @param kickstonId     The kickston ID of the device.
     * @param deviceUsername The username of the device.
     * @param devicePassword The password of the device.
     * @return JSON representation of the Device registration request.
     * @throws JsonProcessingException If an error occurs while processing JSON.
     */
    public static String buildDeviceRegistrationRequest(String kickstonId, String deviceUsername, String devicePassword) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        DeviceRegisterRequest deviceRegisterRequest = DeviceRegisterRequest.builder()
                .kickstonId(kickstonId)
                .deviceUsername(deviceUsername)
                .devicePassword(devicePassword)
                .build();
        return objectMapper.writeValueAsString(deviceRegisterRequest);
    }

    /**
     * Builds a JSON representation of an AddDeviceRequest for testing purposes.
     *
     * @param houseId    The ID of the house.
     * @param roomId     The ID of the room.
     * @param kickstonId The ID of the kickston.
     * @return A JSON string representing the AddDeviceRequest.
     * @throws JsonProcessingException If there is an issue processing the JSON.
     */
    public static String buildAddDeviceRequest(String houseId, String roomId, String kickstonId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AddDeviceRequest addDeviceRequest = AddDeviceRequest.builder()
                .houseId(houseId)
                .roomId(roomId)
                .kickstonId(kickstonId)
                .build();
        return objectMapper.writeValueAsString(addDeviceRequest);
    }


}
