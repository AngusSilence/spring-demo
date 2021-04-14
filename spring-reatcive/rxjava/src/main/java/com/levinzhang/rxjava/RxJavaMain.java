package com.levinzhang.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaMain {
    public static void main(String[] args) throws InterruptedException {
            Flowable.just(1,3,4,5)
                .map(i->i*2)
                .subscribe(System.out::println);


        // Schedulers
        Flowable.fromCallable(()->{
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"11");
            return "Test";
        })
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {
                    System.out.println(Thread.currentThread().getName()+"22");
                    System.out.println(s);
                }
                );
//
        Thread.sleep(3000);



    }
}
