package com.project.cscb869.service;

import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.data.repository.AutoServiceRepository;
import com.project.cscb869.services.implementations.AutoServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AutoServiceServiceTest {
    @Mock
    AutoServiceRepository autoServiceRepository;

    @InjectMocks
    AutoServiceImplementation autoServiceService;

    List<AutoService> autoServiceList;

    @BeforeEach
    void setUp() {
        autoServiceList = new ArrayList<>();

        AutoService autoService1 = new AutoService();
        autoService1.setId(20);

        AutoService autoService2 = new AutoService();
        autoService1.setId(25);

        autoServiceList.add(autoService1);
        autoServiceList.add(autoService2);
    }

    @Test
    void getAllAutoServices() {
        when(autoServiceRepository.findAll()).thenReturn(autoServiceList);

        List<AutoService> result = autoServiceService.getServices();
        assertNotNull(result, "Null returned");
        verify(autoServiceRepository, times(1)).findAll();
    }
    @Test
    void getAutoServiceById() {
        when(autoServiceRepository.findById(any())).thenReturn(Optional.ofNullable(autoServiceList.get(0)));

        AutoService result = autoServiceService.getService(autoServiceList.get(0).getId());
        assertNotNull(result, "Null returned");

        verify(autoServiceRepository, times(1)).findById(any());
    }
}
