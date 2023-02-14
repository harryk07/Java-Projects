package atmmachine;

import java.util.HashMap;
import java.util.Map;


public class AtmOperationImpl  implements AtmOperationInterf{
    atm Atm= new atm();
    Map<Double,String> ministatment= new HashMap<>();

    @Override
    public void viewBalance() {
       System.out.println("Available Balance is: "+Atm.getBalance());
        
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        if(withdrawAmount%500==0){
            if (withdrawAmount<= Atm.getBalance()){
                ministatment.put(withdrawAmount, "Amount Withrawn");
            System.out.println("Collect the cash "+ withdrawAmount);
            Atm.setBalance(Atm.getBalance()-withdrawAmount);
            viewBalance();}
            else{
                System.out.println("Insufficient Balance!!");
            }
            
            
        }
        else
        {
            System.out.println("Please enter the amount multiple with 500");
        }
      
    }

    @Override
    public void depositAmount(double depositAmount) {
        ministatment.put(depositAmount, "Amount deposited");
        System.out.println(depositAmount+" Deposited Successfully!!");
        Atm.setBalance(Atm.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
   for(Map.Entry<Double,String> m: ministatment.entrySet()){
        System.out.println(m.getKey()+" "+m.getValue());
    }
    
}}
