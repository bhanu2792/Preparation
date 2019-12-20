package PrintEvenOdd;

import java.util.concurrent.Semaphore;

public class TaskEvenOdd {
  public static void main(String[] args) {
    Printer print = new Printer();
    Thread t1 = new Thread(new TaskEvenOdd1(print, 10, false), "Odd");
    Thread t2 = new Thread(new TaskEvenOdd1(print, 10, true), "Even");
    t1.start();
    t2.start();
  }
}

class TaskEvenOdd1 implements Runnable {
  private int max;
  private Printer print;
  private boolean isEvenNumber;

  public TaskEvenOdd1(Printer p, int max, boolean isEven) {
    // TODO Auto-generated constructor stub
    this.max = max;
    print = p;
    isEvenNumber = isEven;
  }
  // standard constructors

  @Override
  public void run() {
    int number = isEvenNumber ? 2 : 1;
    
    System.out.println("Run called 1");
    while (number <= max) {
      if (isEvenNumber) {
        System.out.println("Run called 2");
        print.printEven(number);
      } else {
        System.out.println("Run called 3");
        print.printOdd(number);
      }
      System.out.println("Run called");
      number += 2;
    }
  }
}

class Printer {
  private volatile boolean isOdd;

  
  synchronized void printEven(int number) {
    while (!isOdd) {
      try {
        System.out.println("Before Even Wait");
        wait();
        System.out.println("After Even Wait");
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    System.out.println(Thread.currentThread().getName() + ":" + number);
    isOdd = false;
    System.out.println("Before Even notify");
    notify();
    System.out.println("After Even notify");
  }

  synchronized void printOdd(int number) {
    while (isOdd) {
      try {
        System.out.println("Before Odd Wait");
        wait();
        System.out.println("After Odd Wait");
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
    System.out.println(Thread.currentThread().getName() + ":" + number);
    isOdd = true;
    System.out.println("Before Odd notify");
    notify();
    System.out.println("After Odd notify");
  }
}