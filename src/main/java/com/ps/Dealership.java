package com.ps;

import java.util.ArrayList;
import java.util.List;

    public class Dealership {
        private static String name;
        private static String address;
        private static String phone;

        private static ArrayList<Vehicle> inventory = new ArrayList<>();

        public Dealership(String name, String address, String phone) {
            Dealership.name = name;
            Dealership.address = address;
            Dealership.phone = phone;
        }

        public static String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public static String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public static List<Vehicle> getVehicleByPrice(double minPrice, double maxPrice){
            List<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : inventory) {
                if(minPrice<= vehicle.getPrice() && maxPrice>= vehicle.getPrice())
                    vehicles.add(vehicle);
            }
            return vehicles;
        }
        public static List<Vehicle> getVehicleByMakeModel(String make, String model){
            List<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : inventory) {
                if(make.equalsIgnoreCase(vehicle.getMake()) && model.equalsIgnoreCase(vehicle.getModel()))
                    vehicles.add(vehicle);
            }
            return vehicles;
        }
        public static List<Vehicle> getVehicleByYear(int minYear, int maxYear){
            List<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : inventory) {
                if(vehicle.getYear()>=minYear && vehicle.getYear()<=maxYear)
                    vehicles.add(vehicle);
            }
            return vehicles;
        }
        public static List<Vehicle> getVehicleByColor(String color){
            List<Vehicle> vehicles = new ArrayList<>();
            for(Vehicle vehicle :inventory) {
                if (color.equalsIgnoreCase(vehicle.getColor()))
                    vehicles.add(vehicle);

            }
            return vehicles;
        }

        public static List<Vehicle> getVehicleByMilage(int minMile, int maxMile){
            List<Vehicle> vehicles = new ArrayList<>();
            for(Vehicle vehicle :inventory)
                if(vehicle.getOdometer()>= minMile && vehicle.getOdometer()<=maxMile)
                {
                    vehicles.add(vehicle);
                }
            return vehicles;

        }

        public static List<Vehicle> getVehicleByType(String vehicleType){
            List<Vehicle> vehicles = new ArrayList<>();
            for(Vehicle vehicle :inventory) {
                if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType))
                    vehicles.add(vehicle);
            }
            return vehicles;
        }

        public static List<Vehicle> getAllVehicles(){
            return inventory;
        }

        public void addVehicle(Vehicle vehicle){
            inventory.add(vehicle);
           // FileManager.saveDealership(this);
        }

        public static void removeVehicle(Vehicle vehicle){

            inventory.remove(vehicle);

        }

      //  public void setInventory(ArrayList<Vehicle> vehicles) {
        //    inventory = vehicles;
      //  }

}

