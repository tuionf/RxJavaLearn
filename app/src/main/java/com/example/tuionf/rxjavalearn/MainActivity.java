package com.example.tuionf.rxjavalearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxJava rxJava = new RxJava();
        rxJava.observable.subscribe(rxJava.observer);

        //1. 不带任何参数的subscribe() 表示下游不关心任何事件,上游尽管发你的数据
        rxJava.observable.subscribe();

        //2.带有一个Consumer参数的方法表示下游只关心onNext事件, 其他的事件我假装没看见
        rxJava.observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "onNext: " + integer);
            }
        });

        //3. 接收onNext 和 onError方法
        rxJava.observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "onNext: " + integer);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d(TAG, "onError: ");
            }
        });

        // 4. 三个事件  其他类似
        rxJava.observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "onNext: " + integer);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.d(TAG, "onError: ");
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Log.d(TAG, "onComplete: ");
            }
        });

    }
}
