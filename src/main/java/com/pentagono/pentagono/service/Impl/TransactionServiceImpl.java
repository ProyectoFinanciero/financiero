package com.pentagono.pentagono.service.Impl;

import com.pentagono.pentagono.model.Employee;
import com.pentagono.pentagono.model.Enterprise;
import com.pentagono.pentagono.model.Transaction;
import com.pentagono.pentagono.model.TransactionDetail;
import com.pentagono.pentagono.repository.IGenericRepository;
import com.pentagono.pentagono.repository.ITransactionRepository;
import com.pentagono.pentagono.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl extends CRUDImpl <Transaction, Long> implements ITransactionService {
    @Autowired
    private ITransactionRepository iTransactionRepository;

    public List<Transaction> getAllTransactions() {return (List<Transaction>) this.iTransactionRepository.findAll();}

    public Transaction createTransaction(Transaction transaction) {
        return this.iTransactionRepository.save(transaction);
    }

    @Autowired
    private ITransactionRepository repo;

    @Override
    public void saveTransaction(Transaction transaction) {
    }

    @Override
    public Transaction getTransactionById(long id) {
        return null;
    }

    @Override
    public void deleteTransactionById(Long id) {

    }

    @Override
    protected IGenericRepository<Transaction, Long> getRepo() {
        return null;
    }


}

