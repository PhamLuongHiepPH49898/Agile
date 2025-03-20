package com.example.nhom10agile.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ghe")
public class Ghe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phong_id", nullable = false)
    private PhongChieu phongChieu;

    private String soGhe;

    @Enumerated(EnumType.STRING)
    private LoaiGhe loaiGhe = LoaiGhe.THUONG;

    @Enumerated(EnumType.STRING)
    private TrangThaiGhe trangThaiGhe = TrangThaiGhe.TRONG;

    public Ghe() {
    }

    public Ghe(Long id, PhongChieu phongChieu, String soGhe, LoaiGhe loaiGhe, TrangThaiGhe trangThaiGhe) {
        this.id = id;
        this.phongChieu = phongChieu;
        this.soGhe = soGhe;
        this.loaiGhe = loaiGhe;
        this.trangThaiGhe = trangThaiGhe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhongChieu getPhongChieu() {
        return phongChieu;
    }

    public void setPhongChieu(PhongChieu phongChieu) {
        this.phongChieu = phongChieu;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public LoaiGhe getLoaiGhe() {
        return loaiGhe;
    }

    public void setLoaiGhe(LoaiGhe loaiGhe) {
        this.loaiGhe = loaiGhe;
    }

    public TrangThaiGhe getTrangThaiGhe() {
        return trangThaiGhe;
    }

    public void setTrangThaiGhe(TrangThaiGhe trangThaiGhe) {
        this.trangThaiGhe = trangThaiGhe;
    }
}

enum LoaiGhe{
    THUONG,
    VIP,
    DOI
}
enum TrangThaiGhe{
    TRONG,
    DA_DAT
}

