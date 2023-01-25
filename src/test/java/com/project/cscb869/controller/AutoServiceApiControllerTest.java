package com.project.cscb869.controller;

import com.project.cscb869.controllers.AutoServiceApiController;
import com.project.cscb869.data.entity.AutoService;
import com.project.cscb869.services.AutoServiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class AutoServiceApiControllerTest {
    @Mock
    AutoServiceService autoServiceService;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    AutoServiceApiController autoServiceApiController;

    List<AutoService> autoServiceList;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        autoServiceList = new ArrayList<>();

        AutoService autoService1 = new AutoService();
        autoService1.setId(12);

        AutoService autoService2 = new AutoService();
        autoService1.setId(123);

        autoServiceList.add(autoService1);
        autoServiceList.add(autoService2);

        mockMvc = MockMvcBuilders.standaloneSetup(autoServiceApiController).build();
    }
    @Test
    void getAllAutoServices() throws Exception {
        when(autoServiceService.getServices()).thenReturn(
                Arrays.asList(autoServiceList.get(0), autoServiceList.get(1)));
        mockMvc.perform(get("/api/service/get-all")).andExpect(status().isOk());
        verify(autoServiceService, times(1)).getServices();
    }
    @Test
    void getAutoServiceById() throws Exception {
        when(autoServiceService.getService(autoServiceList.get(0).getId())).thenReturn((autoServiceList.get(0)));

        mockMvc.perform(get("/api/service/" + autoServiceList.get(0).getId())).andExpect(status().isOk());

        verify(autoServiceService, times(1)).getService(autoServiceList.get(0).getId());
    }

}
