package synchronizers;

public class Group implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Группа сформирована");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
