package com.example.nhom10agile.Service;

import com.example.nhom10agile.Entity.NguoiDung;
import com.example.nhom10agile.Repository.NguoiDungRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoiDungService {
    private final NguoiDungRepo nguoiDungRepo;

    public NguoiDungService(NguoiDungRepo nguoiDungRepo) {
        this.nguoiDungRepo = nguoiDungRepo;
    }

    public List<NguoiDung> getAllNguoiDung() {
        return nguoiDungRepo.findAll();
    }
}
