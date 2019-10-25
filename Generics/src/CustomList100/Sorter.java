package CustomList100;

public final class Sorter {

    private Sorter() {

    }

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        list.sort();
    }
}