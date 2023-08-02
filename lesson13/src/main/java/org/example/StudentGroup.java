package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StudentGroup implements IHeadOfTheClass{
    private Student headOfTheClass;
    private List<Student> students;
    private List<String> tasks;
    private Map<String, List<Student>> completedTasksMap;

    public StudentGroup(Student headOfTheClass) {
        this.headOfTheClass = headOfTheClass;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.completedTasksMap = new HashMap<>();
        addStudent(headOfTheClass);
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public void deleteStudent(Student student) {
        if (student == headOfTheClass){
            System.out.println("You can`t remove " + student.getFirstName() +" "+student.getLastName() +", because they are head of the class. Change the head of the class first.");
            System.out.println("---------------------");
        } else {
            students.remove(student);
            completedTasksMap.remove(student);
        }
    }

    public void addTask(String task) {
        tasks.add(task);
        completedTasksMap.put(task, new ArrayList<>());
    }

    public void markTaskAsCompleted(Student student, String title) {
        if (tasks.contains(title)) {
            List<Student> completedStudents = completedTasksMap.get(title);
            if (!completedStudents.contains(student)) {
                completedStudents.add(student);
            }
        }
    }

    public List<String> getCompletedTasks(Student student) {
        List<String> completedTasksList = new ArrayList<>();

        for (Map.Entry<String, List<Student>> entry : completedTasksMap.entrySet()) {
            if (entry.getValue().contains(student)) {
                completedTasksList.add(entry.getKey());
            }
        }

        return completedTasksList;
    }

    @Override
    public Student changeHeadOfTheClass(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
        headOfTheClass = student;
        return headOfTheClass;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
