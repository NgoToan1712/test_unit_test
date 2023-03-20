package com.example.spring_boot_test3.mapper;

import com.example.spring_boot_test3.dto.CompanyBranchDto;
import com.example.spring_boot_test3.entity.CompanyBranch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BranchMapper {
    BranchMapper INSTANCE= Mappers.getMapper(BranchMapper.class);
    CompanyBranchDto companyToCompanyDto(CompanyBranch companyBranch);

    List<CompanyBranchDto> branchToDtos(List<CompanyBranch> companyBranches);
}
