package lab;

import datastr.ArraySet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/lab/student.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        ArraySet ac = new ArraySet(5);
        while (sc.hasNext()) {
            String a = sc.next();
            String[] arr = a.split(",");
            String id = arr[0];
            String fName = arr[1];
            String lName = arr[2];
            String g = arr[3];
            float gpax = Float.parseFloat(g);
            Student s = new Student(id, fName, lName, gpax);
            ac.add(s);
        }
        sc.close();
        boolean command = true;
        while (command) {
            System.out.println("add or delete or stop");
            Scanner inp = new Scanner(System.in);
            String a = inp.nextLine();
            switch (a) {
                case "add":
                    String id = inp.next();
                    String fName = inp.next();
                    String lName = inp.next();
                    float gpax = inp.nextFloat();
                    Student s = new Student(id, fName, lName, gpax);
                    if (ac.contains(s)) { //remove and add
                        ac.remove(s);
                        ac.add(s);
                        System.out.println("Replace the record");
                    } else {
                        ac.add(s);
                        System.out.println("Add new record");
                    }
                    break;
                case "delete":
                    String input1 = inp.nextLine().trim();
                    Student delStu = new Student(input1);
                    if (ac.contains(delStu)) {
                        ac.remove(delStu);
                        System.out.println("Remove a record");
                    }
                    break;
                case "stop":
                    try {
                        FileWriter myWriter = new FileWriter("src/lab/studentNEW.csv");
                        Object[] objArr = ac.toArray();
                        for (Object o : objArr) {
                            if (o instanceof Student) {
                                Student student = (Student)o;
                                myWriter.write(student.toString()+"\n");
                            }
                        }
                        myWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    command = false;
                    System.out.println("Written to studentNEW.csv");
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}