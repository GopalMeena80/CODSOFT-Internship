
import java.util.Scanner;


public class NumberGame
{
    public static void numbergamecodingPart()
    {
        int count=0;
        System.out.println("You have 5 chance to guess the number");
        for(int i=1; i<=5; i++)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Your Number ?");
            int uservalue=sc.nextInt();
            
            int computervalue=(int) (Math.random()*100);
            System.out.println(computervalue);
            
            if(computervalue>uservalue)
            {
                System.out.println("The Guess is too low!");
            }
            else if(uservalue>computervalue)
            {
                System.out.println("The Guess is too high!");
            }
            else
            {
                System.out.println("The Guess is correct!");
                count++;
            }
        }
        System.out.println("Your Score is : "+count+"/5");
    }
    public static void main(String[] args)
    {
        numbergamecodingPart();
    }
}
