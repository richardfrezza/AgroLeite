package com.richard.agroleite.api;

import com.richard.agroleite.model.Vaca;
import com.richard.agroleite.service.AbstractCrudService;
import com.richard.agroleite.service.VacaService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("vacas")
public class VacaResource extends AbstractCrudResource<Vaca> {

    @Inject
    private VacaService service;

    @Override
    protected AbstractCrudService<Vaca> getService() {
        return service;
    }

}
