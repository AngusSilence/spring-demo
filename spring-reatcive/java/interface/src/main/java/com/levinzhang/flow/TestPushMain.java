package com.levinzhang.flow;

import java.util.concurrent.Flow;

public class TestPushMain {
    public static void main(String[] arg) throws InterruptedException {
        TestPushPublisher pushPublisher = new TestPushPublisher();
        pushPublisher.init();
        Thread.sleep(2000);
        pushPublisher.subscribe(new Flow.Subscriber() {
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                System.out.println("Begin Subscribe");
            }

            @Override
            public void onNext(Object item) {
                System.out.println("We get"+item);

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
