package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.PhongChieu;
import com.example.nhom10agile.Entity.RapPhim;
import com.example.nhom10agile.Repository.PhongChieuRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhongChieuServiceTest {

    private PhongChieuRepo phongChieuRepo;
    private PhongChieuService phongChieuService;

    @BeforeEach
    void setUp() {
        phongChieuRepo = Mockito.mock(PhongChieuRepo.class);
        phongChieuService = new PhongChieuService(phongChieuRepo);
    }

    @Test
    void getAllPhong() {
        RapPhim rapPhim = new RapPhim("Rap 1", "Địa chỉ 1", "123456789");
        PhongChieu phong1 = new PhongChieu(1L, "Phong 1", rapPhim, 100);
        PhongChieu phong2 = new PhongChieu(2L, "Phong 2", rapPhim, 150);

        List<PhongChieu> mockPhongChieus = Arrays.asList(phong1, phong2);
        Mockito.when(phongChieuRepo.findAll()).thenReturn(mockPhongChieus);

        List<PhongChieu> result = phongChieuService.getAllPhong();

        assertEquals(2, result.size());
        assertEquals("Phong 1", result.get(0).getTenPhong());
        assertEquals("Phong 2", result.get(1).getTenPhong());
        Mockito.verify(phongChieuRepo, Mockito.times(1)).findAll();
    }

    @Test
    void save() {
        RapPhim rapPhim = new RapPhim("Rap 1", "Địa chỉ 1", "123456789");
        PhongChieu phongChieu = new PhongChieu(3L, "Phong 3", rapPhim, 200);

        phongChieuService.save(phongChieu);

        ArgumentCaptor<PhongChieu> phongChieuCaptor = ArgumentCaptor.forClass(PhongChieu.class);
        Mockito.verify(phongChieuRepo).save(phongChieuCaptor.capture());

        assertEquals("Phong 3", phongChieuCaptor.getValue().getTenPhong());
        assertEquals(200, phongChieuCaptor.getValue().getSoGhe());
    }

    @Test
    void deleteById() {
        Long phongChieuId = 1L;

        phongChieuService.deleteById(phongChieuId);

        Mockito.verify(phongChieuRepo, Mockito.times(1)).deleteById(phongChieuId);
    }
}