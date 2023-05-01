package com.bezkoder.springjwt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByProcessId(Long ProcessId);
  
  @Transactional
  void deleteByProcessId(long ProcessId);
}





/* package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Task;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
    List<Task> findByProcessId(Long processId);
}
 */