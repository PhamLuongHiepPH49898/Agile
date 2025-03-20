package com.example.nhom10agile.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "suat_chieu")
public class SuatChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phim_id", nullable = false)
    private Phim phim;

    @ManyToOne
    @JoinColumn(name = "phong_id", nullable = false)
    private PhongChieu phongChieu;

    private LocalDate ngayChieu;

    private LocalTime gioBatDau;

    private LocalTime gioKetThuc;

    private BigDecimal giaVe;

    public SuatChieu() {
    }

    public SuatChieu(Long id, Phim phim, PhongChieu phongChieu, LocalDate ngayChieu, LocalTime gioBatDau, LocalTime gioKetThuc, BigDecimal giaVe) {
        this.id = id;
        this.phim = phim;
        this.phongChieu = phongChieu;
        this.ngayChieu = ngayChieu;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.giaVe = giaVe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Phim getPhim() {
        return phim;
    }

    public void setPhim(Phim phim) {
        this.phim = phim;
    }

    public PhongChieu getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieu phongChieu) {
        this.phongChieu = phongChieu;
    }

    public LocalDate getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(LocalDate ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    public LocalTime getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(LocalTime gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public LocalTime getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(LocalTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public BigDecimal getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }
}
