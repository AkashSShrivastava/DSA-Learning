package Recursion;

import java.util.Stack;

public class DeleteMiddleElementStack {

    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        s.add(1);
        s.add(5);
        s.add(4);
        s.add(3);
        s.add(2);
        deleteMid(s,new Stack<Integer>());
        System.out.println(s);
    }

    private static void deleteMid(Stack<Integer> s, Stack<Integer> temp) {
        System.out.println("Stack is::" +s);
        System.out.println("Temp is::" +temp);
        if(s.isEmpty())
            return;
        //mid case
        if(s.size() -1  == temp.size()) {
            s.pop();
            while(!temp.isEmpty())
                s.push(temp.pop());

            return;
        }

        temp.push(s.pop());
        deleteMid(s,temp);
    }
}
