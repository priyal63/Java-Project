
import java.util.Scanner;

class Rock_Paper_Scissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userscore = 0;
        int computerscore = 0;

        System.out.println("Enter your name");
        String name = sc.nextLine();

        System.out.println("Enter your age");
        int age = sc.nextInt();

        if (age <= 0) {
            System.out.println("Age must be a positive integer & game is anded");
            return;
        }

        System.out.println("wellcome to this game");

        System.out.println("-------------------------------------------------------------");

        System.out.println("Choices of this game");
        System.out.println(" 1. Rock \n 2. Paper \n 3. Scissor");

        System.out.println("-------------------------------------------------------------");
        System.out.println("--> Rules of this game");
        System.out.println(" Rock beats Scissors \n Paper beats Rock \n Scissors beats Paper");

        System.out.println("-------------------------------------------------------------");
        int sum = 0;
        int a = 0;

        for (int i = 1; i <= 3; i++) {
            System.out.println("*************************************************************");

            boolean valid_choice = true;
            while (valid_choice) {
                System.out.println("enter num in 1 to 3");
                try {
                    a = sc.nextInt();
                    if (a >= 1 && a <= 3) {
                        if(a==1){
                            System.out.println("Your choice is Rock");
                        }
                        else if(a==2){
                            System.out.println("Your choice is Paper");
                        }
                        else if(a==3){
                            System.out.println("Your choice is Scissors");
                        }
                        valid_choice = false;
                    } else {
                        System.out.println("please enter 1,2,3");
                    }
                } catch (Exception e) {
                    System.out.println("Enter a valid number");
                    sc.next(); // VERY IMPORTANT
                }
            }


            System.out.println("-------------------------------------------------------------");

            int b = (int) ((Math.random() * 3) + 1);//b=computer choice//
            switch (b) {
                case 1:
                    System.out.println("Computer choice is Rock");
                    break;
                case 2:
                    System.out.println("Computer choice is Paper");
                    break;
                case 3:
                    System.out.println("Computer choice is Scissor");
                    break;
                default:
                    System.out.println("please enter 1,2,3 \n game over");
                    break;
            }

            System.out.println("-------------------------------------------------------------");

            if (a == b) {
                System.out.println("Its tie");
            } else if (a == 1 && b == 2) {
                computerscore++;
                System.out.println("You loos ");
            } else if (a == 1 && b == 3) {
                userscore++;
                System.out.println("You winn");
            } else if (a == 2 && b == 1) {
                userscore++;
                System.out.println("You winn ");
            } else if (a == 2 && b == 3) {
                computerscore++;
                System.out.println("You loos ");
            } else if (a == 3 && b == 1) {
                computerscore++;
                System.out.println("You loos");
            } else if (a == 3 && b == 2) {
                userscore++;
                System.out.println("You winn");
            } else {
                System.out.println("game over");
            }
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("current Score-" + name + ":" + userscore + "  Computer score:" + computerscore);

        System.out.println("*************************************************************");

        System.out.println("-------------------------------------------------------------");
        System.out.println("Final Score-" + name + ":" + userscore + "  Computer score:" + computerscore);

        System.out.println("-------------------------------------------------------------");

        if (userscore > computerscore) {
            System.out.println("User wins the game");
        }
        if (userscore == computerscore) {
            System.out.println("Its tie");
        }
        if (userscore < computerscore) {
            System.out.println("Computer wins the game");
        }

        System.out.println("*************************************************************");
    }
}
