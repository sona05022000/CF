package com.cf;
import java.util.*;

class SavingAccount implements Comparable<SavingAccount> {
    private double acc_balance;
    private int acc_ID;
    private String accountHolderName;
    private boolean isSalaryAccount;

    public SavingAccount(double acc_balance, int acc_ID, String accountHolderName, boolean isSalaryAccount) {
        this.acc_balance = acc_balance;
        this.acc_ID = acc_ID;
        this.accountHolderName = accountHolderName;
        this.isSalaryAccount = isSalaryAccount;
    }

    public double getAcc_balance() {
        return acc_balance;
    }

    public void setAcc_balance(double acc_balance) {
        this.acc_balance = acc_balance;
    }

    public int getAcc_ID() {
        return acc_ID;
    }

    public void setAcc_ID(int acc_ID) {
        this.acc_ID = acc_ID;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public boolean isSalaryAccount() {
        return isSalaryAccount;
    }

    public void setSalaryAccount(boolean salaryAccount) {
        isSalaryAccount = salaryAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingAccount that = (SavingAccount) o;
        return acc_ID == that.acc_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acc_ID);
    }

    @Override
    public int compareTo(SavingAccount other) {
        return Integer.compare(this.getAcc_ID(), other.getAcc_ID());
    }

    public void deposit(double amount) {
        acc_balance += amount;
    }

    public void withdraw(double amount) {
        if (acc_balance < amount) {
            System.out.println("Insufficient balance");
        } else {
            acc_balance -= amount;
        }
    }
}

class BankAccountList {
    private TreeSet<SavingAccount> savingAccounts = new TreeSet<>();

    public boolean addSavingAccount(SavingAccount savingAccount) {
        boolean added = false;
        if (!savingAccounts.contains(savingAccount)) {
            added = savingAccounts.add(savingAccount);
        }
        return added;
    }

    public List<Integer> displaySavingAccountIds() {
        List<Integer> accountIds = new ArrayList<>();
        for (SavingAccount account : savingAccounts) {
            accountIds.add(account.getAcc_ID());
        }
        return accountIds;
    

    }
}

public class Assignment3Q9 {
    public static void main(String[] args) {
        SavingAccount account1 = new SavingAccount(1000.0, 1, "John Doe", true);
        SavingAccount account2 = new SavingAccount(2000.0, 2, "Jane Doe", false);
        SavingAccount account3 = new SavingAccount(5000.0, 3, "Bob Smith", true);
       
        

        BankAccountList bankAccountList = new BankAccountList();
        bankAccountList.addSavingAccount(account1);
        bankAccountList.addSavingAccount(account2);
        bankAccountList.addSavingAccount(account3);
      

        List<Integer> accountIds = bankAccountList.displaySavingAccountIds();
        System.out.println("Account IDs: " + accountIds);
    }
}
