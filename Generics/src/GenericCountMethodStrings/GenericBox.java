package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class GenericBox<T extends Comparable<T>> {
    private ArrayList<T> list = new ArrayList<T>();


    public void add(T object){
        list.add(object);
    }

    public void swap(int index, int index2){
        T temp = list.get(index);
        T temp2 = list.get(index2);
        list.set(index,temp2);
        list.set(index2,temp);
    }


    public int count(List<T> list, T element){
        int count = 0;
        for(T object: list){
            if (object.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
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
