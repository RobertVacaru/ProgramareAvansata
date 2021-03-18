package com.lab4;
import java.util.Map;
import java.util.HashMap;
import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
public class Problem {
    public List<Student> studentList;
    public List<School> schoolList;
    Map<Student, List<School>> stdPrefMap;
    Map<School, List<Student>> schPrefMap;

    public Problem() {
        studentList = new LinkedList<>();
        schoolList = new LinkedList<>();
        stdPrefMap = new HashMap<>();
        schPrefMap = new HashMap<>();
    }

    public Problem(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudents(Student[] students) {
        studentList.addAll(Arrays.asList(students));
    }

    public void addSchools(School[] schools) {
        schoolList.addAll(Arrays.asList(schools));
    }

    public void compareStudents() {
        List<Student> newSortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        studentList.addAll(newSortedList);
    }

    public void addstudentPref(int v[], int n, Student[] students, int m) {
        List<School> stdprefList = new ArrayList<>();
        for (int i = 0; i < m; i++)
            stdprefList.add(schoolList.get(v[i]));
        stdPrefMap.put(students[n], stdprefList);
    }

    public void addschoolPref(int v[], int n, School[] schools, int m) {
        List<Student> schprefList = new ArrayList<>();
        for (int i = 0; i < m; i++)
            schprefList.add(studentList.get(v[i]));
        schPrefMap.put(schools[n], schprefList);
    }

    public void studentQueries(int v[], int m,School[] school) {
        List<School> target = new ArrayList<>();
        System.out.println("\nStudents that prefer  this schools:");
        for (int i = 0; i < m; i++) {
            target.add(schoolList.get(v[i]));
            System.out.println(schoolList.get(v[i]));
        }
        System.out.println("Are this ones:");
        List<Student> result = studentList.stream()
                .distinct()
                .filter(std -> stdPrefMap.get(std).containsAll(target))
                .collect(Collectors.toList());
        System.out.println(result);
        studentList.stream()
                .filter(std -> stdPrefMap.get(std).contains(school[0]))
                .forEach(System.out::println);
    }

    public void schoolQueries(Student[] student,int n) {
       schoolList.stream()
                .filter(std -> schPrefMap.get(std).get(0).equals(student[0]))
                .forEach(System.out::println);
       // System.out.println(result);
    }

    public void printProblem() {
        System.out.println("Students preferences:");
        System.out.println(stdPrefMap);
        System.out.println("\nSchools preferences:");
        System.out.println(schPrefMap);
    }


}
