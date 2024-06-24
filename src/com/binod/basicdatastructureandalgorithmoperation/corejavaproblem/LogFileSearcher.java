package com.binod.basicdatastructureandalgorithmoperation.corejavaproblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LogFileSearcher {
    public static void main(String[] args) {
        String logFilePath = "logfile.log";
        String searchString = "issue";

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    System.out.println("Found at line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*public static void main(String[] args) {
        String logFilePath = "logfile.log";
        HashMap<Integer, String> logMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                logMap.put(lineNumber++, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Now you can search the log file for a specific string
        String searchString = "issue";
        searchLogs(logMap, searchString);
    }

    public static void searchLogs(HashMap<Integer, String> logMap, String searchString) {
        for (HashMap.Entry<Integer, String> entry : logMap.entrySet()) {
            if (entry.getValue().contains(searchString)) {
                System.out.println("Found at line " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }*/
}
