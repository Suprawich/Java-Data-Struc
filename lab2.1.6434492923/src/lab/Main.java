package lab;

import datastr.LinkedCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner sc = null;
        try {
            sc = new Scanner(new File("src/lab/student.csv"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        LinkedCollection lc = new LinkedCollection();
        while (sc.hasNext()) {
            String a = sc.next();
            String[] arr = a.split(",");
            String id = arr[0].trim();
            String fName = arr[1].trim();
            String lName = arr[2].trim();
            String g = arr[3].trim();
            float gpax = Float.parseFloat(g);
            Student s = new Student(id, fName, lName, gpax);
            lc.add(s);
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
                    if (lc.contains(s)) { //remove and add
                        lc.remove(s);
                        lc.add(s);
                        System.out.println("Replace the record");
                    } else {
                        lc.add(s);
                        System.out.println("Add new record");
                    }
                    break;
                case "delete":
                    String input1 = inp.nextLine().trim();
                    Student delStu = new Student(input1);
                    if (lc.contains(delStu)) {
                        lc.remove(delStu);
                        System.out.println("Remove a record");
                    }
                    else {
                        System.out.println("No such student");
                    }
                    break;
                case "stop":
                    try {
                        FileWriter myWriter = new FileWriter("src/lab/studentNEW.csv");
                        Object[] objArr = lc.toArray();
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
        }*/
        LinkedCollection lc = new LinkedCollection();
        lc.add(5);
        lc.add(6);
    }
}