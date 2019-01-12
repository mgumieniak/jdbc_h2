package com.jdbc.h2.jdbc_h2.student;

public class Student {

    private  Long id;
    private  String name;
    private  String department;

    public Student() {

    }

    public Student(Long id, String name, String departmentName) {
        this.id = id;
        this.name = name;
        this.department = departmentName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", department='" + this.getDepartment() + '\'' +
                '}';
    }
}
