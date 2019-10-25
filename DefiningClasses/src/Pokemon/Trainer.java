package Pokemon;


import java.util.ArrayList;
import java.util.Comparator;

public class Trainer{
    String name;
    int badges;
    ArrayList<Pokemon> collection;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.collection = new ArrayList<Pokemon>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public ArrayList<Pokemon> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<Pokemon> collection) {
        this.collection = collection;
    }

    public void tournament(String type){
        boolean doesntHave = true;
        for(Pokemon poke: collection){
            if(poke.getElement().equals(type)){
                badges++;
                doesntHave = false;
                break;
            }
        }
        if(doesntHave){
            ArrayList<Pokemon> toRemove = new ArrayList<Pokemon>();
            for(Pokemon poke: collection){
                    poke.setHealth(poke.getHealth()-10);
                    if(poke.getHealth() <= 0) {
                       toRemove.add(poke);
                    }
                }
            collection.removeAll(toRemove);
            }
        }

    }

