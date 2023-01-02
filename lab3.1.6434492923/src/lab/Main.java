package lab;

import datastr.ArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(100);
        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
            //System.out.println(arrayList.size());
        }

        System.out.println("Initial list");
        arrayList.toString();

        System.out.println("\nReverse");
        arrayList.reverse();
        arrayList.toString();

        Random r = new Random();
        int f = r.nextInt(0, arrayList.size()-1);
        int l = r.nextInt(f, arrayList.size());
        while (f == l) {
            f = r.nextInt(0, arrayList.size()-1);
            l = r.nextInt(f, arrayList.size());
        }

        System.out.println("\nRemove "+f+", "+l);
        arrayList.removeRange(f, l);
        arrayList.toString();
    }
}