package com.example.shark_inc.models.leasing;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Debts {
    public String Name;
    public BigDecimal Amount;

    @Override
    public String toString() {
        return "Debts{" +
                "Name='" + Name + '\'' +
                ", Amount=" + Amount +
                '}';
    }
}
