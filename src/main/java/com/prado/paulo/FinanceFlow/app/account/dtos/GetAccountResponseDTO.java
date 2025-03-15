package com.prado.paulo.FinanceFlow.app.account.dtos;

import java.math.BigDecimal;

public record GetAccountResponseDTO(String name, String type, BigDecimal balance, String username) {

}
