package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.SuatChieu;
import com.example.nhom10agile.Repository.SuatChieuRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuatChieuService {
    private final SuatChieuRepo suatChieuRepo;

    public SuatChieuService(SuatChieuRepo suatChieuRepo) {
        this.suatChieuRepo = suatChieuRepo;
    }

    public List<SuatChieu> getAllSuat() {
        return suatChieuRepo.findAll();
    }

    public void save(@Valid SuatChieu suat) {
        suatChieuRepo.save(suat);
    }
}
