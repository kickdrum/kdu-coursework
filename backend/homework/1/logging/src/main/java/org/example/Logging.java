package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {

    private static final Logger logger= LoggerFactory.getLogger(Logging.class);

    public static void main(String[] args) {
        logger.info("Example log");
    }

    public void addStudent(Student student){
        logger.info("Student: "+student+" added to the repository");
    }
    public void retrieval(Student student){
        logger.info("Student: "+student+" details retrieved");
    }

    public void update(Student student){
        logger.info("Student: "+student+" details updated");
    }

    public void notFound(){
        logger.info("Student not found in the repository");
    }

    public void printAll(String str){
        logger.info("All Students: "+str);
    }



}
