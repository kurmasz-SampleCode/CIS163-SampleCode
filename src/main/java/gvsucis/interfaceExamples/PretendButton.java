package gvsucis.interfaceExamples;

import java.util.ArrayList;

public class PretendButton {

  public interface ButtonListener {
    public void doIt();
  }

  private ArrayList<ButtonListener> listeners = new ArrayList<ButtonListener>();

  public void addListener(ButtonListener l) {
    listeners.add(l);
  }

  public void click() {
    for (ButtonListener l : listeners) {
      l.doIt();
    }
  }

  static class MessageButtonListener implements ButtonListener {
    public void doIt() {
      System.out.println("You clicked me!");
    }
  }

  static class CountingButtonListener implements ButtonListener {

    private int count = 0;

    public void doIt() {
      count++;
    }

    public int getCount() {
      return count;
    }
  }

  public static void main(String[] args) {

    PretendButton button = new PretendButton();

    button.addListener(new MessageButtonListener());

    CountingButtonListener counter = new CountingButtonListener();
    button.addListener(counter);

    // This "anonymous inner class" syntax tries to make using interfaces for 
    // listeners less obnoxious.  It's still a lot of typing :)
    button.addListener(new ButtonListener() {
      public void doIt() {
        System.out.println("Another click listener!");
      }
    });

    button.click();
    button.click();
    button.click();
    System.out.printf("The button was clicked %d times.\n", counter.getCount());

  }

}