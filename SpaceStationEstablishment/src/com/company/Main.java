package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static char[][] matrix;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Position blackHole1;
    public static boolean blackHoleFound = false;
    public static Position blackHole2;
    public static Position ship;
    public static boolean shipFound = false;
    public static int n;
    public static int energy = 0;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
	matrix = new char[n][n];
	initializeMatrix();
	while(true){
	    String input = br.readLine();


	    switch(input){
            case "up":
                matrix[ship.getR()][ship.getC()] = '-';
                ship.setR(ship.getR()-1);
                if(!positionIsValid(ship)){
                    System.out.println("Bad news, the spaceship went to the void.");
                    System.out.println("Star power collected: " + energy);
                    printMatrix();
                    return;
                }
                if(Character.isDigit(matrix[ship.getR()][ship.getC()])){
                    energy += (matrix[ship.getR()][ship.getC()]-48);
                }
                if(matrix[ship.getR()][ship.getC()] == 'O'){
                    moveToOtherBlackHole();
                }
                matrix[ship.getR()][ship.getC()] = 'S';
                if(energy>=50){
                    System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                    System.out.println("Star power collected: " + energy);
                    printMatrix();
                    return;
                }
                break;
            case "left":
                matrix[ship.getR()][ship.getC()] = '-';
                ship.setC(ship.getC()-1);
                if(!positionIsValid(ship)){
                    System.out.println("Bad news, the spaceship went to the void.");
                    System.out.println("Star power collected: " + energy);
                    printMatrix();
                    return;
                }
                if(Character.isDigit(matrix[ship.getR()][ship.getC()])){
                    energy += (matrix[ship.getR()][ship.getC()]-48);
                }
                if(matrix[ship.getR()][ship.getC()] == 'O'){
                    moveToOtherBlackHole();
                }
                matrix[ship.getR()][ship.getC()] = 'S';
                if(energy>=50){
                    System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                    System.out.println("Star power collected: " + energy);
                    printMatrix();
                    return;
                }
                break;
            case "right":
                matrix[ship.getR()][ship.getC()] = '-';
                ship.setC(ship.getC()+1);
                if(!positionIsValid(ship)){
                    System.out.println("Bad news, the spaceship went to the void.");
                    System.out.println("Star power collected: " + energy);
                    printMatrix();
                    return;
                }
                if(Character.isDigit(matrix[ship.getR()][ship.getC()])){
                    energy += (matrix[ship.getR()][ship.getC()]-48);
                }
                if(matrix[ship.getR()][ship.getC()] == 'O'){
                    moveToOtherBlackHole();
                }
                matrix[ship.getR()][ship.getC()] = 'S';
                if(energy>=50){
                    System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                    System.out.println("Star power collected: " + energy);
                    printMatrix();
                    return;
                }
                break;
            case "down":
                matrix[ship.getR()][ship.getC()] = '-';
                ship.setR(ship.getR()+1);
                if(!positionIsValid(ship)){
                    System.out.println("Bad news, the spaceship went to the void.");
                    System.out.println("Star power collected: " + energy);
                    printMatrix();
                    return;
                }
                if(Character.isDigit(matrix[ship.getR()][ship.getC()])){
                    energy += (matrix[ship.getR()][ship.getC()]-48);
                }
                if(matrix[ship.getR()][ship.getC()] == 'O'){
                    moveToOtherBlackHole();
                }
                matrix[ship.getR()][ship.getC()] = 'S';
                if(energy>=50){
                    System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                    System.out.println("Star power collected: " + energy);
                    printMatrix();
                    return;
                }
                break;

        }
    }


    }
    public static boolean positionIsValid(Position p){
        if(p.getR()<0 || p.getR()>=n){
            return false;
        }
        if(p.getC()<0 || p.getC()>=n){
            return false;
        }
        return true;


    }


    public static void printMatrix(){
        for(int i=0; i<n; i++){
            System.out.println(matrix[i]);
        }
    }


    public static void moveToOtherBlackHole(){
        if(ship.getR() == blackHole1.getR() && ship.getC() == blackHole1.getC()){
            matrix[ship.getR()][ship.getC()] = '-';
            ship.setR(blackHole2.getR());
            ship.setC(blackHole2.getC());
            matrix[ship.getR()][ship.getC()] = 'S';
        }else{
            matrix[ship.getR()][ship.getC()] = '-';
            ship.setR(blackHole1.getR());
            ship.setC(blackHole1.getC());
            matrix[ship.getR()][ship.getC()] = 'S';
        }
    }






    public static void initializeMatrix() throws IOException{
        for(int i=0; i<matrix.length; i++){
            String line = br.readLine();
            for(int j=0; j<line.length(); j++){
                if(line.charAt(j) == 'S' && !shipFound){
                    ship = new Position(i,j);
                }
                else if(line.charAt(j) == 'O' && !blackHoleFound){
                    blackHole1 = new Position(i,j);
                    blackHoleFound = true;
                }
                else if(line.charAt(j) == 'O' && blackHoleFound){
                    blackHole2 = new Position(i,j);
                }
            }
            char[] input = line.toCharArray();
            matrix[i] = input;
        }
    }

}
class Position{
    int r;
    int c;

    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}