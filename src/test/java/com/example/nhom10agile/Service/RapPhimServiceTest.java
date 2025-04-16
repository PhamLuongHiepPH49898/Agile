package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.RapPhim;
import com.example.nhom10agile.Repository.RapPhimRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RapPhimServiceTest {

    private RapPhimRepo rapPhimRepo;
    private RapPhimService rapPhimService;

    @BeforeEach
    void setUp() {
        rapPhimRepo = Mockito.mock(RapPhimRepo.class);
        rapPhimService = new RapPhimService(rapPhimRepo);
    }

    @Test
    void getAllRap() {

        List<RapPhim> mockRapPhims = Arrays.asList(
                new RapPhim("Rap 1", "Địa chỉ 1", "123456789"),
                new RapPhim("Rap 2", "Địa chỉ 2", "987654321")
        );
        Mockito.when(rapPhimRepo.findAll()).thenReturn(mockRapPhims);


        List<RapPhim> result = rapPhimService.getAllRap();

        assertEquals(2, result.size());
        assertEquals("Rap 1", result.get(0).getTenRap());
        assertEquals("Rap 2", result.get(1).getTenRap());
        Mockito.verify(rapPhimRepo, Mockito.times(1)).findAll();  // Kiểm tra findAll() được gọi một lần
    }

    @Test
    void save() {
        RapPhim rapPhim = new RapPhim("Rap 3", "Địa chỉ 3", "123456789");

        rapPhimService.save(rapPhim);


        ArgumentCaptor<RapPhim> rapPhimCaptor = ArgumentCaptor.forClass(RapPhim.class);
        Mockito.verify(rapPhimRepo).save(rapPhimCaptor.capture());

        assertEquals("Rap 3", rapPhimCaptor.getValue().getTenRap());
        assertEquals("Địa chỉ 3", rapPhimCaptor.getValue().getDiaChi());
    }
    @Test
    void deleteById() {
        Long rapPhimId = 1L;

        rapPhimService.deleteById(rapPhimId);

        Mockito.verify(rapPhimRepo, Mockito.times(1)).deleteById(rapPhimId);
    }


    @Test
    void getById() {
        RapPhim mockRapPhim = new RapPhim("Rap 4", "Địa chỉ 4", "123456789");
        mockRapPhim.setId(1L);

        Mockito.when(rapPhimRepo.findById(1L)).thenReturn(Optional.of(mockRapPhim));


        RapPhim result = (RapPhim) rapPhimService.getById(1L);

        assertNotNull(result);
        assertEquals("Rap 4", result.getTenRap());
        assertEquals("Địa chỉ 4", result.getDiaChi());
        Mockito.verify(rapPhimRepo).findById(1L);
    }

}