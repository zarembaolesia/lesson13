package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StudentGroup implements IHeadOfTheClass{
    private Student headOfTheClass;
    private List<Student> students;
    private List<String> tasks;
    private Map<Student, Map<String, Boolean>> completedTasksMap;

    public StudentGroup(Student headOfTheClass) {
        this.headOfTheClass = headOfTheClass;
        this.students = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.completedTasksMap = new HashMap<>();
        addStudent(headOfTheClass);
    }

    public Student addStudent(Student student) {
        students.add(student);
        completedTasksMap.put(student, new HashMap<>());
        return student;
    }

    public void deleteStudent(Student student) {
        students.remove(student);
        completedTasksMap.remove(student);
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(Student student, String title) {
        if (tasks.contains(title)) {
            Map<String, Boolean> completedTasks = completedTasksMap.get(student);
            completedTasks.put(title, true);
        }
    }
    public List<String> getCompletedTasks(Student student) {
        List<String> completedTasksList = new ArrayList<>();

        Map<String, Boolean> completedTasks = completedTasksMap.get(student);
        if (completedTasks == null) {
            return completedTasksList;
        }

        for (Map.Entry<String, Boolean> entry : completedTasks.entrySet()) {
            if (entry.getValue()) {
                completedTasksList.add(entry.getKey());
            }
        }

        return completedTasksList;
    }

    @Override
    public Student changeHeadOfTheClass(Student student) {
        return headOfTheClass;
    }
    public List<Student> getStudents() {
        return students;
    }
}
