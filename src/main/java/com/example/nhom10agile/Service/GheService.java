package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.Ghe;
import com.example.nhom10agile.Repository.GheRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GheService {
    private final GheRepo gheRepo;

    public GheService(GheRepo gheRepo) {
        this.gheRepo = gheRepo;
    }

    public List<Ghe> getAllGhe() {
        return gheRepo.findAll();
    }

    public Optional<Ghe> getById(Long id) {
        return gheRepo.findById(id);
    }

    public void save(Ghe ghe) {
        gheRepo.save(ghe);
    }

    // ✅ Đặt ghế
    public boolean datGhe(Long gheId) {
        Optional<Ghe> optionalGhe = gheRepo.findById(gheId);
        if (optionalGhe.isPresent()) {
            Ghe ghe = optionalGhe.get();
            if (ghe.datGhe()) { // Sử dụng phương thức datGhe() trong entity
                gheRepo.save(ghe);
                return true;
            }
        }
        return false; // Ghế đã được đặt trước đó
    }

    // ✅ Hủy đặt ghế
    public boolean huyGhe(Long gheId) {
        Optional<Ghe> optionalGhe = gheRepo.findById(gheId);
        if (optionalGhe.isPresent()) {
            Ghe ghe = optionalGhe.get();
            if (ghe.huyGhe()) { // Sử dụng phương thức huyGhe() trong entity
                gheRepo.save(ghe);
                return true;
            }
        }
        return false; // Ghế chưa được đặt, không thể hủy
    }

    public void delete(Long id) {
        gheRepo.deleteById(id);
    }
}
