package com.ps;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
public class UserInterface {

    private static Scanner commandScanner = new Scanner(System.in);
    private static Scanner inputScanner = new Scanner(System.in);
    private static Dealership dealership;

    public static void init() {
        //Loading the dealership and inventory from a file
        dealership = DealershipFileManager.getDealership();
    }

    //helper method // displayvehicles
    public static void displayScreen() {
        init();
        int command;

        do {
            System.out.println("What do you want to do?");
            System.out.println("1. search by price");
            System.out.println("2. by make/model");
            System.out.println("3. by year");
            System.out.println("4. by color");
            System.out.println("5. by milage");
            System.out.println("6. by Type");
            System.out.println("7. view all of em");
            System.out.println("8. add a vehicle");
            System.out.println("9. remove a vehicle");
            System.out.println("10. buy or lease a vehicle");
            System.out.println("99. Quit");

            command = commandScanner.nextInt();

            //switch

            switch (command) {
                case 1:
                    processGetVehicleByPrice();
                    break;
                case 2:
                    processGetVehicleByMakeModel();
                    break;
                case 3:
                    processGetVehicleByYear();

                    break;
                case 4:
                    processGetVehicleByColor();
                    break;
                case 5:
                    processGetVehicleByMilage();
                    break;
                case 6:
                    processGetVehicleByType();
                    break;
                case 7:
                    processGetAllVehicles();
                    break;
                case 8:
                    processAddVehicle();
                    break;
                case 9:
                    ProcessRemoveVehicle();
                    break;
                case 10:
                    processSellOrLeaseVehicle();
                    break;
                case 99:
                    System.out.println("See you next time! ");
                    break;
                default:
                    System.out.println("commands are from 1-9 and 99 to quit");
            }
        }
        while (command != 99);


    }

    public static void processDisplayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public static void processGetVehicleByPrice() {
        System.out.println("enter mimimum price: ");
        double min = inputScanner.nextDouble();
        System.out.println("enter your max: ");
        double max = inputScanner.nextDouble();
        List<Vehicle> vehicles = Dealership.getVehicleByPrice(min, max);
        processDisplayVehicles(vehicles);

    }

    public static void processGetVehicleByMakeModel() {
        System.out.println("whats the make? ");
        String carMake = inputScanner.nextLine();
        System.out.println("model? ");
        String carModel = inputScanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByMakeModel(carMake, carModel);
        processDisplayVehicles(vehicles);

    }

    public static void processGetVehicleByYear() {
        System.out.println("enter your min year: ");
        int year1 = inputScanner.nextInt();
        System.out.println("enter your max year: ");
        int year2 = inputScanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehicleByYear(year1, year2);
        processDisplayVehicles(vehicles);

    }

    public static void processGetVehicleByColor() {
        System.out.println("What color are you looking for? ");
        String col = inputScanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByColor(col);
        processDisplayVehicles(vehicles);

    }

    public static void processGetVehicleByMilage() {
        System.out.println("min Milage: ");
        int minMilage = inputScanner.nextInt();
        System.out.println("max Milage");
        int maxMilage = inputScanner.nextInt();
        List<Vehicle> vehicles = Dealership.getVehicleByMilage(minMilage, maxMilage);
        processDisplayVehicles(vehicles);
    }

    public static void processGetVehicleByType() {
        System.out.println("What type od car are you looking for? ");
        String type = inputScanner.nextLine();
        List<Vehicle> vehicles = Dealership.getVehicleByType(type);
        processDisplayVehicles(vehicles);
    }

    public static void processGetAllVehicles() {
        System.out.println("all available cars: ");
        List<Vehicle> vehicles = Dealership.getAllVehicles();
        processDisplayVehicles(vehicles);
    }

    private static void processAddVehicle() {
        System.out.println("Enter Vehicle Data: ");
        System.out.println("Vin number: ");
        int vin = inputScanner.nextInt();
        System.out.println("Year: ");
        int year = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.println("make: ");
        String make = inputScanner.nextLine();
        System.out.println("model: ");
        String model = inputScanner.nextLine();
        System.out.println("type: ");
        String vehicleType = inputScanner.nextLine();
        System.out.println("color: ");
        String color = inputScanner.nextLine();
        System.out.println("odometer read: ");
        int odometer = inputScanner.nextInt();
        System.out.println("price: ");
        double price = inputScanner.nextDouble();
        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        // add to vehicles and save to dealership
        dealership.addVehicle(newVehicle);
        DealershipFileManager.saveDealership(dealership);
        System.out.println("saved successfully.");
    }

    private static void ProcessRemoveVehicle() {
        System.out.print("\nEnter the VIN of the vehicle you want to remove: ");
        int vin = Integer.parseInt(inputScanner.nextLine().trim());

        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println("\nVehicle removed successfully and inventory updated.");
        } else {
            System.out.println("\nNo vehicle found with the specified VIN.");
        }
        DealershipFileManager.saveDealership(dealership);
    }

    public static void processSellOrLeaseVehicle(){

        System.out.println("do you wanna buy or lease a vehicle? 1 for buy, 2 for lease");
        int contractChoice = commandScanner.nextInt();
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            System.out.println(vehicle);
        }
        System.out.println("whats the vehicle Vin?");
        int contractedVehicleVin = inputScanner.nextInt();
        // get date from comp
        Date date = new Date();
        inputScanner.nextLine();
        System.out.println("Name: ");
        String name = inputScanner.nextLine();
        System.out.println("Email: ");
        String email = inputScanner.nextLine();

        Vehicle vehicle = dealership.getVehicleByVin(contractedVehicleVin);
         //get total price override method
       // System.out.println("monthly Payment: "); // override method
        System.out.println("do you wanna finance it? 1 ofr yes, 2 for no");
        int financeInput = commandScanner.nextInt();
        boolean financeChoice;
        if(financeInput == 1)
        financeChoice = true;
        else financeChoice = false;
        Contract contract = null; 
        switch (contractChoice){
            case 1:
                contract = new SalesContract(date.toString(), name, email, vehicle, financeChoice);
                break;
            case 2:
                contract = new LeaseContract(date.toString(), name, email, vehicle);
                break;
        }
ContractsFileManager.saveContract(contract);


    }


}