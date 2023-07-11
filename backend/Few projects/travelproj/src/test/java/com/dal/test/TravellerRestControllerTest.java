package com.dal.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.dal.entity.Traveller;
import com.dal.repository.TravellerRepository;
import com.dal.service.TravellerService;

@SpringBootTest
public class TravellerRestControllerTest {

    @Mock
    private TravellerRepository travellerRepository;

    @Mock
    private TravellerService travellerService;

    @InjectMocks
    private TravellerRestControllerTest travellerRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
/*
    @Test
    public void testHelloAppln() {
        String result = travellerRestController.hello();
        assertEquals("Hello Welcome Traveller", result);
    }

   

    @Test
    public void testListAllTravellers() {
        Traveller traveller1 = new Traveller();
        traveller1.setTravellerId(1L);
        traveller1.setTravellerName("Arun");
        Traveller traveller2 = new Traveller();
        traveller2.setTravellerId(4L);
        traveller2.setTravellerName("Bala");
        List<Traveller> travellers = Arrays.asList(traveller1, traveller2);
        when(travellerService.listAllTravellers()).thenReturn(travellers);

        List<Traveller> result = travellerRestController.listAllTravellers();
        assertEquals(travellers, result);
    }

    @Test
    public void testSearchByTravellerId() {
        Long tid = 1L;
        Traveller traveller = new Traveller();
        traveller.setTravellerId(tid);
        traveller.setTravellerName("Arun");
        when(travellerService.searchByTravellerId(tid)).thenReturn(Optional.of(traveller));

        Optional<Traveller> result = travellerRestController.searchByTravellerId(tid);
        assertEquals(traveller, result.get());
    }

    @Test
    public void testSearchByTravellerName() {
        String tname = "Test User";
        Traveller traveller = new Traveller();
        traveller.setTravellerId(1L);
        traveller.setTravellerName(tname);
        when(travellerService.searchByTravellerName(tname)).thenReturn(traveller);

        Traveller result = travellerRestController.searchByTravellerId(tname);
        assertEquals(traveller, result);
    }
*/
}