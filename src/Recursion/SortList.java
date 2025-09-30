package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<Integer> arrayList= Arrays.asList(1,2,0,4,5,12,7);
        System.out.println("New Sorted List is:::");
        System.out.println(sort(arrayList, new ArrayList<>()));
    }

    private static List<Integer> sort(List<Integer> arrayList, ArrayList<Integer> es) {
        if(arrayList.isEmpty())
            return null;

        int element = arrayList.get(0);
        addAndSort(es,element);

        sort(arrayList.subList(1,arrayList.size()), es);
        return es;
    }


    private static void addAndSort(ArrayList<Integer> list, int element) {
        list.add(element);
        list.sort(Comparator.naturalOrder());
    }
}
