import java.util.Scanner;
import java.lang.Math;
public class guessgame {
    static void game(){
        Scanner sc = new Scanner(System.in);
        int ans =(int)Math.floor(Math.random()*20);
        int i=0,key=0;
        while(i<5){
            System.out.print("Enter your guess: ");
            int g = sc.nextInt();
            if (g==ans){
                System.out.println("Correct!!");
                key = 1;
                break;
            }
            else{
                if (g > ans){
                    System.out.println("Number is lesser.");
                }
                else{
                    System.out.println("Number is greater.");
                }
                i++;
            }
        }
        if (key == 0){
            System.out.println("You lost");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.println("Welcome "+name);
        System.out.print("Shall we start the game(yes/no): ");
        String a = sc.next();
        if (a.equals("yes")){
            game();
        }
        else{
            System.out.println("You exited");
        }
    }
}