package org.example;

public class Student {
    private static int uniqueId = 1;
    private int studentId;
    private String firstName;
    private String lastName;
    public Student(String firstName, String lastName){
        this.studentId = uniqueId++;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
