package org.algorithm;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        boolean flag=true;
        int target,guess;
        System.out.println("Enter the target number:");
        while(!scan.hasNextInt()){
            System.out.println("Enter the target number:");
            scan.next();
        }
        target=scan.nextInt();
        do{
            System.out.println("Guess the number:");
            if(!scan.hasNextInt()){
                scan.next();
                continue;
            }
            guess=scan.nextInt();
            if(guess>target){
                System.out.println("Too Hot!");
            }
            else if(guess<target){
                System.out.println("Too Cold!");
            }
            else{
                System.out.println("Exactly right!\n");
                flag=false;
            }
        }while(flag);
    }
}
