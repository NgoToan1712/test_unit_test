package com.example.demotest.service;

import com.example.demotest.dto.CompanyBranchDto;
import com.example.demotest.entity.CompanyBranch;
import com.example.demotest.repository.CompanyBranchRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyTest {

    @Mock
    CompanyBranchRepository branchRepository;

    @InjectMocks
    CompanyBranchService branchService;

    public static final Logger logger = LoggerFactory.getLogger(CompanyTest.class);
    List<CompanyBranch> companyBranches = new ArrayList<>();

    @BeforeEach
    public void init() {
        logger.info("startup");
        companyBranches.add(new CompanyBranch(1, "HN1", "Ha Noi"));
        companyBranches.add(new CompanyBranch(2, "DN", "Da Nang"));
        companyBranches.add(new CompanyBranch(3, "SG", "Sai Gon"));
        companyBranches.add(new CompanyBranch(4, "VINH", "Vinh"));
        companyBranches.add(new CompanyBranch(5, "QN", "Quang Ninh"));

    }

    @AfterEach
    public void teardown() {
        logger.info("teardown");
        companyBranches.clear();
    }

    @Test
    public void getListAll() {
       //CompanyBranchRepository branchRepository=Mockito.mock(CompanyBranchRepository.class)
        when(branchRepository.findAll()).thenReturn(companyBranches);
        List<CompanyBranch> actualCompany = branchService.getAll();
        assertThat(actualCompany.size()).isEqualTo(companyBranches.size());
        verify(branchRepository).findAll();
    }

    @Test
    public void getBranchByName() {
        CompanyBranch companyBranch = new CompanyBranch(6, "ND", "Nam Dinh");
        when(branchRepository.findByranchName(anyString())).thenReturn(companyBranch);
        CompanyBranchDto companyBranchDto = branchService.getBranchByName("ND");
        assertNotNull(companyBranchDto);
        assertEquals("ND", companyBranchDto.getBranchName());
    }

    @Test
    public void getBranchById() {
        CompanyBranch companyBranch = new CompanyBranch(6, "ND", "Nam Dinh");
        when(branchRepository.findCompanyBranchBy(anyInt())).thenReturn(companyBranch);
        CompanyBranchDto companyBranchDto = branchService.getBranchById(6);
        assertNotNull(companyBranchDto);
        assertEquals("ND", companyBranchDto.getBranchName());
    }

//    @Test
//    public void updateBranch() {
//        CompanyBranch companyBranch = new CompanyBranch("ND", "Nam Dinh");
//        branchRepository.save(companyBranch);
////        CompanyBranchDto companyBranchDto= branchService.getBranchById(6);
////        assertNotNull(companyBranchDto);
//        assertThat(companyBranch.getBranchId()).isGreaterThan(0);
//    }

}
