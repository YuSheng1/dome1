package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Emp {
   private int id;
   private String ename;
   private Dept dept;
   
   @ManyToOne
   @JoinColumn(name="did")
   public Dept getDept() {
	return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
   @Id
   @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
}
