package com.example.shark_inc.services;

import com.example.shark_inc.models.leasing.CustomerData;
import com.example.shark_inc.models.leasing.KindOfEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InternalSales {

    @Autowired
    SendEmail sendEmail;

    public void startsTheLeasingApplicationProcess(CustomerData data){
        if(isProcedureAutomatic(data)){
            sendDecisionToDealer(KindOfEmail.MANUAL);
            String contract = getCustomerContract(data);
            sendContractToDealer(contract);
            return;
        }

        if(isDecisionPositive(data)){
            sendDecisionToDealer(KindOfEmail.POSITIVE);
            String contract = getCustomerContract(data);
            sendContractToDealer(contract);
            return;
        }

        sendDecisionToDealer(KindOfEmail.NEGATIVE);
    }

    private void sendContractToDealer(String contract){
        System.out.println(contract);
    }

    private String getCustomerContract(CustomerData data){
        return "Dear "+data.getCustomer().getName()+" please sign your contract!!!!!!!!!!!!!!!!";
    }


    private void sendDecisionToDealer(KindOfEmail emailKind){
        sendEmail.sendSimpleEmail(emailKind);
    }


    private boolean isProcedureAutomatic(CustomerData data){
        BigDecimal simplifiedProcedureBase = BigDecimal.valueOf(500000.00);
        BigDecimal totalCustomerExposure = data.getFinancialInformation().totalExposure;

        return totalCustomerExposure.compareTo(simplifiedProcedureBase)!= -1;
    }


    private boolean isDecisionPositive(CustomerData data){

        int contractDuration = data.getFinancialInformation().ContractDuration;
        String businessType = data.getFinancialInformation().getForbiddenBusinessType();
        int assetType = data.getFinancialInformation().getForbiddenAssetType();

        return contractDuration > 5 && businessType.equals("NO") && assetType != 13;
    }

}
