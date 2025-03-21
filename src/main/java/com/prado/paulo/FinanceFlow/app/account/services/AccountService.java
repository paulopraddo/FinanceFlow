package com.prado.paulo.FinanceFlow.app.account.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prado.paulo.FinanceFlow.app.account.dtos.GetAccountResponseDTO;
import com.prado.paulo.FinanceFlow.app.account.dtos.UpdateAccountRequestDTO;
import com.prado.paulo.FinanceFlow.app.account.dtos.UploadAccountRequestDTO;
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

    public GetAccountResponseDTO getAccount(String name) {

        Account model = this.accountRepository.findByName(name);

        return new GetAccountResponseDTO(model.getName(), 
            model.getType(), 
            model.getBalance(), 
            model.getUser().getLogin());
    }

    public List<GetAccountResponseDTO> getListOfAccounts() {

        List<Account> accounts = this.accountRepository.findAll();

        return accounts.stream()
            .map(account -> new GetAccountResponseDTO(account.getName(), 
                account.getType(), 
                account.getBalance(), 
                account.getUser().getLogin()))
            .collect(Collectors.toList());
    }

    public Account uploadAccount(UploadAccountRequestDTO dto) {

        User user = (User) this.userRepository.findByLogin(dto.userLogin());

        if (user == null) {
            throw new RuntimeException("User not found with login: " + dto.userLogin());
        }

        boolean accountExists = accountRepository.existsByUserIdAndName(user.getId(), dto.name());

        if(accountExists) {
            throw new RuntimeException("An account with this name already exists for the user.");
        }

        Account model = Account.builder()
        .name(dto.name())
        .type(dto.type())
        .user(user)
        .build();

        return this.accountRepository.save(model);
    }

    public void updateAccount(UpdateAccountRequestDTO dto) {
        Account model = this.accountRepository.findByName(dto.name());

        if (dto.newName() != null) model.setName(dto.newName());
        if (dto.type() != null) model.setType(dto.type());

        this.accountRepository.save(model);
    }

    public void deleteAccount(String name) {
        this.accountRepository.deleteByName(name);
    }

    
}
