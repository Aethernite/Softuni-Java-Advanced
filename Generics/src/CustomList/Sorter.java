package CustomList;

public class Sorter {


    public static <T extends Comparable<T>> CustomList<T> sort(CustomList<T> list){
        int size = list.size()-1;
        for(int i=0; i<size;i++){
            for(int j=0; j<size;j++){
                if(list.get(j).compareTo(list.get(j+1))>0){
                    list.swap(j,j+1);
                }
            }
        }
        return list;
    }

}
