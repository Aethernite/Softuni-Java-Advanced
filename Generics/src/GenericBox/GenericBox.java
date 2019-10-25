package GenericBox;

import java.util.ArrayList;

public class GenericBox<T> {
    private ArrayList<T> list = new ArrayList<T>();


    public void add(T object){
        list.add(object);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(T obj: list){
            sb.append(obj.getClass().getName() + ": " + obj + "\n");
        }
        return sb.toString();
    }
}
