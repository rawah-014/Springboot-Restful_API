package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.repository.DepartmentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DepartmentController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	// get all employees
	@GetMapping("/departments")
	public List<Department> getAllDepartments(){
		return departmentRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/departments")
	public Department createDepartment(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
	
	// get employee by id rest api
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getEmployeeById(@PathVariable Long id) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));
		return ResponseEntity.ok(department);
	}
	
	// update employee rest api
	
	@PutMapping("/departments/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails){
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));
		
		department.setDptName(departmentDetails.getDptName());
		department.setDptSection(departmentDetails.getDptSection());
		department.setNumProcesses(departmentDetails.getNumProcesses());
		





		Department updatedDepartment = departmentRepository.save(department);
		return ResponseEntity.ok(updatedDepartment);
	}
	
	// delete employee rest api
	@DeleteMapping("/departments/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));
		
		departmentRepository.delete(department);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
