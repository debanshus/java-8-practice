package thread;

class ThreadForInterrupt
    implements Runnable {

  @Override
  public void run() {
    String threadName = Thread.currentThread().getName();
    for (int i = 0; i < 10; i++) {
      System.out.println(threadName + " printing " + i);
      if (Thread.interrupted()) {
        System.out.println(threadName + " interrupted here");
      }
    }
  }
}

public class InterruptDemo {

  public static void main(String[] args) {
    ThreadForInterrupt threadForInterrupt = new ThreadForInterrupt();
    Thread thread = new Thread(threadForInterrupt, "ThreadForWaitNotify");
    thread.start();

    System.out.println("Calling interrupt on " + thread.getName());
    thread.interrupt();
  }

}
