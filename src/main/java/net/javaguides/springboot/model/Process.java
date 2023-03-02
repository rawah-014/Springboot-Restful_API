package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "process")
public class Process {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "process_name")
	private String processName;

	@Column(name = "process_dpt_section")
	private String processDptSection;
	
	@Column(name = "process_dpt")
	private String processDpt;
	
    @Lob
    @Column(name = "process_chart_file")
    private byte[] image;




	public Process() {

	}

	public Process(String processName, String processDptSection, String processDpt , byte[] image) {
		super();
		this.processName = processName;
		this.processDptSection = processDptSection;
		this.processDpt = processDpt;
        this.image = image;
	


	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessDptSection() {
		return processDptSection;
	}

	public void setProcessDptSection(String processDptSection) {
		this.processDptSection = processDptSection;
	}
	
	public String getProcessDpt() {
		return processDpt;
	}

	public void setProcessDpt(String processDpt) {
		this.processDpt = processDpt;
	}

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }



	}

