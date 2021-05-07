import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestFutureTask {

    private static class call implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
			
            Thread.sleep(2000);
			
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum = sum + i;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        FutureTask<Integer> myTask = new FutureTask<Integer>(new call());

        new Thread(()->{
            try {
                System.out.println("Thread execution done. Result: " + myTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(myTask).start();
        System.out.println("Thread execution started.");

        try {
            System.out.println(myTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}