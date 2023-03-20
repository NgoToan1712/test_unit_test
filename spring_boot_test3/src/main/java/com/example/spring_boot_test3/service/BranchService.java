package com.example.spring_boot_test3.service;

import com.example.spring_boot_test3.dto.CompanyBranchDto;
import com.example.spring_boot_test3.mapper.BranchMapper;
import com.example.spring_boot_test3.reponsitory.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private BranchMapper branchMapper;

    public List<CompanyBranchDto> getList(){
        return branchMapper.branchToDtos(branchRepository.findAll());
    }

    public CompanyBranchDto getById(Integer id){
        return branchMapper.companyToCompanyDto(branchRepository.findById(id).get());
    }
}
