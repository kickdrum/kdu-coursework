package kdu.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    public static void add(Student st) {
        logger.info("Student added: {}", st);
    }

    public static void retrieve(int id, Student st) {
        if (st != null) {
            logger.info("Student retrieved by ID {}: {}", id, st);
        } else {
            logger.error("Student not found with ID: {}", id);
        }
    }

    public static void updateName(int id, String newName, Student st) {
        if (st != null) {
            logger.info("Student with ID {} updated with new name '{}': {}", id, newName, st);
        } else {
            logger.error("Student not found with ID: {}", id);
        }
    }

    public static void updateAge(int id, int newAge, Student st) {
        if (st != null) {
            logger.info("Student with ID {} updated with new age {}: {}", id, newAge, st);
        } else {
            logger.error("Student not found with ID: {}", id);
        }
    }
}
