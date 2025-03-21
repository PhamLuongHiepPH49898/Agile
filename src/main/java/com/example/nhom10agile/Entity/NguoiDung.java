package com.example.nhom10agile.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hoTen;
    private String email;
    private String matKhau;
    private String soDienThoai;

    @Enumerated(EnumType.STRING)
    @Column(name = "vai_tro") // Đảm bảo ánh xạ chính xác với DB
    private VaiTro vaiTro;

    public NguoiDung() {
        this.vaiTro = VaiTro.KHACH_HANG; // Giá trị mặc định
    }

    public NguoiDung(Long id, String hoTen, String email, String matKhau, String soDienThoai, VaiTro vaiTro) {
        this.id = id;
        this.hoTen = hoTen;
        this.email = email;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
        this.vaiTro = vaiTro != null ? vaiTro : VaiTro.KHACH_HANG; // Tránh lỗi nếu vaiTro bị null
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public VaiTro getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(VaiTro vaiTro) {
        this.vaiTro = vaiTro;
    }
}

enum VaiTro {
    KHACH_HANG("Khách hàng"),
    QUAN_TRI_VIEN("Quản trị viên");

    private final String value;

    VaiTro(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static VaiTro fromString(String text) {
        for (VaiTro v : VaiTro.values()) {
            if (v.value.equalsIgnoreCase(text)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy enum VaiTro cho giá trị: " + text);
    }
}
