package lk.inli.concurrency;

class MyRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println("My Runnable running");
  }
}

public class MyThread extends Thread {

  @Override
  public void run() {
    System.out.println("My Thread running");
  }
}

class MyTestClass {

  private final long abc = 1_000_000;

  public static void main(String[] args) {
    MyTestClass testClass = new MyTestClass();
    System.out.println(testClass.abc);

    // 1
    MyThread myThread = new MyThread();
    myThread.start();

    // 2
    MyRunnable runnable = new MyRunnable();
    Thread thread2 = new Thread(runnable);
    thread2.start();
    thread2.stop();

    // 3
    Runnable runnable3 =
        new Runnable() {
          @Override
          public void run() {
            System.out.println("Anonymous Runnable running");
          }
        };
    Thread thread3 = new Thread(runnable3);
    thread3.start();

    // 4
    Thread thread4 = new Thread(() -> System.out.println("Lambda Runnable running"));
    thread4.start();
  }
}
