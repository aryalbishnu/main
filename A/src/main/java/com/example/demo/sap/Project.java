package com.example.demo.sap;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
private int pid;
	@Column(name="project_name")
private String projecname;
	@ManyToMany(mappedBy="projects")
	private List<Emp>emps;
	public Project() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Project(int pid, String projecname, List<Emp> emps) {
		super();
		this.pid = pid;
		this.projecname = projecname;
		this.emps = emps;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProjecname() {
		return projecname;
	}
	public void setProjecname(String projecname) {
		this.projecname = projecname;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
	

}
