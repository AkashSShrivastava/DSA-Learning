package Recursion;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3124);
        s.push(3);
        s.push(3121);
        s.push(243);
        s.push(2);
        s.push(234);
        s.push(2);
        s.push(32);
        s.push(123212);
        s.push(-2);
        Stack<Integer> newStack = new Stack<>();
        sort(s,newStack);
        System.out.println(newStack);
        System.out.println("Reversing a Stack");
        System.out.println(reverse(newStack));

    }

    public static Stack<Integer> reverse(Stack<Integer> s) {
        if(s.isEmpty()) {
            return s;
        }
        int element = s.pop();
        reverse(s);
        s.push(element);
        return s;
    }

    public static void sort(Stack<Integer> s, Stack<Integer> newStack) {
        if(s.isEmpty())
            return;
        popAndSort(newStack, s.pop());
        sort(s,newStack);
    }

    public static void popAndSort(Stack<Integer> newStack, int element) {
        System.out.println("Element is:: "+element);
        if(newStack.isEmpty()){
            newStack.push(element);
            return;
        }
        Stack<Integer> temp = new Stack<>();
        while(!newStack.isEmpty()){
            if(element>newStack.peek()){
                break;
            }
            temp.push(newStack.pop());
        }
        System.out.println("temp is::" + temp);
        System.out.println("New stack is::" + newStack);
        newStack.push(element);
        while(!temp.isEmpty()) {
            newStack.push(temp.pop());
        }
        System.out.println("New updated New Stack is::"+ newStack);
    }
}
