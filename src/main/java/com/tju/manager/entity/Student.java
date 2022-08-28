package com.tju.manager.entity;

public class Student {
    private String id;
    private String name;
    private String gender;
    private String place;
    private String nation;
    private String birth;

    public Student(String id, String name, String gender, String place, String nation, String birth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.place = place;
        this.nation = nation;
        this.birth = birth;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", place='" + place + '\'' +
                ", nation='" + nation + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
