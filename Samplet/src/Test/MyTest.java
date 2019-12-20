package Test;

import java.util.ArrayList;


public class MyTest {
  int i =10;
  public int plus () {
    System.out.println("one");
    return 1;
  }
  
  MyTest() {
    // TODO Auto-generated constructor stub
  }
}

 class B extends MyTest{

 }
 
 class C extends B{
     
   ArrayList <Integer> ar = new ArrayList<Integer>();
     public void i() {
       C c = new C();
      
       c.plus();
     }

 }