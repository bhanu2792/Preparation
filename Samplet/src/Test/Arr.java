package Test;

class Arr implements Runnable {
  public void run() {
    System.out.println("thread is running...");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static void main(String args[]) throws InterruptedException {
    Arr m1 = new Arr();
    Arr m2 = new Arr();
    Thread t1 = new Thread(m1);
    System.out.println("T1 Started");
    t1.start();
    t1.join();
    System.out.println("T1 Ended");
    Thread t2 = new Thread(m2);
    System.out.println("T2 Started");
    t2.start();
  }
}
