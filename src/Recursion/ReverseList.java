package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> arrayList= Arrays.asList(1,2,3,4,5,6,7);
        System.out.println("New Reversed List is:::");
        System.out.println(reverse(arrayList));
    }

    //BHI hypothesis
    public static List<Integer> reverse(List<Integer> list) {
        if(list.isEmpty())
            return new ArrayList<>();

        List<Integer> newArrayList = new ArrayList<>();
        newArrayList.add(list.get(list.size()-1));
        newArrayList.addAll(reverse(list.subList(0,list.size()-1)));
        return newArrayList;
    }
}
