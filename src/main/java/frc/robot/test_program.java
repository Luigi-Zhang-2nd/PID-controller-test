package frc.robot;

public class test_program { 
   int x;
   public test_program(int num) { 
    x=num;
   }


   public static void e(String[] args) { 
      test_program myObj = new test_program(2); // Create an object of class Main (This will call the constructor) 
      System.out.println(myObj.x); // x = 5
   } 
}
