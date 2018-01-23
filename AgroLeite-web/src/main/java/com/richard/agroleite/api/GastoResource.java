package com.richard.agroleite.api;

import com.richard.agroleite.model.Gasto;
import com.richard.agroleite.service.AbstractCrudService;
import com.richard.agroleite.service.GastoService;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("gastos")
public class GastoResource extends AbstractCrudResource<Gasto> {

    @Inject
    private GastoService service;

    @Override
    protected AbstractCrudService<Gasto> getService() {
        return service;
    }

}
