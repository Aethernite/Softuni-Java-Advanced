package spaceStationRecruitment;

import spaceStationRecruitment.Astronaut;

import java.util.ArrayList;
import java.util.List;

public class SpaceStation {
    private String name;
    private int capacity;
    private List<Astronaut> data;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<Astronaut>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount(){
        return this.data.size();
    }

    public void add(Astronaut astronaut){
        if(capacity > data.size()){
            data.add(astronaut);
        }
    }

    public boolean remove(String name){
        for(Astronaut a: data){
            if(a.getName().equals(name)){
                data.remove(a);
                return true;
            }
        }
        return false;
    }


    public Astronaut getOldestAstronaut(){
        Astronaut oldest = data.get(0);
        for(Astronaut a: data){
            if(a.getAge()>oldest.getAge()){
                oldest = a;
            }
        }
        return oldest;
    }

   public Astronaut getAstronaut(String name){
        for(Astronaut a: data){
            if(a.getName().equals(name)){
                return a;
            }
        }
        return null;
   }

   public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Astronauts working at Space Station ").append(name).append(":");
        for(Astronaut a: data){
            sb.append(System.lineSeparator()).append(a.toString());
        }
        return sb.toString().trim();
   }
}
