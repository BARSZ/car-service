package com.project.cscb869.services.implementations;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.repository.AutoServiceRepository;
import com.project.cscb869.services.AutoServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutoServiceImplementation  implements AutoServiceService {

    private AutoServiceRepository autoServiceRepository;

    @Override
    public List<AutoService> getServices() {
        return autoServiceRepository.findAll();
    }

    @Override
    public AutoService getService(long id) {
        return autoServiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid auto service id: " + id));
    }

    @Override
    public AutoService createService(AutoService autoService) {
        return autoServiceRepository.save(autoService);
    }

    @Override
    public AutoService updateService(long id, AutoService autoService) {
        return null;
    }

    @Override
    public AutoService deleteService(long id) {
        return null;
    }
}
