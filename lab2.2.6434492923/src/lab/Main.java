package lab;

import datastr.LinkedCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/lab/student.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        LinkedCollection student = new LinkedCollection();
        while (sc.hasNext()) {
            String a = sc.next();
            String[] arr = a.split(",");
            String id = arr[0].trim();
            String fName = arr[1].trim();
            String lName = arr[2].trim();
            String g = arr[3].trim();
            float gpax = Float.parseFloat(g);
            Student s = new Student(id, fName, lName, gpax);
            student.add(s);
        }
        sc.close();
        try {
            sc = new Scanner(new File("src/lab/withdraw.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        LinkedCollection withdraw = new LinkedCollection();
        while (sc.hasNext()) {
            String a = sc.next();
            String[] arr = a.split(",");
            String id = arr[0].trim();
            String fName = arr[1].trim();
            String lName = arr[2].trim();
            String g = arr[3].trim();
            float gpax = Float.parseFloat(g);
            Student s = new Student(id, fName, lName, gpax);
            withdraw.add(s);
        }
        sc.close();
        //student.csv
        if (student.containsDup()) {
            System.out.println("Duplicate students in file. Removed.");
            student.removeDup();
        }
        else {
            System.out.println("No duplicate student.");
        }
        //withdraw.csv
        if (withdraw.containsDup()) {
            System.out.println("Duplicate withdraws in file. Removed.\n");
            withdraw.removeDup();
        }
        else {
            System.out.println("No duplicate withdraw.\n");
        }

        if (!student.equals(withdraw)) {
            Object[] withdrawArr = withdraw.toArray();
            for (int i = 0; i < withdraw.size(); i++) {
                student.removeAll(withdrawArr[i]);
            }
            Object[] stuArr = student.toArray();
            System.out.println("All registered ("+student.size()+")");
            for (Object a : stuArr) {
                System.out.println(a);
            }
            System.out.println("\nAll withdrew ("+withdraw.size()+")");
            for (Object a : withdrawArr) {
                System.out.println(a);
            }
        }
        else {
            Object[] withdrawArr = withdraw.toArray();
            System.out.println("All withdrew ("+withdraw.size()+")");
            for (Object a : withdrawArr) {
                System.out.println(a);
            }
        }
    }
}
