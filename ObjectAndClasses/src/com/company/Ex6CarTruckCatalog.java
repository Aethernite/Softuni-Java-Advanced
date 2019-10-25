package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6CarTruckCatalog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> catalogue = new ArrayList<Vehicle>();


        while(true){
            String[] input = scanner.nextLine().split(" ");
            if(input[0].toLowerCase().equals("end")){
                break;
            }
            if(input[0].toLowerCase().equals("car")){
                input[0] = "Car";
            }
            else{
                input[0] = "Truck";
            }
            Vehicle veh = new Vehicle(input[0], input[1], input[2].toLowerCase(), Integer.parseInt(input[3]));
            catalogue.add(veh);
        }

        while(true){
            String input = scanner.nextLine();
            if(input.toLowerCase().equals("close the catalogue")){
                break;
            }
            printModel(input,catalogue);
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n",calculateHorsepower(catalogue,"Car"));
        System.out.printf("Trucks have average horsepower of: %.2f.",calculateHorsepower(catalogue,"Truck"));







    }
    public static double calculateHorsepower(ArrayList<Vehicle> cat, String type){
        double sum = 0;
        int count = 0;
        for(Vehicle veh: cat){
            if(veh.getType().equals(type)){
                sum+=veh.getHorsePower();
                count++;
            }
        }
        if(count==0){
            return 0;
        }
        return sum/count;
    }

    public static void printModel(String model, ArrayList<Vehicle> list){
        for(Vehicle veh: list){
            if(veh.getModel().toLowerCase().equals(model.toLowerCase())){
                System.out.println(veh);
                break;
            }
        }
    }
}
class Vehicle{
    String type;
    String model;
    String color;
    int horsePower;

    public Vehicle(String type, String model, String color, int horsePower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString(){
        if(this.type.equals("car")) {
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", this.type,this.model, this.color, this.horsePower);
        }
        else{
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d",this.type, this.model, this.color, this.horsePower);
        }
    }
}