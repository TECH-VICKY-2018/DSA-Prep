package utils;

import java.util.*;

class Student {
    String Name;
    int Age;

    public Student(String name, int age) {
        Name = name;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Student : " +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}

class StudentComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {

        int nameCompare = s1.getName().compareTo(s2.getName());
        int ageCompare = s1.getAge() - s2.getAge();

        return (nameCompare == 0) ? ageCompare : nameCompare;

    }
}


public class ComparatorReference {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("vicky", 23));
        students.add(new Student("vicky", 21));
        students.add(new Student("vy", 24));
        students.add(new Student("ba", 30));
        students.add(new Student("sba", 13));
        students.add(new Student("shba", 20));

        students.sort(new StudentComparator());

        System.out.println(students);
    }
}
