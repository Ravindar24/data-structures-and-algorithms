package LinkedList;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addFirst(0);

//        list.deleteFirst();
//        list.deleteLast();


        var array = list.toArray();
        System.out.println("Before Reversal");
        System.out.println(Arrays.toString(array));
//
//
//        list.reverse();
//
//        var reverseListArray = list.toArray();
//        System.out.println("After Reversal");
//        System.out.println(Arrays.toString(reverseListArray));

        System.out.println(list.kthElementFromEnd(4));
    }

}
