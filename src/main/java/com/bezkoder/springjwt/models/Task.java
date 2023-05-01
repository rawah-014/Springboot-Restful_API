package com.bezkoder.springjwt.models;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "process_tasks")
public class Task {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  @Column(name = "task_name")
  private String taskName;
  
  @Column(name = "task_description", columnDefinition = "TEXT")
  private String taskDescription;
  
  @Column(name = "task_wla", columnDefinition = "TEXT")
  private String taskWla;
  
  @Column(name = "task_owner")
  private String taskOwner;

//  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "process_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Process process;

  public Long getId() {
    return id;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskDescription() {
    return taskDescription;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  public String getTaskWla() {
    return taskWla;
  }

  public void setTaskWla(String taskWla) {
    this.taskWla = taskWla;
  }

  public String getTaskOwner() {
    return taskOwner;
  }

  public void setTaskOwner(String taskOwner) {
    this.taskOwner = taskOwner;
  }

  public Process getProcess() {
    return process;
  }

  public void setProcess(Process process) {
    this.process = process;
  }

}






















/* package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;





@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "task_name")
    private String taskName;
    
    @Column(name = "task_description", columnDefinition = "TEXT")
    private String taskDescription;
    
    @Column(name = "task_wla", columnDefinition = "TEXT")
    private String taskWla;
    
    @Column(name = "task_owner")
    private String taskOwner;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_id")
    private Process process;
    
    

    public Task() {

	}

	public Task(String taskOwner, String taskName, String taskDescription , String taskWla) {
		super();
		this.taskName = taskName;
		this.taskOwner = taskOwner;
		this.taskDescription = taskDescription;
        this.taskWla = taskWla;
	


	}

	
}
 */