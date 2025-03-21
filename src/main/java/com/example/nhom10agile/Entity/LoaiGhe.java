package com.example.nhom10agile.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum LoaiGhe {
        THUONG("Thường"), // Thường
        VIP("VIP"),
        DOI("Đôi");

        private final String displayValue; // Mã hiển thị

        // Constructor để lưu giá trị hiển thị
        LoaiGhe(String displayValue) {
                this.displayValue = displayValue;
        }

        public String getDisplayValue() {
                return displayValue;
        }

        // Chuyển đổi từ chuỗi vào enum (hỗ trợ trường hợp nhập chuỗi có dấu hoặc không dấu)
        @JsonCreator
        public static LoaiGhe fromValue(String value) {
                if (value != null) {
                        switch (value.toUpperCase()) {
                                case "THƯỜNG":
                                case "THUONG":
                                        return THUONG;
                                case "VIP":
                                        return VIP;
                                case "ĐÔI":
                                case "DOI":
                                        return DOI;
                                default:
                                        throw new IllegalArgumentException("Unknown value: " + value + ". Please use 'THƯỜNG', 'VIP', or 'ĐÔI'.");
                        }
                }
                throw new IllegalArgumentException("Value cannot be null. Please provide a valid value.");
        }
}