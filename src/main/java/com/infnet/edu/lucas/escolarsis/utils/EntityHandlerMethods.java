package com.infnet.edu.lucas.escolarsis.utils;

import java.util.Collection;

public interface EntityHandlerMethods<EntityDTO> {

    public EntityDTO create(EntityDTO entity);
    public Collection<EntityDTO> getAll();
}
