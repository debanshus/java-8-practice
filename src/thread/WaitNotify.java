package thread;

interface SleepProvider {

  default void sleep(String threadName, long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException ex) {
      System.err.println(threadName + " interrupted");
      ex.printStackTrace();
    }
  }
}

class PrintProvider
    implements SleepProvider {

  public synchronized void print(String threadName) {
    for (int i = 0; i < 5; i++) {
      System.out.println(threadName + " printing " + i);
      sleep(threadName, 1000);
    }
  }
}

class ThreadForWaitNotify
    implements Runnable, SleepProvider {

  PrintProvider provider;

  ThreadForWaitNotify(PrintProvider provider) {
    this.provider = provider;
  }

  @Override
  public void run() {
    provider.print(Thread.currentThread().getName());
  }
}

public class WaitNotify implements SleepProvider{

  public static void main(String[] args) {
    PrintProvider printProvider = new PrintProvider();
    ThreadForWaitNotify threadForWaitNotify = new ThreadForWaitNotify(printProvider);
    Thread thread1 = new Thread(threadForWaitNotify, "Thread1");
    Thread thread2 = new Thread(threadForWaitNotify, "Thread2");

    thread1.start();

    WaitNotify mainObject = new WaitNotify();
    mainObject.sleep(Thread.currentThread().getName(), 2000);

    thread2.start();
  }

}
