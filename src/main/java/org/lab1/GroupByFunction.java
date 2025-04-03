package org.lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class GroupByFunction implements Function<List<Student>, Map<String, List<Student>>> {
    @Override
    public Map<String, List<Student>> apply(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            if (!groupedStudents.containsKey(student.getGroup())) {
                groupedStudents.put(student.getGroup(), new ArrayList<>());
            }
            groupedStudents.get(student.getGroup()).add(student);
        }
        return groupedStudents;
    }
}

