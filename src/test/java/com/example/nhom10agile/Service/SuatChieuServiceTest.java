package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.SuatChieu;
import com.example.nhom10agile.Repository.SuatChieuRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SuatChieuServiceTest {

    private SuatChieuRepo suatChieuRepo;
    private SuatChieuService suatChieuService;

    @BeforeEach
    void setUp() {
        suatChieuRepo = Mockito.mock(SuatChieuRepo.class);
        suatChieuService = new SuatChieuService(suatChieuRepo);
    }

    private SuatChieu sampleSuatChieu() {
        SuatChieu suat = new SuatChieu();
        suat.setId(1L);
        suat.setNgayChieu(LocalDate.of(2025, 4, 20));
        suat.setGioBatDau(LocalTime.of(18, 0));
        suat.setGioKetThuc(LocalTime.of(20, 0));
        suat.setGiaVe(BigDecimal.valueOf(90000));
        return suat;
    }

    @Test
    void getAllSuat() {
        List<SuatChieu> mockList = Arrays.asList(sampleSuatChieu());
        Mockito.when(suatChieuRepo.findAll()).thenReturn(mockList);
        List<SuatChieu> result = suatChieuService.getAllSuat();
        assertEquals(1, result.size());
        assertEquals(LocalTime.of(18, 0), result.get(0).getGioBatDau());
        Mockito.verify(suatChieuRepo, Mockito.times(1)).findAll();
    }

    @Test
    void save() {
        SuatChieu suat = sampleSuatChieu();

        suatChieuService.save(suat);

        ArgumentCaptor<SuatChieu> captor = ArgumentCaptor.forClass(SuatChieu.class);
        Mockito.verify(suatChieuRepo).save(captor.capture());
        assertEquals(suat.getGiaVe(), captor.getValue().getGiaVe());
    }

    @Test
    void getById() {

        SuatChieu suat = sampleSuatChieu();
        Mockito.when(suatChieuRepo.findById(1L)).thenReturn(Optional.of(suat));

        SuatChieu result = (SuatChieu) suatChieuService.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        Mockito.verify(suatChieuRepo).findById(1L);
    }

    @Test
    void deleteById() {
        suatChieuService.deleteById(2L);

        Mockito.verify(suatChieuRepo, Mockito.times(1)).deleteById(2L);
    }

    @Test
    void getById_NotFound_ShouldThrowException() {
        Mockito.when(suatChieuRepo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> suatChieuService.getById(99L));
    }
}