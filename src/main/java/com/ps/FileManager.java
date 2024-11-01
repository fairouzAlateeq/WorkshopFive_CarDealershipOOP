package com.ps;

import java.io.*;
import java.util.ArrayList;
import java.io.IOException;

public class FileManager {
    public static Dealership getDealership() {
        //array list
        Dealership dealership = null;
        //buffered reader
        try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.csv"))) {
            // Read the first line for zoo information
            String dealershipInfo = reader.readLine();
            if (dealershipInfo != null) {
                String[] dealershipDetails = dealershipInfo.split(",");
                String dealershipName = dealershipDetails[0];
                String dealershipAddress = dealershipDetails[1];
                String dealershipPhone = dealershipDetails[2];
                dealership = new Dealership(dealershipName, dealershipAddress, dealershipPhone);
            }
            String line;
            while ((line = reader.readLine()) != null) {
                String[] vehicleData = line.split(",");
                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
                //reader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading the zoo data from the file.");
        }

        return dealership;
    }
}
