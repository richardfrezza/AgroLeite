package com.richard.agroleite.service;

import com.richard.agroleite.model.Vaca;
import com.richard.agroleite.util.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class VacaService extends AbstractCrudService<Vaca> {
    
    @Inject
    private GenericDao<Vaca> dao;

    @Override
    protected GenericDao<Vaca> getDao() {
        return dao;
    }
    
}
