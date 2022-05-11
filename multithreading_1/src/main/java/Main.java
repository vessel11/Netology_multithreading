

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ThreadGroup group = new ThreadGroup("group");

        Thread thr1 = new MyThread(group, "П1");
        Thread thr2 = new MyThread(group, "П2");
        Thread thr3 = new MyThread(group, "П3");
        Thread thr4 = new MyThread(group, "П4");

        thr1.start();
        thr2.start();
        thr3.start();
        thr4.start();

        Thread.sleep(15000);
        group.interrupt();
    }
}