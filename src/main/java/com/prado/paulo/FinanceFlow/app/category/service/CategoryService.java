package com.prado.paulo.FinanceFlow.app.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prado.paulo.FinanceFlow.app.category.dtos.UploadCategoryRequestDTO;
import com.prado.paulo.FinanceFlow.domain.auth.model.User;
import com.prado.paulo.FinanceFlow.domain.auth.repository.UserRepository;
import com.prado.paulo.FinanceFlow.domain.category.model.Category;
import com.prado.paulo.FinanceFlow.domain.category.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    public void uploadCategory(UploadCategoryRequestDTO dto) {
        User user = (User) this.userRepository.findByLogin(dto.username());
        Category model = Category.builder()
            .name(dto.name())
            .type(dto.type())
            .user(user)
            .build();

        this.categoryRepository.save(model);
    }
}
