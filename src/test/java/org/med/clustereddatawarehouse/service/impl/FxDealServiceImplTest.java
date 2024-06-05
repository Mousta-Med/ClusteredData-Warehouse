package org.med.clustereddatawarehouse.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.med.clustereddatawarehouse.exception.ResourceAlreadyExistException;
import org.med.clustereddatawarehouse.model.entity.FxDeal;
import org.med.clustereddatawarehouse.model.request.FxDealReqDto;
import org.med.clustereddatawarehouse.repository.FxDealRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FxDealServiceImplTest {

    @Mock
    private FxDealRepository fxDealRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private FxDealServiceImpl fxDealService;

    private FxDealReqDto fxDealReqDto;
    private FxDeal fxDeal;

    @BeforeEach
    void setUp() {
        fxDealReqDto = new FxDealReqDto();
        fxDealReqDto.setId("ID123");
        fxDealReqDto.setOrderingCurrencyIsoCode("USD");
        fxDealReqDto.setToCurrencyIsoCode("EUR");
        fxDealReqDto.setDealAmount(1000.0);

        fxDeal = new FxDeal();
        fxDeal.setId("ID123");
        fxDeal.setOrderingCurrencyIsoCode("USD");
        fxDeal.setToCurrencyIsoCode("EUR");
        fxDeal.setDealTimestamp(LocalDateTime.parse("2024-01-01T12:00:00"));
        fxDeal.setDealAmount(1000.0);
    }

    @Test
    void testSaveNewDealSuccessfully() {
        when(fxDealRepository.existsById(fxDealReqDto.getId())).thenReturn(false);
        when(modelMapper.map(fxDealReqDto, FxDeal.class)).thenReturn(fxDeal);
        when(fxDealRepository.save(any(FxDeal.class))).thenReturn(fxDeal);
        when(modelMapper.map(fxDeal, FxDealReqDto.class)).thenReturn(fxDealReqDto);
        FxDealReqDto savedDeal = fxDealService.save(fxDealReqDto);
        assertNotNull(savedDeal);
        assertEquals(fxDealReqDto.getId(), savedDeal.getId());
        verify(fxDealRepository, times(1)).save(any(FxDeal.class));
    }

    @Test
    void testSaveDuplicateDealThrowsException() {
        when(fxDealRepository.existsById(fxDealReqDto.getId())).thenReturn(true);
        ResourceAlreadyExistException exception = assertThrows(ResourceAlreadyExistException.class, () -> {
            fxDealService.save(fxDealReqDto);
        });
        assertEquals("Deal Already Exist with this id: ID123", exception.getMessage());
        verify(fxDealRepository, never()).save(any(FxDeal.class));
    }
}