package model;

import java.util.Date;

public class Semester {
	private String sem_id;
	private String name;
	private Date frist;
	
	public Semester(String sem_id,String name, Date frist){
		this.sem_id = sem_id;
		this.name = name;
		this.frist = frist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSem_id() {
		return sem_id;
	}
	public Date getFrist() {
		return frist;
	}
	public void setSem_id(String sem_id) {
		this.sem_id = sem_id;
	}
	public void setFrist(Date frist) {
		this.frist = frist;
	}
	
	
}
