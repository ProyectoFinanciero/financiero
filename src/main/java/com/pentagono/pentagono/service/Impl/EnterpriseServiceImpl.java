package com.pentagono.pentagono.service.Impl;

import com.pentagono.pentagono.model.Employee;
import com.pentagono.pentagono.model.Enterprise;
import com.pentagono.pentagono.repository.IEnterpriseRepository;
import com.pentagono.pentagono.repository.IGenericRepository;
import com.pentagono.pentagono.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterpriseServiceImpl extends CRUDImpl<Enterprise, Long> implements IEnterpriseService {

    @Autowired
    private IEnterpriseRepository iEnterpriseRepository;

    @Autowired
    private IEnterpriseRepository repo;

    public List<Enterprise> getAllEnterprises() {
        return (List<Enterprise>) this.iEnterpriseRepository.findAll();
    }

    @Override
    public void saveEnterprise(Enterprise enterprise) {
    }

    @Override
    public Enterprise getEnterpriseById(long id) {
        return null;
    }

    @Override
    public void deleteEnterpriseById(Long id) {

    }

    @Override
    protected IGenericRepository<Enterprise, Long> getRepo() {
        return null;
    }

    @Override
    public Enterprise createEnterprise(Enterprise enterprise) {
        return this.iEnterpriseRepository.save(enterprise);
    }

}







   /*@Override
    public Enterprise getEnterpriseById(long id) {
        return null;
    }

    @Override
    public void deleteEnterpriseById(Long id) {

    }
}*/
