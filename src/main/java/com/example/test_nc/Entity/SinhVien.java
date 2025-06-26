package com.example.test_nc.Entity;

public class SinhVien {
    private int id;
    private String name;
    private int age;
    private double mark;

    public SinhVien(int id, String name, int age, double mark) {
        this.id = id;
        setName(name);
        setAge(age);
        setMark(mark);
    }

    public int getId() {
        return  id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        if(name == null || name.isEmpty() || name.trim().equals("")){
            throw  new  IllegalArgumentException(
                    "Name must not be null or empty"
            );
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 18 ){
            throw  new  IllegalArgumentException("Age must be greater than 18");
        }
        this.age = age;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if(mark < 0 || mark > 10 ){
            throw  new  IllegalArgumentException("Mark must be between 0 and 10");
        }
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                '}';
    }
}
