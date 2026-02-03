package com.cyber.busSeatSeller.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private int Number;

    private String Owner;

    private double SellPrice;

    private double PriceToBuy;

    private boolean IsAnonymous;

    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate LastSellAt;

    private boolean IsVacant;

    @Deprecated
    protected Seat(){}

    public Seat(int number){
        Number = number;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public double getSellPrice() {
        return SellPrice;
    }

    public void setSellPrice(double sellPrice) {
        SellPrice = sellPrice;
    }

    public double getPriceToBuy() {
        return PriceToBuy;
    }

    public void setPriceToBuy(double priceToBuy) {
        PriceToBuy = priceToBuy;
    }

    public boolean isAnonymous() {
        return IsAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        IsAnonymous = anonymous;
    }

    public LocalDate getLastSellAt() {
        return LastSellAt;
    }

    public void setLastSellAt(LocalDate lastSellAt) {
        LastSellAt = lastSellAt;
    }

    public boolean isVacant() {
        return IsVacant;
    }

    public void setVacant(boolean vacant) {
        IsVacant = vacant;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Id == seat.Id && Number == seat.Number && Double.compare(SellPrice, seat.SellPrice) == 0 && Double.compare(PriceToBuy, seat.PriceToBuy) == 0 && IsAnonymous == seat.IsAnonymous && IsVacant == seat.IsVacant && Objects.equals(Owner, seat.Owner) && Objects.equals(LastSellAt, seat.LastSellAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Number, Owner, SellPrice, PriceToBuy, IsAnonymous, LastSellAt, IsVacant);
    }
}
