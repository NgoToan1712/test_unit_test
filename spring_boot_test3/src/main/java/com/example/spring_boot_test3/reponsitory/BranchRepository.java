package com.example.spring_boot_test3.reponsitory;

import com.example.spring_boot_test3.entity.CompanyBranch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<CompanyBranch, Integer> {
}
