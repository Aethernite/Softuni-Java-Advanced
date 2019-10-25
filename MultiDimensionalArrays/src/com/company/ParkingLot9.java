package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ParkingLot9 {
 public static HashMap<Integer, ArrayList<Integer>> matrix = new HashMap<>();
   public static int r;
   public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split("\\s");
        r = Integer.parseInt(dimensions[0]);
        c = Integer.parseInt(dimensions[1]);
        //FILLING WITH ZEROES
        for(int i=0; i<r; i++){
            matrix.put(i, new ArrayList<Integer>());
        }


        while(true){
            String[] input = br.readLine().split("\\s");
            if(input[0].equals("stop")){
                break;
            }
            int z = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);
            park(z,x,y);
        }
    }

    public static void park(int z, int x, int y){
        Position finish = new Position(x,y);
        Position start = new Position(z,0);
        if(isUsed(finish)){
            if(isRowFull(finish)){
                System.out.println("Row " + finish.getX() + " full");
                return;
            }
            int newY = freePlace(finish);
            finish.setY(newY);
        }

        int steps = moveToPosition(start, finish);
        System.out.println(steps);
    }

    public static boolean isRowFull(Position pos){
        for(int i=0; i<c;i++){
            if(!matrix.get(pos.getX()).contains(i)){
                return false;
            }
        }
        return true;
    }

public static int moveToPosition(Position start, Position finish){
        int count = 1;
    while(start.getY() != finish.getY()){
        start.moveRight();
        count++;
    }
        while(start.getX() != finish.getX()){
            if(start.getX() > finish.getX()){
                start.moveUp();
                count++;
            }
            else if(start.getX() < finish.getX()){
                start.moveDown();
                count++;
            }
        }

        matrix.get(finish.getX()).add(finish.getY());
        return count;
}


    public static int freePlace(Position pos) {
        int bestSpotLeft = pos.getY();
        int bestSpotRight = pos.getY();
        for (int i = pos.getY() - 1; i >= 0; i--) {
            if (!matrix.get(pos.getX()).contains(i)) {
                bestSpotLeft = i;
            }
        }
        for (int i = pos.getY() + 1; i < c; i++) {
            if (!matrix.get(pos.getX()).contains(i)) {
                bestSpotRight = i;
            }
        }
        int bestSpot;
        if (bestSpotLeft == 0) {
            bestSpot = bestSpotRight;
        } else if (bestSpotRight == pos.getY()) {
            bestSpot = bestSpotLeft;
        } else {
            int difLeft = pos.getY() - bestSpotLeft;
            int difRight = bestSpotRight - pos.getY();
            if (difRight < difLeft) {    //comparing the differences to find the nearest
                bestSpot = bestSpotRight;
            } else {
                bestSpot = bestSpotLeft;
            }
        }
        return bestSpot;
    }

    public static boolean isUsed(Position pos){
        int x = pos.getX();
        int y = pos.getY();
        if(matrix.get(pos.getX()).contains(pos.getY())){
            return true;
        }
        return false;
    }
}
class Position{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp(){
        x--;
    }

    public void moveDown(){
        x++;
    }

    public void moveLeft(){
        y--;
    }
    public void moveRight(){
        y++;
    }
}