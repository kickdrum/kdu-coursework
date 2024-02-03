package com.kdu.smartHome;

import com.kdu.smartHome.controller.AuthControllerTest;
import com.kdu.smartHome.controller.DeviceControllerTest;
import com.kdu.smartHome.controller.HouseControllerTest;
import com.kdu.smartHome.controller.InventoryControllerTest;
import com.kdu.smartHome.controller.RoomControllerTest;
import com.kdu.smartHome.utility.TestSuiteDataManager;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource("classpath:application-test.properties")
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class SmartHomeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Run authentication related tests.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(1)
    void runAuthTests() throws Exception {
        AuthControllerTest.registerUser(mockMvc);
    }

    /**
     * Run house related tests.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(2)
    void houseRegisterWithInvalidAuth() throws Exception {
        HouseControllerTest.houseRegisterWithInvalidAuth(mockMvc);
    }

    @Test
    @Order(3)
    void houseRegisterWithValidRequestData() {
        HouseControllerTest.houseRegisterWithValidRequestData(mockMvc);
    }

    /**
     * Run adding users to house related tests.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(4)
    void addUnregisteredUserToHouseByAdmin() throws Exception {
        HouseControllerTest.addUnregisteredUserToHouseByAdmin(mockMvc);
    }

    @Test
    @Order(5)
    void addUserToHouseByNonAdmin() throws Exception {
        HouseControllerTest.addUserToHouseByNonAdmin(mockMvc);
    }

    @Test
    @Order(6)
    void addUserToHouseByAdmin() throws Exception {
        HouseControllerTest.addUserToHouseByAdmin(mockMvc);
    }

    /**
     * Run adding room to house related tests.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(7)
    void addRoomWithInvalidAuth() throws Exception {
        RoomControllerTest.addRoomWithInvalidAuth(mockMvc);
    }

    @Test
    @Order(8)
    void addRoomByAdmin() throws Exception {
        RoomControllerTest.addRoomByAdmin(mockMvc);
    }


    @Test
    @Order(9)
    void addRoomForInvalidHouse() throws Exception {
        RoomControllerTest.addRoomForInvalidHouse(mockMvc);
    }

    /**
     * Tests to display all registered houses.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(10)
    void displayAllHouses() throws Exception {
        HouseControllerTest.displayAllHouses(mockMvc);
    }

    @Test
    @Order(11)
    void displayAllHousesWithInvalidAuth() throws Exception {
        HouseControllerTest.displayAllHousesWithInvalidAuth(mockMvc);
    }

    @Test
    @Order(11)
    void displayAllHousesByNonAdmin() throws Exception {
        HouseControllerTest.displayAllHousesByNonAdmin(mockMvc);
    }

    /**
     * Tests to update house address.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(12)
    void updateAddressForHouse() throws Exception {
        HouseControllerTest.updateAddressForHouse(mockMvc);
    }

    @Test
    @Order(13)
    void updateAddressForInvalidHouse() throws Exception {
        HouseControllerTest.updateAddressForInvalidHouse(mockMvc);
    }

    /**
     * Run inventory related tests
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(14)
    void addDeviceToInventory() throws Exception {
        InventoryControllerTest.addDeviceToInventory(mockMvc);
    }

    @Test
    @Order(15)
    void displayInventory() throws Exception {
        InventoryControllerTest.displayInventory(mockMvc);
    }

    /**
     * Run device registration related tests
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(16)
    void registerUnavailableDevice() throws Exception {
        DeviceControllerTest.registerUnavailableDevice(mockMvc);
    }

    @Test
    @Order(17)
    void deviceRegisterWithInvalidCredentials() throws Exception {
        DeviceControllerTest.deviceRegisterWithInvalidCredentials(mockMvc);
    }

    @Test
    @Order(18)
    void deviceRegisterByNonAdmin() throws Exception {
        DeviceControllerTest.deviceRegisterByNonAdmin(mockMvc);
    }

    @Test
    @Order(19)
    void deviceRegisterWithValidRequestData() throws Exception {
        DeviceControllerTest.deviceRegisterWithValidRequestData(mockMvc);
    }

    /**
     * Tests to add device in a house
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(20)
    void addUnavailableDevice() throws Exception {
        DeviceControllerTest.addUnavailableDevice(mockMvc);
    }

    @Test
    @Order(21)
    void addDeviceToInvalidHouse() throws Exception {
        DeviceControllerTest.addDeviceToInvalidHouse(mockMvc);
    }

    @Test
    @Order(22)
    void addDeviceToInvalidRoom() throws Exception {
        DeviceControllerTest.addDeviceToInvalidRoom(mockMvc);
    }

    @Test
    @Order(23)
    void addUnregisteredDevice() throws Exception {
        DeviceControllerTest.addUnregisteredDevice(mockMvc);
    }

    @Test
    @Order(24)
    void addDeviceWithValidRequestData() throws Exception {
        DeviceControllerTest.addDeviceWithValidRequestData(mockMvc);
    }

    /**
     * Tests to display all rooms and devices for a house
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(25)
    void listRoomsAndDevices() throws Exception {
        HouseControllerTest.listRoomsAndDevices(mockMvc);
    }
}
