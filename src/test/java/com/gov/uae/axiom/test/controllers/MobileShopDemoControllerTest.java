package com.gov.uae.axiom.test.controllers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gov.uae.axiom.controller.MobileController;
import com.gov.uae.axiom.domain.Mobiles;
import com.gov.uae.axiom.service.MobileService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class MobileShopDemoControllerTest {
	
    @InjectMocks
    private MobileController mobileController;

    @Mock
    private MobileService mobileService;

    private MockMvc mvc;
    
    Iterable<Mobiles> mockMobile = new ArrayList<Mobiles>();
    Mobiles mobileObj;
    @Before
    public void setup(){
        mvc = MockMvcBuilders.standaloneSetup(mobileController).build();
        List<Mobiles> mobiles= new  ArrayList<Mobiles>();
    	ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Mobiles>> typeReference = new TypeReference<List<Mobiles>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/mobiles.json");
		try {
			mobiles = mapper.readValue(inputStream, typeReference);
			mobileService.save(mobiles);
		} catch (IOException e) {
			System.out.println("Unable to get mobiles: " + e.getMessage());
		}
    }
    
    @Test
    public void shouldReturnMobilesList() throws Exception {
        when(mobileController.list()).thenReturn(mockMobile);
        mvc.perform(MockMvcRequestBuilders.get("/mobiles/list")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
    
    @Test
    public void shouldReturnMobileObjectById() throws Exception {
        when(mobileService.searchByoneOrMoreCreiteria(
        		22895L,null,null,null,null,null
        		,null,null,null,null,null))
                .thenReturn(Arrays.asList(mobileObj));
        mvc.perform(MockMvcRequestBuilders .get("/mobiles/search?id=22895")).andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnMobileObjectBySimType() throws Exception {
    	 when(mobileService.searchByoneOrMoreCreiteria(
         		null,null,null,null, "eSIM",null
         		,null,null,null,null,null))
                 .thenReturn(Arrays.asList(mobileObj));
        mvc.perform(MockMvcRequestBuilders .get("/mobiles/search?sim=eSIM")).andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnMobileObjectByphone() throws Exception {
    	 when(mobileService.searchByoneOrMoreCreiteria(
         		null,null, "Apple",null,null,null
         		,null,null,null,null,null))
                 .thenReturn(Arrays.asList(mobileObj));
        mvc.perform(MockMvcRequestBuilders .get("/mobiles/search?phone=Apple")).andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnMobileObjectByPicture() throws Exception {
    	 when(mobileService.searchByoneOrMoreCreiteria(
         		null,null,null, "gsmarena",null,null
         		,null,null,null,null,null))
                 .thenReturn(Arrays.asList(mobileObj));
        mvc.perform(MockMvcRequestBuilders .get("/mobiles/search?picture=gsmarena")).andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnMobileObjectByPriceEur() throws Exception {
    	 when(mobileService.searchByoneOrMoreCreiteria(
         		null,null,null,null,null,null
         		,null, "770",null,null,null))
                 .thenReturn(Arrays.asList(mobileObj));
        mvc.perform(MockMvcRequestBuilders .get("/mobiles/search?priceEur=770")).andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnMobileObjectByBattery() throws Exception {
    	 when(mobileService.searchByoneOrMoreCreiteria(
         		null,null,null,null,null,null
         		,null,null,null,null, "Li-Ion 2691 mAh battery (10.28 Wh)"))
                 .thenReturn(Arrays.asList(mobileObj));
        mvc.perform(MockMvcRequestBuilders .get("/mobiles/search?battery=Li-Ion 2691 mAh battery (10.28 Wh)")).andExpect(status().isOk());
    }
    
    @Test
    public void shouldReturnMobileObjectByAnnounceDate() throws Exception {
    	 when(mobileService.searchByoneOrMoreCreiteria(
         		null,null,null,null,null,null
         		, "2017",null,null,null,null))
                 .thenReturn(Arrays.asList(mobileObj));
        mvc.perform(MockMvcRequestBuilders .get("/mobiles/search?announceDate=2017")).andExpect(status().isOk());
    }
}

