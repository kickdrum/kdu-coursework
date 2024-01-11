package org.example;

public class Main {
    public static void main(String[] args) {


        Integer [] array = new Integer[]{1,2,3};
        Exchange.swap(array,1,2);
        Logging logging = new Logging();
        logging.logString(array[1]+" "+array[2]);

        String [] stringArray = new String[]{"hello","sasi","rachapotu"};
        Exchange.swap(stringArray,1,2);
        logging.logString(stringArray[1]+" "+stringArray[2]);
        
    }
}