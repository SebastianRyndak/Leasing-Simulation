package com.example.shark_inc.models.leasing;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class FinancialInformation {
    public BigDecimal GrossEarnings;
    public String CompanyName;
    public int ContractDuration;
    public int ManagerPhoneNumber;
    public BigDecimal totalExposure;
    public String ForbiddenBusinessType;
    public int ForbiddenAssetType;
    public List<Debts> CustomerCurrentDebts;
}
