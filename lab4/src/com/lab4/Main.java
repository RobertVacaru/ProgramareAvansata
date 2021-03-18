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
                .mapToObj(i -> new School("sc" + i) )
                .toArray(School[]::new);
        schools[0].setCapacity(1);
        schools[1].setCapacity(2);
        schools[2].setCapacity(2);
        //List<Student> studentList = new LinkedList<>();
        //studentList.addAll( Arrays.asList(students) );
        Problem problem=new Problem();
        problem.addStudents(students);
        problem.addSchools(schools);
        problem.compareStudents();
        int v[]= new int[]{0, 1, 2};
        problem.addstudentPref(v,0,students,3);
        problem.addstudentPref(v,1,students,3);
        problem.addstudentPref(v,2,students,2);
        v[1]=2;
        problem.addstudentPref(v,3,students,2);
        int p[]=new int[]{3,0,1,2};
        problem.addschoolPref(p,0,schools,4);
        p[0]=0;p[1]=2;p[2]=1;
        problem.addschoolPref(p,1,schools,3);
        p[1]=1;p[2]=3;
        problem.addschoolPref(p,2,schools,3);
        problem.printProblem();
        problem.studentQueries(v,2,schools);
        /*problem.schoolList.stream()
                .filter(std -> problem.schPrefMap.get(std).get(0).equals(students[0]))
                .forEach(System.out::println);*/
        problem.schoolQueries(students,1);
       /* List<School> stdprefList = new ArrayList<>();
        stdprefList.add(problem.schoolList.get(0));
        stdprefList.add(problem.schoolList.get(1));
        stdprefList.add(problem.schoolList.get(2));
        problem.addstudentPref(stdprefList,0,students);
        problem.addstudentPref(stdprefList,1,students);
        stdprefList.clear();
        stdprefList.add(problem.schoolList.get(0));
        stdprefList.add(problem.schoolList.get(1));
        problem.addstudentPref(stdprefList,2,students);
        stdprefList.clear();
        stdprefList.add(problem.schoolList.get(0));
        stdprefList.add(problem.schoolList.get(2));
        problem.addstudentPref(stdprefList,3,students);

        List<Student> schprefList = new ArrayList<>();
        schprefList.add(problem.studentList.get(3));
        schprefList.add(problem.studentList.get(0));
        schprefList.add(problem.studentList.get(1));
        schprefList.add(problem.studentList.get(2));
        problem.addschooltPref(schprefList,0,schools);
        schprefList.clear();
        schprefList.add(problem.studentList.get(0));
        schprefList.add(problem.studentList.get(2));
        schprefList.add(problem.studentList.get(1));
        problem.addschooltPref(schprefList,1,schools);
        schprefList.clear();
        schprefList.add(problem.studentList.get(0));
        schprefList.add(problem.studentList.get(1));
        schprefList.add(problem.studentList.get(3));
        problem.addschooltPref(schprefList,2,schools);
        problem.printProblem();*/
       /* List<School> schoolList = new ArrayList<>();
        schoolList.addAll( Arrays.asList(schools));

       TreeSet<School> schoolListtree= new TreeSet<>();
        schoolListtree.addAll(Arrays.asList(schools));

        List<Student> newSortedList = studentList.stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        studentList.addAll(newSortedList);

        Map<Student, List<School>> stdPrefMap = new HashMap<>();
        Map<School, List<Student>> schPrefMap = new HashMap<>();

        List<School> stdprefList = new ArrayList<>();
        stdprefList.add(schoolList.get(0));
        stdprefList.add(schoolList.get(1));
        stdprefList.add(schoolList.get(2));
        stdprefList.add(schoolList.get(3));
        stdPrefMap.put(students[0], Arrays.asList(schoolList.get(0), schoolList.get(1), schoolList.get(2)));
        stdPrefMap.put(students[1], Arrays.asList(schoolList.get(0), schoolList.get(1), schoolList.get(2)));
        stdPrefMap.put(students[2], Arrays.asList(schoolList.get(0), schoolList.get(1)));
        stdPrefMap.put(students[3], Arrays.asList(schoolList.get(0), schoolList.get(2)));


        schPrefMap.put(schools[0], Arrays.asList(studentList.get(3), studentList.get(0), studentList.get(1),studentList.get(2)));
        schPrefMap.put(schools[1], Arrays.asList(studentList.get(0), studentList.get(2), studentList.get(1)));
        schPrefMap.put(schools[2], Arrays.asList(studentList.get(0), studentList.get(1), studentList.get(3)));

        System.out.println("Students preferences:");
        System.out.println(stdPrefMap);
        System.out.println("Schools preferences:");
        System.out.println(schPrefMap);*/

    }
}
