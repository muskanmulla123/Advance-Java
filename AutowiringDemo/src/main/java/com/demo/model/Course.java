package com.demo.model;

public class Course {
	private int cid;
	private String cname;
	private int duration;
	private Faculty faculty;
	public Course() {
		super();
	}
	public Course(int cid, String cname, int duration, Faculty f) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.duration = duration;
		this.faculty = f;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty f) {
		this.faculty = f;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", duration=" + duration + ", faculty=" + faculty + "]";
	}
	

}
