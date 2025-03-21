package com.example.nhom10agile.Entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class LoaiGheConverter implements AttributeConverter<LoaiGhe, String> {
    @Override
    public String convertToDatabaseColumn(LoaiGhe attribute) {
        if(attribute == null) {
            return null;
        }
        // Lưu giá trị theo dạng có dấu trong DB
        switch(attribute) {
            case THUONG:
                return "Thường";
            case VIP:
                return "VIP";
            case DOI:
                return "Đôi";
            default:
                throw new IllegalArgumentException("Loại ghế không được hỗ trợ: " + attribute);
        }
    }

    @Override
    public LoaiGhe convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        // Sử dụng phương thức fromValue đã định nghĩa trong LoaiGhe
        return LoaiGhe.fromValue(dbData);
    }
}
