package com.staticdemo;

public class StaticDemo {
    // Static variables
    public static String schoolName = "Java Academy";
    public static int totalStudents = 500;

    // Non-static variables
    public String studentName;
    public int studentId;

    public StaticDemo(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    // Static method
    public static void displaySchoolInfo() {
        System.out.println("School: " + schoolName);
        System.out.println("Total students: " + totalStudents);

        // Cannot access non-static members directly from static method
        // System.out.println("Student: " + studentName); // compile error
        // displayStudentInfo(); // compile error
    }

    // Non-static method
    public void displayStudentInfo() {
        System.out.println("Student: " + studentName + " (ID: " + studentId + ")");
        System.out.println("School: " + schoolName); // static accessed from non-static
        displaySchoolInfo(); // static method called from non-static method
    }

    public static void main(String[] args) {
        System.out.println("=== Static access from static method ===");
        displaySchoolInfo();

        System.out.println("\n=== Non-static access from static method (requires object) ===");
        StaticDemo student = new StaticDemo("Alice", 101);
        student.displayStudentInfo();

        System.out.println("\n=== Static access from non-static method ===");
        student.displayStudentInfo();

        System.out.println("\n=== Non-static access from non-static method ===");
        student.displayStudentInfo();
    }
}


/*
C:\MCL\Java\java_practice\static_demo\src>javac com\staticdemo\StaticDemo.java

C:\MCL\Java\java_practice\static_demo\src>java com.staticdemo.StaticDemo */