package com.prado.paulo.FinanceFlow.app.auth.dtos;

import com.prado.paulo.FinanceFlow.domain.auth.model.UserRole;

public record RegisterDTO(String login, String email, String password, UserRole role) {

}
