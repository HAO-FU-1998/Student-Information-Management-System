package com.tju.manager.entity;

public class Connect {

    private String id;
    private String name;
    private int courseid;
    private String coursename;
    private int score;
    private int credit;

    public Connect(String id, String name, String coursename, int courseid, int score, int credit) {
        this.id = id;
        this.name = name;
        this.courseid = courseid ;
        this.coursename = coursename;
        this.score = score;
        this.credit = credit;
    }

    public Connect() {
    }

    @Override
    public String toString() {
        return "Connect{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", courseid='" + courseid + '\'' +
                ", coursename='" + coursename + '\'' +
                ", score=" + score +
                ", credit=" + credit +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCourseid() {
        return courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public int getScore() {
        return score;
    }

    public int getCredit() {
        return credit;
    }
}
