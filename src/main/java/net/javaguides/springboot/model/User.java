package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name = "user_name")
	private String userName;

    @Column(name = "password")
	private String password;

    @Column(name = "user_type")
	private String userType;

	@Column(name = "dpt_name")
	private String dptName;

	@Column(name = "dpt_section")
	private String dptSection;
	





	public User() {

	}

	public User(String userName , String password , String userType , String dptName, String dptSection ) {
		super();
        this.userName = userName;
        this.password = password;
        this.userType = userType;
		this.dptName = dptName;
		this.dptSection = dptSection;
		
	
	


	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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
	

}
