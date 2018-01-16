package com.richard.agroleite.service;

import com.richard.agroleite.model.Gasto;
import com.richard.agroleite.util.GenericDao;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class GastoService extends AbstractCrudService<Gasto> {
    
    @Inject
    private GenericDao<Gasto> dao;

    @Override
    protected GenericDao<Gasto> getDao() {
        return dao;
    }
    
}
