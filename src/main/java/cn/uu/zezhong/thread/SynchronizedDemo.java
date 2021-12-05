package cn.uu.zezhong.thread;

/**
 * synchronize demo
 * @author sadsa
 */
public class SynchronizedDemo {

    public static int cnt;

    /**
     * synchronized is a reentrant mutex.
     * It's implemented by the object-head, storing the thread ID in the mark word.
     * When a thread trying to get the lock, it will check the lock condition
     * and the thread ID first. If the thread ID is the same, this thread still
     * get the lock, otherwise use CAS to change to ID. If fails, the lock will
     * upgrade.
     */
    public static synchronized void reenterPrint(){
        System.out.println("Inside the reenterPrint function!");
        if (cnt++ < 10){
            reenterPrint();
        }
    }


    public static void main(String[] args) {
        reenterPrint();
    }
}
