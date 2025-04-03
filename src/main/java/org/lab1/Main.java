package org.lab1;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Егор", "Группа1"),
                new Student("Дмитрий", "Группа2"),
                new Student("Александр", "Группа1"),
                new Student("Анастасия", "Группа2"),
                new Student("Мария", "Группа3"),
                new Student("Василий", "Группа2"),
                new Student("Антон", "Группа1"),
                new Student("Елена", "Группа2"),
                new Student("Пётр", "Группа3")
        );
        GroupByFunction groupByFunction = new GroupByFunction();
        Map<String, List<Student>> groupedStudents = groupByFunction.apply(students);
        groupedStudents.forEach((group, studentList) ->
                System.out.println(group + ": " + studentList)
        );
    }
}