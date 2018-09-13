package thread;

import static java.lang.Thread.*;

class RunnableInterfaceDemo
    implements Runnable {

  @Override
  public void run() {
    String name = currentThread().getName();
    System.out.println("Thread demo using Runnable interface -> " + name);
    int i = 0;
    while (i < 10) {
      System.out.println("Printing using Runnable interface -> " + i);
      i++;
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        System.err.println(name + " thread interrupted");
        e.printStackTrace();
      }
    }
  }
}

class ThreadClassDemo
    extends Thread {

  ThreadClassDemo(String threadName) {
    super(threadName);
  }

  @Override
  public void run() {
    String name = currentThread().getName();
    System.out.println("Thread demo using Thread class -> " + name);
    int i = 0;
    while (i < 10) {
      System.out.println("Printing using Thread class -> " + i);
      i++;
      try {
        sleep(1000);
      } catch (InterruptedException ex) {
        System.err.println(name + " thread interrupted");
        ex.printStackTrace();
      }
    }
    System.out.println("Calling notify on thread " + name);
  }
}


public class CreatingThread {

  public static void main(String[] args) {

    //Creating thread using Runnable implemented class
    RunnableInterfaceDemo runnableInterfaceDemo = new RunnableInterfaceDemo();
    Thread thread1 = new Thread(runnableInterfaceDemo, "RunnableInterfaceThread");
    thread1.start();

    //Creating thread using Thread class
    ThreadClassDemo thread2 = new ThreadClassDemo("ThreadClassThread");
    thread2.start();

    //Creating thread using anonymous implementation of Thread class
    Thread thread3 = new Thread(){
      @Override
      public void run() {
        System.out.println(currentThread().getName() + " is printing this");
      }
    };
    thread3.start();

    //Creating thread using anonymous implementation of Runnable interface, here, using lambda
    Runnable runnable = () -> System.out.println(currentThread().getName() + " is printing this");
    Thread thread4 = new Thread(runnable, "thread4");
    thread4.start();
  }
}
