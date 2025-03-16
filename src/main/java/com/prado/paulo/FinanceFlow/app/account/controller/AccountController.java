package com.prado.paulo.FinanceFlow.app.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prado.paulo.FinanceFlow.app.account.dtos.GetAccountResponseDTO;
import com.prado.paulo.FinanceFlow.app.account.dtos.UpdateAccountRequestDTO;
import com.prado.paulo.FinanceFlow.app.account.dtos.UploadAccountRequestDTO;
import com.prado.paulo.FinanceFlow.app.account.services.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    @Autowired
    private final AccountService accountService;

    //Retornar Http.201
    @GetMapping("/{name}")
    public ResponseEntity<GetAccountResponseDTO> getAccount(@PathVariable String name) {

        GetAccountResponseDTO dto = this.accountService.getAccount(name);
        
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<GetAccountResponseDTO>> getListOfAccounts() {

        List<GetAccountResponseDTO> dtos = this.accountService.getListOfAccounts();

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<UploadAccountRequestDTO> uploadAccount(@RequestBody @Validated UploadAccountRequestDTO dto) {

        this.accountService.uploadAccount(dto);
        
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping
    public ResponseEntity<String> updateAccount(@RequestBody @Validated UpdateAccountRequestDTO dto) {

        this.accountService.updateAccount(dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteAccount(@PathVariable String name) {

        this.accountService.deleteAccount(name);

        return ResponseEntity.noContent().build();
    }
    
}
