
import java.util.Scanner;


class ATMInterface
{
    public static void atmcodingPart()
    {
        int pin=1234;
        Scanner sc1=new Scanner(System.in);
        System.out.println("Please Enter Your Pin!");
        int p=sc1.nextInt();
        if(p==pin)
        {
            options();
        }
        else
        {
            System.out.println("Invalid Pin!"); 
            atmcodingPart();
        }
    }
    public static void options()
    {
        int balance=10000;
        int depositamount;
        int withdrawalamount;
        Scanner sc2=new Scanner(System.in);
        
        System.out.println("--------WelCome---------");
        System.out.println("Choose one of the Option");
        System.out.println("1. Deposit");
        System.out.println("2. WithDraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        
        int a=sc2.nextInt();
        if(a==1)
        {
            deposit();
            depositamount=sc2.nextInt();
            depositamount=balance + depositamount;
            System.out.println("Your Current Balance is : "+depositamount);
            exit();
        }
        else if(a==2)
        {
            withdraw();
            withdrawalamount=sc2.nextInt();
            if(balance>=withdrawalamount)
            {
                balance= balance - withdrawalamount;
                System.out.println("Your Current Balance is : "+balance);
                exit();
            }
            else
            {
                System.out.println("Insufficient Balance!");
            }
        }
        else if(a==3)
        {
            checkBalance();
            System.out.println(balance);
            exit();
        }
        else if(a==4)
        {
            exit();
        }
    }
    public static void deposit()
    {
        System.out.println("Enter the Amount you want to deposit");
    }
    public static void withdraw()
    {
        System.out.println("Enter the Amount you want to withdraw");
    }
    public static void checkBalance()
    {
        System.out.println("Your Balance is :");
    }
    public static void exit()
    {
        System.out.println("Please Collect Your Card");
        System.out.println("Thank You, Have a nice day !");
    }
    public static void main(String[] args) 
    {
        atmcodingPart();
    }
}
