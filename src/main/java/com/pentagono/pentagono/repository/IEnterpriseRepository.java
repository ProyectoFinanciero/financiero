package com.pentagono.pentagono.repository;

import com.pentagono.pentagono.model.Employee;
import com.pentagono.pentagono.model.Enterprise;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEnterpriseRepository extends IGenericRepository<Enterprise, Long>{

    /*List<Enterprise> findByNameLike(String name);
    List<Enterprise> findByName(String name);
    List<Enterprise> getAllEnterprise(Long idEnterprise);*/

}
