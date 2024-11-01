package com.ps;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static Scanner commandScanner = new Scanner(System.in);
    private static Scanner inputScanner = new Scanner(System.in);
    private static List<Vehicle> vehicles;
    private static Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }
    // init() method and mkae it static to initilize
    public static void init(){
        //Loading the dealership and inventory from a file
        dealership = FileManager.getDealership();
    }
    //helper method // dispalayvehicles
    public static void displayScreen() {
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
            System.out.println("99. Quit");

            command = commandScanner.nextInt();

            //switch

            switch (command) {
                case 1:
                    System.out.println("enter mimimum price: ");
                    double min = inputScanner.nextDouble();
                    System.out.println("enter your max: ");
                    double max = inputScanner.nextDouble();
                    vehicles = Dealership.getVehicleByPrice(min, max);
                    for (Vehicle v: vehicles) {
                        System.out.println(v);
                    }
                    break;
                case 2:
                    System.out.println("whats the make? ");
                    String carMake = inputScanner.nextLine();
                    System.out.println("model? ");
                    String carModel = inputScanner.nextLine();

                    vehicles = dealership.getVehicleByMakeModel(carMake, carModel);
                    for (Vehicle v: vehicles) {
                        System.out.println(v);
                    }
                    break;
                case 3:
                    System.out.println("enter your min year: ");
                    int year1 = inputScanner.nextInt();
                    System.out.println("enter your max year: ");
                    int year2 = inputScanner.nextInt();

                    vehicles = dealership.getVehicleByYear(year1, year2);
                    for (Vehicle v: vehicles) {
                        System.out.println(v);
                    }
                    break;
                case 4:
                    System.out.println("What color are you looking for? ");
                    String col = inputScanner.nextLine();

                    vehicles = dealership.getVehicleByColor(col);
                    for (Vehicle v: vehicles) {
                        System.out.println(v);
                    }
                    break;
                case 5:
                    System.out.println("min Milage: ");
                    int minMilage = inputScanner.nextInt();
                    System.out.println("max Milage");
                    int maxMilage = inputScanner.nextInt();
                    vehicles = Dealership.getVehicleByMilage(minMilage,maxMilage);
                    for (Vehicle v: vehicles) {
                        System.out.println(v);
                    }

                    break;
                case 6:
                    System.out.println("What type od car are you looking for? ");
                    String type = inputScanner.nextLine();
                    vehicles = Dealership.getVehicleByType(type);
                    for (Vehicle v: vehicles) {
                        System.out.println(v);
                    }
                    break;
                case 7:
                    System.out.println("all available cars: ");
                    vehicles = Dealership.getAllVehicles();
                    for (Vehicle v: vehicles) {
                        System.out.println(v);
                    }
                    break;
                case 8:
                    System.out.println("Enter Vehicle Data: ");
                    System.out.println("Vin number: ");
                    int vin =  inputScanner.nextInt();
                    System.out.println("Year: ");
                    int year = inputScanner.nextInt();
                    inputScanner.nextLine();
                    System.out.println("make: ");
                    String make = inputScanner.nextLine();
                    System.out.println("model: ");
                    String model = inputScanner.nextLine();
                    System.out.println("type: ");
                    String vehicleType= inputScanner.nextLine();
                    System.out.println("color: ");
                    String color= inputScanner.nextLine();
                    System.out.println("odometer read: ");
                    int odometer = inputScanner.nextInt();
                    System.out.println("price: ");
                    double price = inputScanner.nextDouble();
                    Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    // add to vehicles and save to dealership
                    dealership.addVehicle(newVehicle);
                    // DealershipFileManager.saveDealership();

                    break;
                case 9:
                    System.out.println("whats the vehicle's vin number? ");
                    int vinToRemove =inputScanner.nextInt();
                    Dealership.removeVehicle(vinToRemove);
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


}