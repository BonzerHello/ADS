package tasks.linkedListQuickSort;

import goldman.collection.positional.SinglyLinkedList;

public class LinkedLIstQuickSortTester {
    public static void main(String[] args){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(11);
        list.add(4);
        list.add(9);
        list.add(7);
        list.add(3);
        list.add(10);
        list.add(2);
        list.add(6);
        System.out.println("Vorher: "+list.toString());
        list.quicksort();
        System.out.println("Nachher: "+list.toString());
    }
}
