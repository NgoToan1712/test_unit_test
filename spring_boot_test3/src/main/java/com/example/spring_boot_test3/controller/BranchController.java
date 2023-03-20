package com.example.spring_boot_test3.controller;

import com.example.spring_boot_test3.dto.CompanyBranchDto;
import com.example.spring_boot_test3.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping("/branch")
    public ResponseEntity<List<CompanyBranchDto>> getAll(){
        return new ResponseEntity<>(branchService.getList(), HttpStatus.OK);
    }

    @GetMapping("/branch/{id}")
    public ResponseEntity<CompanyBranchDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(branchService.getById(id), HttpStatus.OK);
    }
}
