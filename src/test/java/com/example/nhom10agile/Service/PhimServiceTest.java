package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.Phim;
import com.example.nhom10agile.Repository.PhimRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class PhimServiceTest {

    private PhimRepo phimRepo;
    private PhimService phimService;

    @BeforeEach
    void setUp() {
        phimRepo = mock(PhimRepo.class);
        phimService = new PhimService(phimRepo);
    }

    @Test
    void getAllPhim() {
        // Given
        List<Phim> mockPhims = Arrays.asList(
                new Phim(1L, "Phim 1", "Hành động", "Nguyen Van A", "Tran B, Le C", 120,
                        "Mô tả phim 1", new Date(), new Date(), "Đang chiếu"),
                new Phim(2L, "Phim 2", "Hài", "Nguyen Van B", "Nguyen D", 90,
                        "Mô tả phim 2", new Date(), new Date(), "Sắp chiếu")
        );
        when(phimRepo.findAll()).thenReturn(mockPhims);

        // When
        List<Phim> result = phimService.getAllPhim();

        // Then
        assertEquals(2, result.size());
        assertEquals("Phim 1", result.get(0).getTenPhim());
        verify(phimRepo, times(1)).findAll();
    }

    @Test
    void save() {
        // Given
        Phim phim = new Phim(3L, "Phim 3", "Kinh dị", "Dao Dien X", "Dien Vien A, B", 100,
                "Rất đáng sợ", new Date(), new Date(), "Ngừng chiếu");

        // When
        phimService.save(phim);

        // Then
        ArgumentCaptor<Phim> phimCaptor = ArgumentCaptor.forClass(Phim.class);
        verify(phimRepo).save(phimCaptor.capture());
        assertEquals(phim.getTenPhim(), phimCaptor.getValue().getTenPhim());
    }

    @Test
    void getById() {
        // Given
        Phim phim = new Phim(4L, "Phim 4", "Tâm lý", "Dao Dien Z", "Dien Vien C", 110,
                "Mô tả sâu sắc", new Date(), new Date(), "Đang chiếu");
        when(phimRepo.findById(4L)).thenReturn(Optional.of(phim));

        // When
        Phim result = phimService.getById(4L);

        // Then
        assertNotNull(result);
        assertEquals("Phim 4", result.getTenPhim());
        verify(phimRepo).findById(4L);
    }

    @Test
    void deleteById() {
        // When
        phimService.deleteById(5L);

        // Then
        verify(phimRepo, times(1)).deleteById(5L);
    }
}
