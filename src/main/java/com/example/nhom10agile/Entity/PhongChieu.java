package com.example.nhom10agile.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="phong_chieu")
public class PhongChieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenPhong;

    @ManyToOne
    @JoinColumn(name = "rap_id", nullable = false)
    private RapPhim rapPhim;
    private int soGhe;

    public PhongChieu() {
    }

    public PhongChieu(Long id, String tenPhong, RapPhim rapPhim, int soGhe) {
        this.id = id;
        this.tenPhong = tenPhong;
        this.rapPhim = rapPhim;
        this.soGhe = soGhe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public RapPhim getRapPhim() {
        return rapPhim;
    }

    public void setRapPhim(RapPhim rapPhim) {
        this.rapPhim = rapPhim;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
}
