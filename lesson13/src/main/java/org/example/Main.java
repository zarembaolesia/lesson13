package org.example;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Doe");
        Student student2 = new Student("Jane", "Smith");
        Student student3 = new Student("Tom", "Brown");
        Student student4 = new Student("Mary", "Teal");

        StudentGroup group1 = new StudentGroup(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);
        group1.addTask("learn encapsulation");
        group1.changeHeadOfTheClass(student4);
        group1.addStudent(student4);
        group1.markTaskAsCompleted(student1, "learn encapsulation");
        group1.markTaskAsCompleted(student1, "learn encapsulation");
        group1.markTaskAsCompleted(student4, "learn encapsulation");
        group1.markTaskAsCompleted(student2, "fake task");
        group1.deleteStudent(student3);

        for (Student student : group1.getStudents()) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Completed tasks:");
            for (String task : group1.getCompletedTasks(student)) {
                System.out.println("- " + task);
            }
            System.out.println("---------------------");
        }
    }
}