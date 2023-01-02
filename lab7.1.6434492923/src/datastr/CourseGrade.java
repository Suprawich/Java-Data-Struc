package datastr;

public class CourseGrade {
    private String cID, cName, year;
    private int weight, semester;
    private double grade;

    public CourseGrade(String id, String name, int sem, String y, int w, double g) {
        cID = id;
        cName = name;
        year = y;
        weight = w;
        semester = sem;
        grade = g;
    }

    public String toString() {
        String s = cID+"\t"+cName+"\t"+year+"/"+semester+"\t"+weight+"\t"+grade;
        return s;
    }
}
