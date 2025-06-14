package ma.emsi.ebankingbackend.dtos;

import lombok.Data;

import ma.emsi.ebankingbackend.enums.AccountStatus;

import java.util.Date;

@Data
public class SavingBankAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private double interestRate;

    private CustomerDTO customerDTO;
}
