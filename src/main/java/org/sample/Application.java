package org.sample;

import org.sample.client.*;
import org.sample.util.Log;
import org.sample.util.Statistics;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Mohamed Mekkawy on 18/03/2015.
 */
public class Application {

    public static void main(String args[]) throws FileNotFoundException {

        //Sending some sample log messages
        System.out.println("Sending sample log messages to the log service.......................................");
        performSampleCustomerLogs();

        System.out.println("Sending sample application log messages to the log service............................");
        performSampleAppLogs();

        System.out.println("Finished Logging.");

        //Retrieving some information.
        System.out.println("Enter one of the following options to retrieve some data from the logging service....................................");

        printOptions();

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        while (command != 0) {

            switch (command) {
                case 1:
                    System.out.println("........................................customer1 logs.....................................");
                    print(Statistics.allCustomerLogs("customer1"));
                    break;
                case 2:
                    System.out.println("........................................customer2 logs.....................................");
                    print(Statistics.allCustomerLogs("customer2"));
                    break;
                case 3:
                    System.out.println("........................................customer1 most visited products.....................................");
                    print(Statistics.mostVisitedProducts("customer1"));
                    break;
                case 4:
                    System.out.println("........................................customer2 most visited products.....................................");
                    print(Statistics.mostVisitedProducts("customer2"));
                    break;
                case 5:
                    System.out.println("........................................customer1 Recommended Product.....................................");
                    print(Statistics.recommendedProduct("customer1"));
                    break;
                case 6:
                    System.out.println("........................................customer2 Recommended Product.....................................");
                    print(Statistics.recommendedProduct("customer2"));
                    break;
                case 7:
                    System.out.println("........................................shop logs.....................................");
                    print(Statistics.allAppLogs("shop"));
                    break;
                case 8:
                    System.out.println("........................................portal logs.....................................");
                    print(Statistics.allAppLogs("portal"));
                    break;
                case 9:
                    System.out.println("........................................search application logs.....................................");
                    System.out.print("Please enter text to search for:");
                    String text = scanner.next();
                    print(Statistics.searchAppLogs(text.split(",")));
                    break;
                default:
                    System.out.println("Please enter valid option");
                    break;

            }
            printOptions();
            command = scanner.nextInt();
        }
    }

    private static void printOptions() {
        System.out.println("[1] Retrieve all log messages for [customer1]");
        System.out.println("[2] Retrieve all log messages for [customer2]");
        System.out.println("[3] Retrieve most visited products for [customer1]");
        System.out.println("[4] Retrieve most visited products for [customer2]");
        System.out.println("[5] Retrieve recommended product for [customer1]");
        System.out.println("[6] Retrieve recommended product for [customer2]");
        System.out.println("[7] Retrieve all log messages for application [shop]");
        System.out.println("[8] Retrieve all log messages for application [portal]");
        System.out.println("[9] Search all application log messages");
        System.out.println("[0] Exit");
    }

    private static void print(CustomerLogStatistics... customerLogStatisticses) {
        for (int i = 0; i < customerLogStatisticses.length; i++) {
            System.out.println((i + 1) + "........................ [" + customerLogStatisticses[i].getProductId() + "]..........................[" + customerLogStatisticses[i].getTotal() + "]...........................");
        }
    }

    private static void print(CustomerLog... customerLogs) {
        for (int i = 0; i < customerLogs.length; i++) {
            System.out.println((i + 1) + "...... [" + customerLogs[i] + "]........");
        }
    }

    private static void print(ApplicationLog...  applicationLogs) {
        for (int i = 0; i < applicationLogs.length; i++) {
            System.out.println((i + 1) + "...... [" + applicationLogs[i] + "]........");
        }
    }

    private static void performSampleCustomerLogs() {
        System.out.println("Sending [5] sample messages for [customer-1] who is visiting product [Laptops].");
        for (int i = 0; i < 5; i++) {
            Log.customerLog("Client-app", "customer1", "mess" + i, "info", null, CustomerLogType.GENERIC, "Laptops", "productDetails", null);
        }

        System.out.println("Sending [10] sample messages for [customer-1] who is visiting product [Mobiles].");
        for (int i = 0; i < 10; i++) {
            Log.customerLog("Client-app", "customer1", "mess" + i, "info", null, CustomerLogType.GENERIC, "Mobiles", "productDetails", null);
        }

        System.out.println("Sending [15] sample messages for [customer-2] who is visiting product [Laptops].");
        for (int i = 0; i < 15; i++) {
            Log.customerLog("Client-app", "customer2", "mess" + i, "info", null, CustomerLogType.GENERIC, "Laptops", "productDetails", null);
        }
    }

    private static void performSampleAppLogs() {
        System.out.println("Sending [5] sample messages for [Client-app]  with test message [dummy app information message].");
        for (int i = 0; i < 5; i++) {
            Log.appLog("shop", "logging module", "dummy app information message -" + i, "info", null, ApplicationLogType.GENERIC, "thread-321");
        }

        System.out.println("Sending [5] sample messages for [Client-app] with test message [test app information message].");
        for (int i = 0; i < 5; i++) {
            Log.appLog("portal", "reporting module", "test app information message -" + i, "info", null, ApplicationLogType.GENERIC, "thread-987");
        }

    }

}