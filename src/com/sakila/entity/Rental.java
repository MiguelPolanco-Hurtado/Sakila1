package com.sakila.entity;

import java.sql.Date;

public class Rental {
    private int rentalId;
    private Date rentalDate;
    private Date returnDate;

    // Constructor con los parámetros correctos
    public Rental(int rentalId, Date rentalDate, Date returnDate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    // Getters y Setters (si no los tienes)
    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

