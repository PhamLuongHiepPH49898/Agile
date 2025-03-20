package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.Ghe;
import com.example.nhom10agile.Repository.GheRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GheService {
    private final GheRepo gheRepo;

    public GheService(GheRepo gheRepo) {
        this.gheRepo = gheRepo;
    }

    public List<Ghe> getAllGhe() {
        return gheRepo.findAll();
    }

    public void save(@Valid Ghe ghe) {
        gheRepo.save(ghe);
    }
}
