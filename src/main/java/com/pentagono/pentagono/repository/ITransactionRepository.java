package com.pentagono.pentagono.repository;

import com.pentagono.pentagono.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends IGenericRepository<Transaction,Long>{

    /*List<Transaction> getAllTransaction(Long idTransaction);*/
}
