package others;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
  
  class Task extends TimerTask {

    @Override
    public void run() {

      while(true) {
        try {
          Thread.sleep(1000);
          System.out.println("I'm still running");
        }
        catch (InterruptedException e) {
          ;
        }
      }
    }
  }
  

  public static void main(String[] args) {
    TimerTest t = new TimerTest();
    t.test();
  }
  
  public void test() {

    Timer timer = new Timer();
    Task task = new Task();
    timer.schedule(task, 0 );
    timer.cancel();
    System.out.println("timer:" +timer);
  }
}
