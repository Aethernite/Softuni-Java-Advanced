package SwapGenericIntegers;

import java.util.ArrayList;

public class GenericBox<T> {
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(T obj: list){
            sb.append(obj.getClass().getName() + ": " + obj + "\n");
        }
        return sb.toString();
    }

}
