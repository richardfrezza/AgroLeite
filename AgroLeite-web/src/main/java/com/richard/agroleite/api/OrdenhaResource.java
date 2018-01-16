package com.richard.agroleite.api;

import com.richard.agroleite.model.Ordenha;
import com.richard.agroleite.service.AbstractCrudService;
import com.richard.agroleite.service.OrdenhaService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("ordenhas")
public class OrdenhaResource extends AbstractCrudResource<Ordenha> {

    @Inject
    private OrdenhaService service;

    @Override
    protected AbstractCrudService<Ordenha> getService() {
        return service;
    }
    
}
