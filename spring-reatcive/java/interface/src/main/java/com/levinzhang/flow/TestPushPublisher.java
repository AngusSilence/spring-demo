package com.levinzhang.flow;

import java.util.concurrent.Flow;

public class TestPushPublisher implements Flow.Publisher {
    private Flow.Subscriber subscriber;

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        this.subscriber = subscriber;
        subscriber.onSubscribe(new Flow.Subscription() {
            @Override
            public void request(long n) {

            }

            @Override
            public void cancel() {

            }
        });
    }

    public void init(){
        Runnable runnable = () -> {
            for(int i=0;i<Integer.MAX_VALUE;i++){
                System.out.println("Emit："+i);
                if(subscriber!=null){
                    subscriber.onNext(i);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();

    }
}
