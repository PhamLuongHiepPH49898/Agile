package com.example.nhom10agile.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "phim")
public class Phim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenPhim;

    private String theLoai;

    private String daoDien;

    private String dienVien;
    private int thoiLuong;
    private String moTa;

    @Temporal(TemporalType.DATE)
    private Date ngayKhoiChieu;

    @Temporal(TemporalType.DATE)
    private Date ngayKetThuc;

    private String trangThai;

    public Phim() {
    }

    public Phim(Long id, String tenPhim, String theLoai, String daoDien, String dienVien, int thoiLuong, String moTa, Date ngayKhoiChieu, Date ngayKetThuc, String trangThai) {
        this.id = id;
        this.tenPhim = tenPhim;
        this.theLoai = theLoai;
        this.daoDien = daoDien;
        this.dienVien = dienVien;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
        this.ngayKhoiChieu = ngayKhoiChieu;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getDaoDien() {
        return daoDien;
    }

    public void setDaoDien(String daoDien) {
        this.daoDien = daoDien;
    }

    public String getDienVien() {
        return dienVien;
    }

    public void setDienVien(String dienVien) {
        this.dienVien = dienVien;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayKhoiChieu() {
        return ngayKhoiChieu;
    }

    public void setNgayKhoiChieu(Date ngayKhoiChieu) {
        this.ngayKhoiChieu = ngayKhoiChieu;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
