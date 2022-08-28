package com.tju.manager.entity;

public class Score {
    private String studentid;
    private int courseid;
    private int score;

    public Score() {
    }

    public Score(String studentid, int courseid, int score) {
        this.studentid = studentid;
        this.courseid = courseid;
        this.score = score;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "studentid='" + studentid + '\'' +
                ", courseid=" + courseid +
                ", score=" + score +
                '}';
    }
}
