package com.picpay.picpaysimplificado.services;

import com.picpay.picpaysimplificado.domain.user.User;
import com.picpay.picpaysimplificado.domain.user.UserType;
import com.picpay.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo Lojista não está autorizado a realizar transação");
        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente");
        }

    }

    public User findUserById(Long id) throws Exception {
       return this.repository.findUserById(id).orElseThrow(()-> new Exception("Usuário não encontrado"));
    }
    public void saveUser(User user){
        this.repository.save(user);
    }
}
