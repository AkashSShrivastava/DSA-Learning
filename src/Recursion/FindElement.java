package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FindElement {
    public static void main(String[] args) {
        System.out.println(findElement(new int[] {1,2,3,3,4,5,6}, 3, 0, new ArrayList<>()));
        System.out.println(findElement(new int[] {1,2,3,3,4,5,6}, 3, 0));
    }

    static List<Integer> findElement(int[] arr, int target, int index, ArrayList<Integer> list) {
        if(index == arr.length){
            return list;
        }

        if(target == arr[index]){
            list.add(index);
        }

        findElement(arr, target, index+1, list);
        return list;
    }


    static List<Integer> findElement(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }

        if(target == arr[index]){
            list.add(index);
        }

        list.addAll(findElement(arr, target, index+1));
        return list;
    }

    static List<Integer> findElementTemp(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }

        if(target == arr[index]){
            list.add(index);
        }
        List<Integer> prevList = findElementTemp(arr, target, index+1);
        list.addAll(prevList);
        return list;
    }
}
