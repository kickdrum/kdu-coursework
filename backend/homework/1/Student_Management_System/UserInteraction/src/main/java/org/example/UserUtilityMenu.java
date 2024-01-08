package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserUtilityMenu {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Logger inputLogger = new Logger();

    public int operationMenu() {
        try {
            System.out.print("Enter Option no.\n1 -> Add Student\n2 -> Update Student\n3 -> Delete Student\n4 -> Retrieve Student\n-1 -> Exit\n: ");
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            inputLogger.errorLog("Invalid Operation No. \n",e);
        }
        return -1;
    }

    public int UpdateMenu() {
        try {
            System.out.print("Enter Option no.\n1 -> Update Name\n2 ->Update Age\n3 -> Update Grade\n4 -> Update Multiple Fields\n-1 -> Exit\n: ");
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            inputLogger.errorLog("Invalid Operation No. \n",e);
        }
        return -1;
    }

    public int RetrieveMenu() {
        try {
            System.out.print("Enter Option no.\n1 -> Retrieve By Id\n2 ->Retrieve By Name\n-1 -> Exit\n: ");
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            inputLogger.errorLog("Invalid Operation No. \n",e);
        }
        return -1;
    }
}
