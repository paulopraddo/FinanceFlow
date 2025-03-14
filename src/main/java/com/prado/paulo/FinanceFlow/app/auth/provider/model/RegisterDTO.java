package com.prado.paulo.FinanceFlow.app.auth.provider.model;

public record RegisterDTO(String login, String email, String password, UserRole role) {

}
