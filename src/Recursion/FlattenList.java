package Recursion;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class FlattenList {
    public static void main(String[] args) {
        List<Object> nestedList = new ArrayList<>();

        nestedList.add(1);

        List<Object> innerList1 = new ArrayList<>();
        innerList1.add(2);

        List<Object> innerList2 = new ArrayList<>();
        innerList2.add(3);
        innerList2.add(4);

        innerList1.add(innerList2);
        innerList1.add(5);

        nestedList.add(innerList1);

        nestedList.add(6);

        System.out.println(flattenListRecursion(nestedList, new ArrayList<Integer>()));
    }

    private static List<Integer> flattenListRecursion(List<Object> nestedList, List<Integer> finalList) {
        for(Object current: nestedList) {
            if(current instanceof Integer) {
                finalList.add((int)current);
            }

            if(current instanceof List) {
                if(((List<?>) current).isEmpty()){
                    continue;
                }
                else
                    flattenListRecursion((List<Object>) current, finalList);
            }
        }

        return finalList;
    }
}
