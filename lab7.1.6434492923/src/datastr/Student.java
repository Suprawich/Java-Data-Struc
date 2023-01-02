package datastr;

import java.util.Objects;

public class Student {
    private String id, fName, lName;

    public Student(String i, String f, String l) {
        id = i;
        fName = f;
        lName = l;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
