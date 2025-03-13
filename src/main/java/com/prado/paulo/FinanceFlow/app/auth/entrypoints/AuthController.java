package com.prado.paulo.FinanceFlow.app.auth.entrypoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prado.paulo.FinanceFlow.app.auth.provider.model.AuthenticationDTO;
import com.prado.paulo.FinanceFlow.app.auth.provider.model.RegisterDTO;
import com.prado.paulo.FinanceFlow.app.auth.provider.model.User;
import com.prado.paulo.FinanceFlow.app.auth.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationMenager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
        var auth = this.authenticationMenager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO registerDTO) {
        if(this.userRepository.findByLogin(registerDTO.login()) != null) return ResponseEntity.badRequest().build();
        
        String ecnryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User(registerDTO.login(), ecnryptedPassword, registerDTO.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().body(newUser);
    }
}
