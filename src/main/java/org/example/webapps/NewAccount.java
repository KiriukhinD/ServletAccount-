package org.example.webapps;

public class NewAccount {
   private   String name;
   private String bankAccount;
   public NewAccount(String name, String bankAccount){
       this.name = name;
       this.bankAccount = bankAccount;

   }
   public String getName(){
       return name;
   }
   public String getBankAccount(){
       return bankAccount;
   }
   public void setName(String name){
       this.name = name;
   }
   public void setBankAccount(String bankAccount){
       if(bankAccount == null)
       {
           throw new RuntimeException("not null");
       }
       this.bankAccount = bankAccount;
   }
   @Override
   public String toString(){
       return "Имя клиента : [ "+ name + " ] номер счёта  [" + bankAccount+" ]";
   }


}
