package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.Ve;
import com.example.nhom10agile.Repository.VeRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeService {
    private final VeRepo veRepo;

    public VeService(VeRepo veRepo) {
        this.veRepo = veRepo;
    }

    public List<Ve> getAllVe() {
        return veRepo.findAll();
    }

    public void save(@Valid Ve ve) {
        veRepo.save(ve);
    }
}
