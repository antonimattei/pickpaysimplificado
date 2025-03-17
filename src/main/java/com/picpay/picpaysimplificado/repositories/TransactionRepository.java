package com.picpay.picpaysimplificado.repositories;

import com.picpay.picpaysimplificado.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
