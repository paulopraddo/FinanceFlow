package com.prado.paulo.FinanceFlow.app.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prado.paulo.FinanceFlow.app.category.dtos.UploadCategoryRequestDTO;
import com.prado.paulo.FinanceFlow.app.category.service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<String> uploadCategory(@RequestBody UploadCategoryRequestDTO dto) {

        this.categoryService.uploadCategory(dto);

        return ResponseEntity.ok().build();
    }
}
