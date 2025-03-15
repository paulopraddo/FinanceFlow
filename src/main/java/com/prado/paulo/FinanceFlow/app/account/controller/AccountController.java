package com.prado.paulo.FinanceFlow.app.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prado.paulo.FinanceFlow.app.account.dtos.UploadAccountDTO;
import com.prado.paulo.FinanceFlow.app.account.services.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    @Autowired
    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("Teste de envio de requisição");
    }

    @PostMapping
    public ResponseEntity<UploadAccountDTO> uploadAccount(@RequestBody @Validated UploadAccountDTO dto) {

        this.accountService.uploadAccount(dto);
        
        return ResponseEntity.ok().body(dto);
    }
}
