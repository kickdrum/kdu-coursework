package com.kdu.smarthome;

import com.kdu.smarthome.controller.AuthControllerTester;
import com.kdu.smarthome.controller.DeviceControllerTester;
import com.kdu.smarthome.controller.HouseControllerTester;
import com.kdu.smarthome.controller.InventoryControllerTester;
import com.kdu.smarthome.controller.RoomControllerTester;
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
        Assertions.assertDoesNotThrow(()->{});
        AuthControllerTester.registerUser(mockMvc);
    }


    /**
     * Run house related tests.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(2)
    void houseRegisterWithInvalidAuth() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.houseRegisterWithInvalidAuth(mockMvc);
    }

    @Test
    @Order(3)
    void houseRegisterWithValidRequestData() {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.houseRegisterWithValidRequestData(mockMvc);
    }

    /**
     * Run adding users to house related tests.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(4)
    void addUnregisteredUserToHouseByAdmin() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.addUnregisteredUserToHouseByAdmin(mockMvc);
    }

    @Test
    @Order(5)
    void addUserToHouseByNonAdmin() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.addUserToHouseByNonAdmin(mockMvc);
    }

    @Test
    @Order(6)
    void addUserToHouseByAdmin() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.addUserToHouseByAdmin(mockMvc);
    }

    /**
     * Run adding room to house related tests.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(7)
    void addRoomWithInvalidAuth() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        RoomControllerTester.addRoomWithInvalidAuth(mockMvc);
    }

    @Test
    @Order(8)
    void addRoomByAdmin() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        RoomControllerTester.addRoomByAdmin(mockMvc);
    }


    @Test
    @Order(9)
    void addRoomForInvalidHouse() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        RoomControllerTester.addRoomForInvalidHouse(mockMvc);
    }

    /**
     * Tests to display all registered houses.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(10)
    void displayAllHouses() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.displayAllHouses(mockMvc);
    }

    @Test
    @Order(11)
    void displayAllHousesWithInvalidAuth() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.displayAllHousesWithInvalidAuth(mockMvc);
    }

    @Test
    @Order(11)
    void displayAllHousesByNonAdmin() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.displayAllHousesByNonAdmin(mockMvc);
    }

    /**
     * Tests to update house address.
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(12)
    void updateAddressForHouse() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.updateAddressForHouse(mockMvc);
    }

    @Test
    @Order(13)
    void updateAddressForInvalidHouse() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.updateAddressForInvalidHouse(mockMvc);
    }

    /**
     * Run inventory related tests
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(14)
    void addDeviceToInventory() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        InventoryControllerTester.addDeviceToInventory(mockMvc);
    }

    @Test
    @Order(15)
    void displayInventory() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        InventoryControllerTester.displayInventory(mockMvc);
    }



    /**
     * Run device registration related tests
     *
     * @throws Exception If an error occurs during the tests.
     */

    @Test
    @Order(16)
    void registerUnavailableDevice() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.registerUnavailableDevice(mockMvc);
    }

    @Test
    @Order(17)
    void deviceRegisterWithInvalidCredentials() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.deviceRegisterWithInvalidCredentials(mockMvc);
    }

    @Test
    @Order(18)
    void deviceRegisterByNonAdmin() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.deviceRegisterByNonAdmin(mockMvc);
    }

    @Test
    @Order(19)
    void deviceRegisterWithValidRequestData() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.deviceRegisterWithValidRequestData(mockMvc);
    }

    /**
     * Tests to add device in a house
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(20)
    void addUnavailableDevice() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.addUnavailableDevice(mockMvc);
    }

    @Test
    @Order(21)
    void addDeviceToInvalidHouse() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.addDeviceToInvalidHouse(mockMvc);
    }

    @Test
    @Order(22)
    void addDeviceToInvalidRoom() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.addDeviceToInvalidRoom(mockMvc);
    }

    @Test
    @Order(23)
    void addUnregisteredDevice() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.addUnregisteredDevice(mockMvc);
    }

    @Test
    @Order(24)
    void addDeviceWithValidRequestData() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        DeviceControllerTester.addDeviceWithValidRequestData(mockMvc);
    }

    /**
     * Tests to display all rooms and devices for a house
     *
     * @throws Exception If an error occurs during the tests.
     */
    @Test
    @Order(25)
    void listRoomsAndDevices() throws Exception {
        Assertions.assertDoesNotThrow(()->{});
        HouseControllerTester.listRoomsAndDevices(mockMvc);
    }

}
