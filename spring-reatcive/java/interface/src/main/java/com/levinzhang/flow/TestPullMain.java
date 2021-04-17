package com.levinzhang.flow;

import java.util.concurrent.Flow;

public class TestPullMain {
    public static void main(String[] args){
        TestPullPublisher publisher = new TestPullPublisher();
        publisher.subscribe(new Flow.Subscriber() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                subscription.request(3);
            }

            @Override
            public void onNext(Object item) {
                System.out.println("We get:"+item);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
