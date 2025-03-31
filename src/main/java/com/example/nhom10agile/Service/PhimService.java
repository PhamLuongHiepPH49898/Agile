package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.Phim;
import com.example.nhom10agile.Repository.PhimRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhimService {
    private final PhimRepo phimRepo;

    public PhimService(PhimRepo phimRepo) {
        this.phimRepo = phimRepo;
    }

    public List<Phim> getAllPhim() {
        return phimRepo.findAll();
    }

    public void save(Phim phim) {
        phimRepo.save(phim);
    }

    public Phim getById(Long id) {
        return phimRepo.findById(id).get();
    }

    public void deleteById(Long id) {
        phimRepo.deleteById(id);
    }
}