package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public  class ThreadPractice {


    ThreadLocal<String> test = new ThreadLocal<>();

    void  testThread(int i, String hello) {

       ExecutorService executorService = new ScheduledThreadPoolExecutor(5);

        Runnable runnable = ()-> {
                for (int j = 0; j < i; j++) {
                    test.set(test.get()  +" "+ i+ " " + hello);
                    System.out.println(j + test.get());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
        executorService.submit(runnable);

    }


    public static void main(String[] args) {
        ThreadPractice threadPractice = new ThreadPractice();
        threadPractice.testThread(5, "hi");
        threadPractice.testThread(5, "hello");


    }
}
