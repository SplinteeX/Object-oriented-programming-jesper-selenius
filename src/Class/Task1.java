package Class;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        // Create an instance of the Television class
        Random random = new Random();
        Television tv = new Television();

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);
            for (int channel = 1; channel <= random.nextInt(3) + 3; channel++) {
                tv.setChannel(channel);
                System.out.println("Watching channel " + tv.getChannel());
            }
            tv.sleep(1);
        }
    }
}

class Television {
    private int channel;
    private int day;

    public Television() {
        this.channel = 1;
        this.day = 1;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void sleep(int days) {
        this.day += 1;
        System.out.println("Fall asleep");
    }
}
