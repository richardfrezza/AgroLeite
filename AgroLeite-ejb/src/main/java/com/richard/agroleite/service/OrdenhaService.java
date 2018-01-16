package com.richard.agroleite.service;

import com.richard.agroleite.model.Ordenha;
import com.richard.agroleite.util.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class OrdenhaService extends AbstractCrudService<Ordenha> {

    @Inject
    private GenericDao<Ordenha> dao;
    
    @Override
    protected GenericDao<Ordenha> getDao() {
        return dao;
    }
    
}
