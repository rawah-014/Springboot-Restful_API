package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Process;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
}
