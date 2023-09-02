package com.ty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class pan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int pid;
private long panno;
private String state;
private String country;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public long getPanno() {
	return panno;
}
public void setPanno(long panno) {
	this.panno = panno;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
 


}
