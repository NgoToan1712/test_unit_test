package com.example.demotest.entity;

import com.example.demotest.dto.CompanyBranchDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company_branch")
@Builder

public class CompanyBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "location")
    private String location;

    public CompanyBranch(String branchName, String location) {
        this.branchName = branchName;
        this.location = location;
    }

    public CompanyBranchDto toDto() {
        return CompanyBranchDto.builder()
                .branchId(this.getBranchId())
                .branchName(this.getBranchName())
                .location(this.location)
                .build();

    }
}