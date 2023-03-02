package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Process;
import net.javaguides.springboot.repository.ProcessRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProcessController {

	@Autowired
	private ProcessRepository processRepository;
	
	// get all processes
	@GetMapping("/processes")
	public List<Process> getAllProcesses(){
		return processRepository.findAll();
	}	
    
    // create process rest api
    @PostMapping("/process")
    public Process createProcess(@RequestParam("processName") String processName,
                                   @RequestParam("processDpt") String processDpt,
                                   @RequestParam("processDptSection") String processDptSection,
                                   @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        Process process = new Process(processName, processDpt,processDptSection , image != null ? image.getBytes() : null);
        return processRepository.save(process);
    }

	// get employee by id rest api
	@GetMapping("/process/{id}")
	public ResponseEntity<Process> getProcessById(@PathVariable Long id) {
		Process process = processRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));
		return ResponseEntity.ok(process);
	}

	@PutMapping("process/{id}")
    public Process updateProcess(@PathVariable Long id,
                                   @RequestParam(value = "processName", required = false) String processName,
                                   @RequestParam(value = "processDpt", required = false) String processDpt,
                                   @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        Process process = processRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        if (processName != null) {
            process.setProcessName(processName);
        }
        if (processDpt != null) {
            process.setProcessDpt(processDpt);
        }
        if (image != null) {
            process.setImage(image.getBytes());
        }
        return processRepository.save(process);

	}

	/* @DeleteMapping("process/{id}")
    public ResponseEntity<Void> deleteProcess(@PathVariable Long id) {
        processRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    } */

	// delete employee rest api
	@DeleteMapping("/process/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProcesses(@PathVariable Long id){
		Process process = processRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not exist with id :" + id));
		
		processRepository.delete(process);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	/* @GetMapping("process/{id}")
    public Process getProcessById(@PathVariable Long id) {
        return processRepository.findById(id).
		orElseThrow(() -> new NotFoundException("Employee not found"));
    } */
	
	/* // create employee rest api
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
	} */
	
	
}
