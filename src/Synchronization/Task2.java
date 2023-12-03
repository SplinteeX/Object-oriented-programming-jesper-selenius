package Synchronization;
import java.util.ArrayList;
public class Task2<T> {
    private final ArrayList<T> list = new ArrayList<>();
    public synchronized void addElement(T element) {
        list.add(element);
    }
    public synchronized int getSize() {
        return list.size();
    }
    public synchronized void removeElement(T element) {
        list.remove(element);
    }
    public static void main(String[] args) {
        Task2<String> threadSafeList = new Task2<>();
        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                threadSafeList.addElement("Element" + i);
            }
        });
        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                threadSafeList.removeElement("Element" + i);
            }
        });
        Thread queryThread = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Size of the collection: " + threadSafeList.getSize());
        });
        addThread.start();
        removeThread.start();
        queryThread.start();
    }
}
