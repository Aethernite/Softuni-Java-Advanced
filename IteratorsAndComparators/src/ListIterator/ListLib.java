package ListIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListLib<String> {
    private List<String> list;
    private int internalIndex = 0;
    public ListLib(String... strings){
        if(strings.length==0){
            list = new ArrayList<String>();
        }
        list = Arrays.asList(strings);
    }


    public void print(){
        if(list.size()==0){
            System.out.println("Invalid Operation!");
            return;
        }
        System.out.println(list.get(internalIndex));
    }

    public boolean move(){
        if(internalIndex == list.size()-1){
            return false;
        }
        internalIndex++;
        return true;
    }
    public boolean hasNext() {

        if(this.internalIndex < list.size()-1) { return true; }

        return false;

    }


public void printAll(){
        for(String str: list){
            System.out.print(str + " ");
        }
        System.out.println();
}

}
