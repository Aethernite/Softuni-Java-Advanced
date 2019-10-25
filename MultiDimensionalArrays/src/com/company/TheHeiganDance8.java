package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TheHeiganDance8 {
    public static int[][] chamber = getChamber();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boss heigan = new Boss();
        Player player = new Player();
        double damage = Double.parseDouble(br.readLine());
        while(true){
            String[] input = br.readLine().split("\\s+");
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);
            heigan.takeDamage(damage);
            if(!heigan.isAlive()){
                System.out.println("Heigan: Defeated!");
                System.out.println(String.format("Player: %.0f", player.getHp()));
                System.out.println(String.format("Final position: %d, %d",player.getX(), player.getY()));
                return;
            }
            if(heigan.isAlive()) {
                switch (input[0]) {
                    case "Eruption":
                        if(player.isAffected()){
                            player.takeDamage(3500);
                            player.setAffected(false);
                        }
                        setDamagedCells(x, y);
                        if(isWithinArea(chamber, player)){
                            player.takeDamage(6000);
                            if(!player.isAlive()){
                                System.out.println(String.format("Heigan: %.2f", heigan.getHp()));
                                System.out.println("Player: Killed by Eruption");
                                System.out.println(String.format("Final position: %d, %d",player.getX(), player.getY()));
                                return;
                            }
                        }
                        removeDamagedCells(x, y);
                        break;
                    case "Cloud":
                        setDamagedCells(x, y);
                        if(player.isAffected()){
                            player.takeDamage(3500);
                            player.setAffected(false);
                        }
                        if(isWithinArea(chamber, player)){
                            player.takeDamage(3500);
                            if(!player.isAlive()){
                                System.out.println(String.format("Heigan: %.2f", heigan.getHp()));
                                System.out.println("Player: Killed by Plague Cloud");
                                System.out.println(String.format("Final position: %d, %d",player.getX(), player.getY()));
                                return;
                            }
                            player.setAffected(true);
                            removeDamagedCells(x, y);
                        }
                        break;
                }

            }


            }
        }

    private static void removeDamagedCells(int x, int y) {
        chamber[x][y] = chamber[x][y]+1;
        try {
            chamber[x + 1][y] =chamber[x + 1][y]+1;
        } catch(Exception e){
        }
        try {
            chamber[x - 1][y] = chamber[x - 1][y]+1;
        } catch(Exception e){
        }
        try {
            chamber[x][y + 1] = chamber[x][y + 1]+1;
        } catch(Exception e){
        }
        try{
            chamber[x][y-1] = chamber[x][y-1]+1;
        } catch(Exception e){
        }
        try{
            chamber[x-1][y-1] = chamber[x-1][y-1]+1;
        } catch(Exception e){
        }
        try{
            chamber[x+1][y+1] = chamber[x+1][y+1]+1;
        } catch(Exception e){
        }
        try{
            chamber[x-1][y+1] = chamber[x-1][y+1]+1;
        } catch(Exception e){
        }
        try{
            chamber[x+1][y-1] = chamber[x+1][y-1]+1;
        } catch(Exception e){
        }
    }

    private static void setDamagedCells(int x, int y) {
        chamber[x][y] = -1;
        try {
            chamber[x + 1][y] = -1;
        } catch(Exception e){
        }
        try {
            chamber[x - 1][y] = -1;
        } catch(Exception e){
        }
        try {
            chamber[x][y + 1] = -1;
        } catch(Exception e){
        }
        try{
            chamber[x][y-1] = -1;
        } catch(Exception e){
        }
        try{
            chamber[x-1][y-1] = -1;
        } catch(Exception e){
        }
        try{
            chamber[x+1][y+1] = -1;
        } catch(Exception e){
        }
        try{
            chamber[x-1][y+1] = -1;
        } catch(Exception e){
        }
        try{
            chamber[x+1][y-1] = -1;
        } catch(Exception e){
        }
    }




    public static boolean isWithinArea(int[][] chamber, Player player) {
            int x = player.getX();
            int y = player.getY();

            if (chamber[x][y] < 0) {
                try {
                    if (!(chamber[x + 1][y] == -1)) {
                        player.setX(x + 1);
                        player.setY(y);
                        return false;
                    }
                } catch (Exception e) {
                }
                try {
                    if (!(chamber[x][y + 1] < 0)) {
                        player.setX(x);
                        player.setY(y + 1);
                        return false;
                    }
                } catch (Exception e2) {
                }
                try {
                    if (!(chamber[x - 1][y] < 0)) {
                        player.setX(x - 1);
                        player.setY(y);
                        return false;
                    }
                } catch (Exception e3) {
                }
                try {
                    if (!(chamber[x][y - 1] < 0)) {
                        player.setX(x);
                        player.setY(y - 1);
                        return false;
                    }
                } catch (Exception e4) {
                }
                return true;
            }
            return false;
        }


       public static int[][] getChamber(){
           int[][] chamber = new int[15][15];

           for(int i=0; i<chamber.length; i++){
               for(int j=0; j<chamber[0].length; j++){
                   chamber[i][j]=0;
               }
           }
           return chamber;
       }
    }





class Boss{
    private double hp;
    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public Boss() {
        this.hp = 3000000;
    }

    public boolean isAlive() {
        if(hp>0){
            return true;
        }
        return false;
    }
    public void takeDamage(double damage){
        hp-=damage;
    }

}

class Player{
    double hp;
    boolean affected;
    int x;
    int y;

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

    public Player() {
        this.hp = 18500;
        this.affected = false;
        x=7;
        y=7;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public boolean isAffected() {
        return affected;
    }

    public void setAffected(boolean affected) {
        this.affected = affected;
    }

    public void takeDamage(double damage){
        hp-=damage;
    }

    public boolean isAlive() {
        if(hp>0){
            return true;
        }
        return false;
    }
}