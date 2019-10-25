package CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList <T extends Comparable<T>>{
    List<T> list = new ArrayList<T>();

    public void add(T element){
       list.add(element);
   }

   public T get(int index){
        return list.get(index);
   }

   public int size(){
        return list.size();
   }

   public T remove(int index){
       if (index >= list.size()) {
           throw new IndexOutOfBoundsException();
       }
       return list.remove((int)index);
   }

   public boolean contains(T element){
        if(element==null){
            return false;
        }
        if(list.contains(element)) {
            return true;
        }
        return false;
   }

   public void swap(int index, int index2){
        T temp = list.get(index);
        T temp2 = list.get(index2);
        list.set(index,temp2);
        list.set(index2,temp);
    }

    public int countGreaterThan(T element){
        int count = 0;
        for(T object: list){
            if (object.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

   public T getMax(){
        T max = list.get(0);
        for(T obj: list){
            if(max.compareTo(obj) < 0){
                max = obj;
            }
        }
        return max;
    }
    public T getMin(){
        T min = list.get(0);
        for(T obj: list){
            if(min.compareTo(obj) > 0){
                min = obj;
            }
        }
        return min;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(T obj: list){
            sb.append(obj + "\n");
        }
        sb.replace(sb.length()-1,sb.length()-1,"");
        return sb.toString();
    }
}
