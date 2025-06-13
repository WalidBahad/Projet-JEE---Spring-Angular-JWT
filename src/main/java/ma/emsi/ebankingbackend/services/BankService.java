package ma.emsi.ebankingbackend.services;

import jakarta.transaction.Transactional;
import ma.emsi.ebankingbackend.entities.BankAccount;
import ma.emsi.ebankingbackend.entities.CurrentAccount;
import ma.emsi.ebankingbackend.entities.SavingAccount;
import ma.emsi.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount=bankAccountRepository.findById("0409a2ac-93d8-4fd9-8e5e-f7968787ac6c").orElse(null);
        if (bankAccount != null) {
            System.out.println("***********************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if(bankAccount instanceof CurrentAccount){
                System.out.println("Over Draft: "+((CurrentAccount)bankAccount).getOverdraft());
            }else if(bankAccount instanceof SavingAccount){
                System.out.println("Rate: "+((SavingAccount)bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(accountOperation -> {
                System.out.println("==================");
                System.out.println(accountOperation.getDateOperation());
                System.out.println(accountOperation.getAmount());
                System.out.println(accountOperation.getType());
            });
        }
    }
}
