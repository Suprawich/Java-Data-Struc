import datastr.CourseGrade;
import datastr.SeparateChainingHashMap;
import datastr.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SeparateChainingHashMap sp = new SeparateChainingHashMap(15);

        Scanner sc = new Scanner(new File("src/datastr/register.csv"));

        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] string = s.split(",");
            Student student = new Student(string[0], string[1], string[2]);
            CourseGrade courseGrade = new CourseGrade(string[3], string[4], Integer.parseInt(string[5]), string[6], Integer.parseInt(string[7]), Double.parseDouble(string[8]));
            ArrayList<CourseGrade> cg = new ArrayList<>();
            if (sp.containsKey(student)) {
                cg = (ArrayList<CourseGrade>) sp.get(student);
            }
            cg.add(courseGrade);
            sp.put(student, cg);
        }
        sc.close();
        System.out.println(sp);
    }
}