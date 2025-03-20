package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.PhongChieu;
import com.example.nhom10agile.Repository.PhongChieuRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongChieuService {
    private final PhongChieuRepo phongChieuRepo;

    public PhongChieuService(PhongChieuRepo phongChieuRepo) {
        this.phongChieuRepo = phongChieuRepo;
    }

    public List<PhongChieu> getAllPhong() {
        return phongChieuRepo.findAll();
    }

    public void save(@Valid PhongChieu phong) {
        phongChieuRepo.save(phong);
    }
}
