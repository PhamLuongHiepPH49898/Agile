package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.RapPhim;
import com.example.nhom10agile.Repository.RapPhimRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapPhimService {
    private final RapPhimRepo rapPhimRepo;

    public RapPhimService(RapPhimRepo rapPhimRepo) {
        this.rapPhimRepo = rapPhimRepo;
    }

    public List<RapPhim> getAllRap() {
        return rapPhimRepo.findAll();
    }

    public void save(RapPhim rapPhim) {
        rapPhimRepo.save(rapPhim);
    }

    public void deleteById(Long id) {
        rapPhimRepo.deleteById(id);
    }

    public Object getById(Long id) {
        return rapPhimRepo.findById(id).get();
    }
}
