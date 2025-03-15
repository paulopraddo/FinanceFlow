package com.prado.paulo.FinanceFlow.app.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prado.paulo.FinanceFlow.app.account.dtos.GetAccountResponseDTO;
import com.prado.paulo.FinanceFlow.app.account.dtos.UploadAccountDTO;
import com.prado.paulo.FinanceFlow.domain.account.model.Account;
import com.prado.paulo.FinanceFlow.domain.account.repository.AccountRepository;
import com.prado.paulo.FinanceFlow.domain.auth.model.User;
import com.prado.paulo.FinanceFlow.domain.auth.repository.UserRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    public Account uploadAccount(UploadAccountDTO dto) {

        Account model = Account.builder()
        .name(dto.name())
        .type(dto.type())
        .user((User) this.userRepository.findByLogin(dto.userLogin()))
        .build();


        return this.accountRepository.save(model);
    }

    public GetAccountResponseDTO getAccount(String name) {

        Account model = this.accountRepository.findByName(name);

        return new GetAccountResponseDTO(model.getName(), 
            model.getType(), 
            model.getBalance(), 
            model.getUser().getLogin());
    }
}
