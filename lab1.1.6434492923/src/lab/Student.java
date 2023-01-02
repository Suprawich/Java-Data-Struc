package lab;

public class Student {
    private String stuID, firstName, lastName;
    private float gpax;

    public Student(String id, String fName, String lName, float g) {
        stuID = id;
        firstName = fName;
        lastName = lName;
        gpax = g;
    }

    public Student(String id) {
        stuID = id;
    }

    public void setGPAX(float i) {
        gpax = i;
    }

    public String getID() {
        return stuID;
    }

    public String getFname() {
        return firstName;
    }

    public String getLname() {
        return lastName;
    }

    public float getGPAX() {
        return gpax;
    }

    public boolean equals(Object o) {
        return (o instanceof Student student && student.stuID.equals(stuID));
    }

    public String toString() {
        return getID()+","+getFname()+","+getLname()+","+getGPAX();
    }
}
