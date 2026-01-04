import java.util.*;
import java.math.*;

public class Guess_The_Number {

    public static void main(String[] args) {
        int user_number=0;
        int computer_number=(int)(Math.random()*100);
        System.out.println(computer_number);
        Scanner sc=new Scanner(System.in);

        System.out.println("*********************************************");
        System.out.println("Well come to the Number Guessing Game");
        System.out.println("you have to guess the number between 1 to 100");
        System.out.println("You have 7 Chance to guess the number");
        System.out.println("*********************************************");

        for(int i=1; i<=7;i++){
            System.out.println("---------------------------------------------");
            System.out.println("Enter a number");
            user_number=sc.nextInt();
            if(user_number==computer_number){
                System.out.println("*********************************************");
                System.out.println("You guess the Correct number");
                System.out.println("You win the game !!");
                System.out.println("*********************************************");
                break;
            }
            else {
                if(user_number>computer_number){
                    System.out.println("Your number is too High !!");
                }
                else{
                    System.out.println("Your number is too Low !!");
                }
                System.out.println("now you have " + (7 - i) + " chances.");
                System.out.println("---------------------------------------------");
            }
        }

    }
}
