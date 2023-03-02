package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "dpt_name")
	private String dptName;

	@Column(name = "dpt_section")
	private String dptSection;
	
	@Column(name = "num_processes")
	private int numProcesses;
	




	public Department() {

	}

	public Department(String dptName, String dptSection, int numProcesses ) {
		super();
		this.dptName = dptName;
		this.dptSection = dptSection;
		this.numProcesses = numProcesses;
	
	


	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public String getDptSection() {
		return dptSection;
	}

	public void setDptSection(String dptSection) {
		this.dptSection = dptSection;
	}
	
	public int getNumProcesses() {
		return numProcesses;
	}

	public void setNumProcesses(int numProcesses) {
		this.numProcesses = numProcesses;
	}





	}

