package com.project.cscb869.services;

import com.project.cscb869.data.entity.AutoService;

import java.util.List;

public interface AutoServiceService {
    List<AutoService> getServices();

    AutoService getService(long id);

    AutoService createService(AutoService autoService);

    AutoService updateService(long id, AutoService autoService);

    void deleteService(long id);

    AutoService getAutoServiceByName(String name);
}
