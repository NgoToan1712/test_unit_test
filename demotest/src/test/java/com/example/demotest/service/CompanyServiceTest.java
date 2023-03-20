package com.example.demotest.service;

import com.example.demotest.dto.CompanyBranchDto;
import com.example.demotest.entity.CompanyBranch;
import com.example.demotest.repository.CompanyBranchRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {

    @Mock
    CompanyBranchRepository companyBranchRepository;

    @InjectMocks
    CompanyBranchService companyBranchService;

    @Test
    void whenGetAll_shouldReturnList() {
        // 1. create mock data
        List<CompanyBranch> mockCompany = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            mockCompany.add(new CompanyBranch(i, "HN", "Ha noi"));
        }

        // 2. define behavior of Repository
        when(companyBranchRepository.findAll()).thenReturn(mockCompany);

        // 3. call service method
        List<CompanyBranch> actualBooks = companyBranchService.getAll();

        // 4. assert the result
        assertThat(actualBooks.size()).isEqualTo(mockCompany.size());

        // 4.1 ensure repository is called
        verify(companyBranchRepository).findAll();
    }



}
