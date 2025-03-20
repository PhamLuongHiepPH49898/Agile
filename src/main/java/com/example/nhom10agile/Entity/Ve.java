package com.example.nhom10agile.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ve")
public class Ve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "suat_chieu_id", nullable = false)
    private SuatChieu suatChieu;

    @ManyToOne
    @JoinColumn(name = "ghe_id", nullable = false)
    private Ghe ghe;

    @ManyToOne
    @JoinColumn(name = "nguoi_dung_id",nullable = false)
    private NguoiDung nguoiDung;

    @Enumerated(EnumType.STRING)
    private TrangThaiVe trangThai = TrangThaiVe.DA_DAT;

    public Ve() {
    }

    public Ve(Long id, SuatChieu suatChieu, Ghe ghe, NguoiDung nguoiDung, TrangThaiVe trangThai) {
        this.id = id;
        this.suatChieu = suatChieu;
        this.ghe = ghe;
        this.nguoiDung = nguoiDung;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SuatChieu getSuatChieu() {
        return suatChieu;
    }

    public void setSuatChieu(SuatChieu suatChieu) {
        this.suatChieu = suatChieu;
    }

    public Ghe getGhe() {
        return ghe;
    }

    public void setGhe(Ghe ghe) {
        this.ghe = ghe;
    }

    public NguoiDung getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDung nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    public TrangThaiVe getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThaiVe trangThai) {
        this.trangThai = trangThai;
    }
}
enum TrangThaiVe {
    DA_DAT,
    DA_THANH_TOAN,
    HUY
}
