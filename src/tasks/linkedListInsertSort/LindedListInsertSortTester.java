package tasks.linkedListInsertSort;

import goldman.collection.positional.SinglyLinkedList;

public class LindedListInsertSortTester {

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
        list.insertionsort();
        System.out.println("Nachhher: "+list.toString());
    }
}
