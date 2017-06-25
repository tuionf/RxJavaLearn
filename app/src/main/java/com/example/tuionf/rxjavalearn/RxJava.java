package com.example.tuionf.rxjavalearn;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by tuion on 2017/6/25.
 */

public class RxJava {

    private static final String TAG = "RxJava";

    //上游
    Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
        @Override
        public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
            emitter.onNext(4);
            Log.e(TAG, "subscribe:---4  --5 " );
            emitter.onNext(5);

        }
    });

    //创建一个下游 Observer
    Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.e(TAG, "onSubscribe: " );
        }

        @Override
        public void onNext(Integer value) {
            Log.d(TAG, "onNext: "+value);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "onError: " );
        }

        @Override
        public void onComplete() {
            Log.e(TAG, "onComplete: " );
        }
    };
}
