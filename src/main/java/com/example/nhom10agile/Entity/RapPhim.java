package com.example.nhom10agile.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rap_phim")
public class RapPhim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenRap;

    private String diaChi;

    private String soDienThoai;

    @OneToMany(mappedBy = "rapPhim", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhongChieu> phongChieuList;

    public RapPhim() {
    }

    public RapPhim(String soDienThoai, String diaChi, String tenRap) {
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.tenRap = tenRap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenRap() {
        return tenRap;
    }

    public void setTenRap(String tenRap) {
        this.tenRap = tenRap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<PhongChieu> getPhongChieuList() {
        return phongChieuList;
    }

    public void addPhongChieuList(PhongChieu phongChieuList) {
        this.phongChieuList.add(phongChieuList);
    }
    public void removePhongChieuList(PhongChieu phongChieuList) {
        this.phongChieuList.remove(phongChieuList);
    }
}
