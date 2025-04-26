package com.example.crud.models;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class RentalRoomDto {
    @NotEmpty(message = "Ten nguoi thue khong duoc bo trong")
    private String tenantName;

    @NotEmpty(message = "So dien thoai nguoi thue khong duoc bo trong")
    private String phoneNumber;

    private LocalDate rentalDate;

    private String note;

    public Long getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Long paymentType) {
        this.paymentType = paymentType;
    }

    private Long paymentType;

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
