package com.bezkoder.springjwt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bezkoder.springjwt.models.DepartmentCount;

import com.bezkoder.springjwt.repository.ProcessRepository;
import com.bezkoder.springjwt.services.CountApprovedService;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ReportController {

	@Autowired
	private ProcessRepository processRepository;

	@Autowired
	private CountApprovedService countApprovedService;

	/**********************
	 * Reports
	 ************************************************/

	/************************** Counting Reports */
	// Report for count st approved status
	@GetMapping("process/count-all-st-approved")
	public Long getApprovedCount() {
		return processRepository.countByProcessStatus("Approved By Strategy");
	}

	// Report for count gm approved status
	@GetMapping("process/count-all-gm-approved")
	public Long getGmApprovedCount() {
		return processRepository.countByProcessStatus("Approved By GM");
	}

	// Report for count gm approved status
	@GetMapping("process/count-all-ic-approved")
	public Long getIcApprovedCount() {
		return processRepository.countByProcessStatus("Approved By IC");
	}

		// Report for count  st approved status
		@GetMapping("process/count-all-update-approved")
		public Long getUpdateApprovedCount() {
			return processRepository.countByProcessStatus("For Update Approve");
		}

		// Report for count  st approved status
		@GetMapping("process/count-all-update")
		public Long getUpdateCount() {
			return processRepository.countByProcessStatus("For Update");
		}

		// Report for count  st approved status
		@GetMapping("process/count-all-review")
		public Long getReviewCount() {
			return processRepository.countByProcessStatus("For Review");
		}

	/************************** Counting Reports */

	// 1 Report for count IC approved
	@GetMapping("/approved/ic")
	public List<DepartmentCount> countApprovedByDepartment() {
		return countApprovedService.countApprovedByDepartment();
	}

	// 2 Report for count or Reviewed
	@GetMapping("/approved/review")
	public List<DepartmentCount> countReviewByDepartment() {
		return countApprovedService.countReviewByDepartment();
	}

	// 3 Report for GM Approve
	@GetMapping("/approved/st")
	public List<DepartmentCount> countStApproveByDepartment() {
		return countApprovedService.countStrategyByProcessDpt();
	}

	// 4 Report for count ST Approve
	@GetMapping("/approved/gm")
	public List<DepartmentCount> countGmApproveByDepartment() {
		return countApprovedService.countGmByProcessDpt();
	}

	// 5 Report for Update Approve countForUpdateByDepartment
	@GetMapping("/approved/updateApprove")
	public List<DepartmentCount> countUpdateApproveByDepartment() {
		return countApprovedService.countUpdateApprovedByDepartment();
	}

	// 6 Report for Update Approve countForUpdateByDepartment
	@GetMapping("/approved/update")
	public List<DepartmentCount> countUpdateByDepartment() {
		return countApprovedService.countForUpdateByDepartment();
	}

}
