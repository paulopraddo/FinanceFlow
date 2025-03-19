package com.prado.paulo.FinanceFlow.app.category.dtos;

import com.prado.paulo.FinanceFlow.domain.category.model.CategoryType;

public record UploadCategoryRequestDTO(String name, CategoryType type, String username) {

}
