package com.levinzhang.flow;

import java.util.concurrent.Flow;

public class TestPullPublisher implements Flow.Publisher<Integer> {

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        System.out.println("");
        subscriber.onSubscribe(new Flow.Subscription() {
            @Override
            public void request(long n) {
                for(int i=0;i<n;i++){
                    subscriber.onNext(i);
                }
            }

            @Override
            public void cancel() {

            }
        });
    }
}
