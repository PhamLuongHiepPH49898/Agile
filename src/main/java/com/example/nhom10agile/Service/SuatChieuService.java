package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.SuatChieu;
import com.example.nhom10agile.Repository.SuatChieuRepo;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuatChieuService {
    private static final Logger logger = LoggerFactory.getLogger(SuatChieuService.class);
    private final SuatChieuRepo suatChieuRepo;

    public SuatChieuService(SuatChieuRepo suatChieuRepo) {
        this.suatChieuRepo = suatChieuRepo;
    }

    public List<SuatChieu> getAllSuat() {
        List<SuatChieu> suats = suatChieuRepo.findAll();
        logger.info("Số lượng suất chiếu lấy ra: {}", suats.size());
        return suats;
    }

    public void save(SuatChieu suat) {
        suatChieuRepo.save(suat);
        logger.info("Đã lưu suất chiếu: {}", suat);
    }

    public void deleteById(Long id) {
        suatChieuRepo.deleteById(id);
        logger.info("Đã xóa suất chiếu có ID: {}", id);
    }


    public Object getById(Long id) {
        return suatChieuRepo.findById(id).get();
    }
}