package thread;

public class ThreadEx1 {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup group1 = new ThreadGroup("Group1");
        ThreadGroup group2 = new ThreadGroup("Group2");
        ThreadGroup subGroup1 = new ThreadGroup(group1, "SubGroup1");
        group1.setMaxPriority(2);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        };

        new Thread(group1, r, "thread1").start();
        new Thread(subGroup1, r, "thread2").start();
        new Thread(group2, r, "thread3").start();

        System.out.println("List of ThreadGroup: " + main.getName());
        System.out.println("Active ThreadGroup: " + main.activeGroupCount());
        System.out.println("Active Thread: " + main.activeCount());
        main.list();
    }
}
