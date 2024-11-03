package com.ps;

import java.io.BufferedWriter;
import java.io.*;

public class ContractsFileManager {

    public static void saveContract(Contract contract){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true))){
            if(contract instanceof SalesContract){
                SalesContract sale = (SalesContract) contract;
                String salesContractToAdd = sale.toString();
                bufferedWriter.write(salesContractToAdd + "\n");
            } else {
                LeaseContract lease = (LeaseContract) contract;
                String leaseContractToAdd = lease.toString();
                bufferedWriter.write(leaseContractToAdd + "\n");
                bufferedWriter.close();
            }

        } catch(Exception exception){
            exception.printStackTrace();
        }
    }

}
