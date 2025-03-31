package com.example.nhom10agile.Repository;

import com.example.nhom10agile.Entity.NguoiDung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NguoiDungRepo extends JpaRepository<NguoiDung,Long> {
    Optional<NguoiDung> findByEmail(String email);
}
