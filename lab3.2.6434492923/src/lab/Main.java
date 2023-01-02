package lab;

import datastr.ArrayList;
import datastr.SinglyLinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sl = new SinglyLinkedList();
        for (int i = 0; i < 100; i++) {
            sl.add(i);
            //System.out.println(arrayList.size());
        }

        System.out.println("Initial list");
        sl.toString();

        System.out.println("\nReverse");
        sl.reverse();
        sl.toString();

        Random r = new Random();
        int f = r.nextInt(0, sl.size()-1);
        int l = r.nextInt(f, sl.size());
        while (f == l) {
            f = r.nextInt(0, sl.size()-1);
            l = r.nextInt(f, sl.size());
        }

        System.out.println("\nRemove "+f+", "+l);
        sl.removeRange(f, l);
        sl.toString();
    }
}