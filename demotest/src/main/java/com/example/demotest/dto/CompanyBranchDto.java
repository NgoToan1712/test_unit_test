package com.example.demotest.dto;

import com.example.demotest.entity.CompanyBranch;
import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component

public class CompanyBranchDto {


    private Integer branchId;

    private String branchName;


    private String location;

    public CompanyBranchDto(String branchName, String location) {
        this.branchName = branchName;
        this.location = location;
    }

    public CompanyBranchDto(Integer branchId) {
        this.branchId = branchId;
    }

    public CompanyBranch toEntity() {
        return CompanyBranch.builder()
                .branchId(this.getBranchId())
                .branchName(this.getBranchName())
                .location(this.location)
                .build();

    }
}
