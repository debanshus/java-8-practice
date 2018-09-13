package thread;

class A {

  public void print() {
    System.out.println(Thread.currentThread().getName() + ": Inside print() of class A");
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " printing " + i);
    }
  }

  synchronized public void syncPrint() {
    System.out.println(Thread.currentThread().getName() + ": Inside synchronized print() of class A");
    for (int i = 0; i < 5; i++) {
      System.out.println(Thread.currentThread().getName() + " printing " + i);
    }
  }
}

class RunnableImpl
    implements Runnable {

  A a;

  public RunnableImpl(A a) {
    this.a = a;
  }

  @Override
  public void run() {
    synchronized (a) {
      a.print();
    }

    //a.syncPrint();
  }
}

public class SynchronizationDemo {

  public static void main(String[] args) {
    System.out.println("Synchronization Demo");

    A a = new A();
    RunnableImpl runnable1 = new RunnableImpl(a);
    RunnableImpl runnable2 = new RunnableImpl(a);

    Thread thread1 = new Thread(runnable1, "ThreadForWaitNotify");
    Thread thread2 = new Thread(runnable2, "Thread2");

    thread1.start();
    thread2.start();
  }
}
