package atmmachine;

import java.util.Scanner;


public class Maain {
    public static void main(String[] args) {
        AtmOperationInterf op = new AtmOperationImpl();
        int atmnumber= 12345;
        int atmpin= 123;
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine!!!");
        System.out.println("Enter Atm Number:");
        int atmNumber = in.nextInt();
        System.out.println("Enter Pin :");
        int pin = in.nextInt();

        if((atmnumber==atmNumber)&&(atmpin==pin))
        {
            while(true){
                System.out.println("1.View Available Balance\n2.Withraw Amount\n3.Deposit Amount\n4.View Mini Statement\n5.Exit");
                System.out.println("Enter Choice: ");
                int ch = in.nextInt();
                if (ch==1)
                {
                    op.viewBalance();
                }
                else if (ch==2)
                {
                    System.out.println("Enter amount to withdraw: ");
                    Double withdrawAmount = in.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                }
                else if(ch==3)
                {
                    System.out.println("Enter Amount To Deposit:");
                    Double depositAmount= in.nextDouble();
                    op.depositAmount(depositAmount);
                }
                else if(ch==4)
                {
                    op.viewMiniStatement();
                }
                else if(ch==5)
                {
                    System.out.println("Collect Your ATM card\n Thank You For using ATM Machine");
                    System.exit(0);
                }
                else 
                {
                    System.out.println("Please Enter Valid Choice!!");
                }
            }
            

        }
        else{
            System.out.println("Inncorrect Atm Number Or Atm Pin");
            System.exit(0);
        }
    }
}
