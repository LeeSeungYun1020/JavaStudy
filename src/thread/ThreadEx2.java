package thread;

import javax.swing.*;

public class ThreadEx2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int i = 10;
                while (i != 0 && !isInterrupted()) {
                    System.out.println(i--);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
                System.out.println("카운트 종료");
            }
        };
        thread1.start();
        String input = JOptionPane.showInputDialog("Input");
        System.out.println(input);
        thread1.interrupt();
        System.out.println("isInterrupted(): " + thread1.isInterrupted());
    }
}
