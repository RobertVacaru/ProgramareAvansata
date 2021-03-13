package com.lab4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i) )
                .toArray(Student[]::new);
        var schools = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new School(i,"sc" + i) )
                .toArray(School[]::new);

        List<Student> studentList = new LinkedList<>();
        studentList.addAll( Arrays.asList(students) );

        List<School> schoolList = new ArrayList<>();
        schoolList.addAll( Arrays.asList(schools));

        TreeSet<School> schoolListtree= new TreeSet<>();
        schoolListtree.addAll(Arrays.asList(schools));

        List<Student> newSortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        Map<School, List<Student>> schPrefMap = new HashMap<>();

        List<School> stdprefList = new ArrayList<>();
        stdprefList.add(schoolList.get(0));
        stdprefList.add(schoolList.get(1));
        stdprefList.add(schoolList.get(2));
        stdPrefMap.put(students[0], Arrays.asList(schoolList.get(0), schoolList.get(1), schoolList.get(2)));
        stdPrefMap.put(students[1], Arrays.asList(schoolList.get(1), schoolList.get(0), schoolList.get(2)));

        List<School> schprefList = new ArrayList<>();
        schprefList.add(schoolList.get(0));
        schprefList.add(schoolList.get(1));
        schprefList.add(schoolList.get(2));
        schPrefMap.put(schools[0], Arrays.asList(studentList.get(0), studentList.get(1), studentList.get(2)));
        schPrefMap.put(schools[1], Arrays.asList(studentList.get(2), studentList.get(1), studentList.get(0)));

        System.out.println("Students preferences:");
        System.out.println(stdPrefMap);
        System.out.println("Schools preferences:");
        System.out.println(schPrefMap);
        
    }
}
