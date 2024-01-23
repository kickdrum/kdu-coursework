# Spring Boot Vehicle Demo

This is a simple Spring Boot application demonstrating the generation of vehicles with tyres and speakers.

## Project Structure

- `demo`: Main project folder.
    - `src`: Source code folder.
        - `main`: Main application source code.
            - `java`: Java source code.
                - `com.example.demo.config`: Configuration classes for Spring.
                - `com.example.demo.logging`: Logging utility class.
                - `com.example.demo.model`: Model classes for Tyre, Speaker, and Vehicle.
                - `com.example.demo.service`: Service classes for generating Tyre and Speaker objects, managing the Vehicle list.
            - `resources`: Resource files.
        - `test`: Test source code.
    - `.mvn`: Maven folder.
    - `.idea`: IntelliJ IDEA configuration folder.
    - `target`: Compiled bytecode and JAR files.
    - `pom.xml`: Project Object Model (POM) file for Maven.

## POM.xml Dependencies

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!-- ... other POM configurations ... -->
    <dependencies>
        <!-- Spring Boot Starter -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- Spring Boot Starter Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Logback Core -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>1.3.5</version>
        </dependency>

        <!-- Logback Classic -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.3.5</version>
        </dependency>

        <!-- Jakarta Annotation API -->
        <dependency>
            <groupId>jakarta.annotation</groupId>
            <artifactId>jakarta.annotation-api</artifactId>
            <version>2.1.1</version>
        </dependency>

        <!-- javax.annotation API -->
        <dependency>
            <groupId>javax.annotation</groupId>
            <artifactId>javax.annotation-api</artifactId>
            <version>1.3.2</version>
        </dependency>

    </dependencies>
    <!-- ... other POM configurations ... -->
</project>

## Building and Running the Project

1. Ensure you have Java and Maven installed.
2. Clone the repository: `git clone https://github.com/your-username/spring-boot-vehicle-demo.git`
3. Navigate to the project directory: `cd spring-boot-vehicle-demo`
4. Build the project: `mvn clean install`
5. Run the application: `mvn spring-boot:run`

The application will generate a list of vehicles with random tyres and speakers, and print details of the most expensive vehicle.

## Additional Notes

- Make sure to check the logging output for details during application startup and execution.

## Author : 

- HARSH  MISHRA

