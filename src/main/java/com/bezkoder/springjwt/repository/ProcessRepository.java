package com.bezkoder.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Process;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
    Long countByProcessStatus(String processStatus);

    List<Process> findByProcessStatus(String processStatus);

    @Query("SELECT processDpt, COUNT(*) FROM Process WHERE processStatus = 'Approved By IC' GROUP BY processDpt")
    List<Object[]> countApprovedByProcessDpt();

    @Query("SELECT processDpt, COUNT(*) FROM Process WHERE processStatus = 'For Review' GROUP BY processDpt")
    List<Object[]> countReviewByProcessDpt();

    @Query("SELECT processDpt, COUNT(*) FROM Process WHERE processStatus = 'For Update' GROUP BY processDpt")
    List<Object[]> countUpdateByProcessDpt();

    @Query("SELECT processDpt, COUNT(*) FROM Process WHERE processStatus = 'For Update Approve' GROUP BY processDpt")
    List<Object[]> countUpdateApproveByProcessDpt();

    @Query("SELECT processDpt, COUNT(*) FROM Process WHERE processStatus = 'Approved By Strategy' GROUP BY processDpt")
    List<Object[]> countStrategyByProcessDpt();

    @Query("SELECT processDpt, COUNT(*) FROM Process WHERE processStatus = 'Approved By GM' GROUP BY processDpt")
    List<Object[]> countGmByProcessDpt();
}
