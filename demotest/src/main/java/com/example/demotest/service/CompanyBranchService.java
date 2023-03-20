package com.example.demotest.service;

import com.example.demotest.dto.CompanyBranchDto;
import com.example.demotest.entity.CompanyBranch;
import com.example.demotest.repository.CompanyBranchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyBranchService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CompanyBranchRepository companyRepository;

    public List<CompanyBranch> getAll() {
        return companyRepository.findAll();
    }

    public List<CompanyBranchDto> getBranchAll() {
        return companyRepository.getList().stream().map(CompanyBranch::toDto).collect(Collectors.toList());
    }

    public CompanyBranchDto getBranchById(Integer id) {
        CompanyBranch companyBranch = companyRepository.findCompanyBranchBy(id);
        CompanyBranchDto companyBranchDto = companyBranch.toDto();
        return companyBranchDto;
    }

    public CompanyBranchDto getBranchByName(String name) {
        CompanyBranch companyBranch = companyRepository.findByranchName(name);
        CompanyBranchDto companyBranchDto = companyBranch.toDto();
        return companyBranchDto;
    }
    public CompanyBranchDto saveBranch(CompanyBranchDto companyBranchDto) {
        CompanyBranch companyBranch1 = companyRepository.findByranchName(companyBranchDto.getBranchName());
        if (companyBranch1 != null) {
            logger.error("Company branch already exists");
        } else {
            CompanyBranch companyBranch = companyBranchDto.toEntity();
            try {
                companyRepository.save(companyBranch);
                return companyRepository.findByranchName(companyBranchDto.getBranchName()).toDto();
            } catch (DataAccessException e) {
                logger.error("Unable to create company branch");
            }
        }
        return null;
    }

    public CompanyBranchDto updateCompanyBranch(Integer id, CompanyBranchDto companyBranchDto) {
        try {
            CompanyBranch companyBranch = companyRepository.findById(id).get();
            try {
                CompanyBranch companyBranch1 = companyBranchDto.toEntity();
                companyRepository.save(companyBranch1);
                return companyRepository.findCompanyBranchBy(id).toDto();
            } catch (DataAccessException e) {
                logger.error("Unable to update company branch");
            }
        } catch (Exception e) {
            logger.error("Company branch with id {} does not exist!", id);
        }
        return null;

    }

    public void deleteBranch(Integer id) {
        try {
            companyRepository.deleteById(id);
        } catch (DataAccessException e) {
            logger.error("Unable to delete company branch");
        }
    }
}

