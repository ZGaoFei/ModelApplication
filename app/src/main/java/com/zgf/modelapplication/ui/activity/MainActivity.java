package com.zgf.modelapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zgf.modelapplication.R;
import com.zgf.modelapplication.base.BaseActivity;
import com.zgf.modelapplication.event.AbsEvent;
import com.zgf.modelapplication.event.IntEvent;
import com.zgf.modelapplication.event.StringEvent;
import com.zgf.modelapplication.model.Tea;
import com.zgf.modelapplication.net.ApiService;
import com.zgf.modelapplication.net.ModelApiConnection;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private TextView tvShow;
    private Button btSkip;
    private Button btSkipLogger;
    private Button btSkipButterKnife;
    private Button btDagger2;
    private Button btDagger2Two;
    private Button btJunit;
    private Button btPickView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();

        EventBus.getDefault().register(this);

//        getTea(); // ok
//        getCosmeticTrialRxjava(); // no
//        getCosmeticTrialRxjava2();
//        getTea2(); // ok
//        getTea3(); // ok
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initView() {
        tvShow = (TextView) findViewById(R.id.tv_show);
        btSkip = (Button) findViewById(R.id.bt_skip);
        btSkipLogger = (Button) findViewById(R.id.bt_skip_logger);
        btSkipButterKnife = (Button) findViewById(R.id.bt_skip_butter_knife);
        btDagger2 = (Button) findViewById(R.id.bt_skip_dagger2);
        btDagger2Two = (Button) findViewById(R.id.bt_skip_dagger2_two);
        btJunit = (Button) findViewById(R.id.bt_skip_junit);
        btPickView = (Button) findViewById(R.id.bt_skip_pick_view);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                startActivity(intent);
            }
        });

        btSkipLogger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoggerTestActivity.class);
                startActivity(intent);
            }
        });

        btSkipButterKnife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ButterKnifeTestActivity.class);
                startActivity(intent);
            }
        });

        btDagger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DaggerTestActivity.class);
                startActivity(intent);
            }
        });

        btDagger2Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DaggerTestTwoActivity.class);
                startActivity(intent);
            }
        });

        btJunit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JunitTestActivity.class);
                startActivity(intent);
            }
        });

        btPickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PickViewActivity.class);
                startActivity(intent);
            }
        });
    }

    // =============== 测试 retrofit + okhttp + rxjava ====================

    /**
     * retrofit2.0 相较与1.0的改动比较大，注意区分
     *
     * getRx() 返回来的对象是Observable对象，
     * 这个是rx.Observable包下的不要错认为是io.reactivex.Observable
     *
     * rx.Observable 是 rxjava 1.1.5 包下面的东西
     * io.reactivex.Observable 是 rxjava 2.0.1 包下面的东西
     *
     * 这里 rxjava 导入重复
     * 经过测试发现 rxjava 1.1.5 是导入 retrofit2.adapter.rxjava 包时导入的
     *
     * 测试发现，将 rxjava 和 rxandroid 包去掉仍然可以使用
     * 因为 retrofit2.adapter.rxjava 已经将 rxjava 包导入
     * 并且不会出现导包重复的异常
     * 如果导入 rxandroid 包，会自动导入 rxjava 包（rxandroid 自带 rxjava 包）
     *
     */
    private void getCosmeticTrialRxjava() {
        ModelApiConnection
                .getClient()
                .getRx("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Tea>() {
                    @Override
                    public void accept(Tea tea) throws Exception {
                        Log.e("====code===", "=======" + tea.getErrorMessage());
                        Log.e("====size===", "=======" + tea.getData().size());
                    }
                });
    }

    private void getTea3() {
        ModelApiConnection
                .getClient()
                .getRx2("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow")
                .subscribeOn(rx.schedulers.Schedulers.io())
                .subscribe(new rx.functions.Action1<Tea>() {
                    @Override
                    public void call(Tea tea) {
                        Log.e("====code===", "=======" + tea.getErrorMessage());
                        Log.e("====size===", "=======" + tea.getData().size());
                    }
                });
    }

    private void getTea2() {
        ModelApiConnection
                .getClient()
                .getRx2("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow")
                .subscribeOn(rx.schedulers.Schedulers.io())
                .subscribe(new rx.Observer<Tea>() {
                    @Override
                    public void onCompleted() {
                        Log.e("==c====", "========");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("===e===", "======" + e.getMessage());
                    }

                    @Override
                    public void onNext(Tea tea) {
                        Log.e("====code===", "=======" + tea.getErrorMessage());
                        Log.e("====size===", "=======" + tea.getData().size());
                    }
                });
    }

    /**
     * 同样是导包的问题
     */
    private void getCosmeticTrialRxjava2() {
        ModelApiConnection
                .getClient()
                .getRx("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Tea>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Tea value) {
                        Log.e("====code===", "=======" + value.getErrorMessage());
                        Log.e("====size===", "=======" + value.getData().size());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void getTea() {
        ApiService apiService = ModelApiConnection.getClient();
        Call<Tea> teaCall = apiService.get("b4f4ee31a8b9acc866ef2afb754c33e6", "json", "news.getSlideshow");
        teaCall.enqueue(new Callback<Tea>() {
            @Override
            public void onResponse(Call<Tea> call, Response<Tea> response) {
                Log.e("==code====", "======" + response.code());
                Log.e("==string====", "======" + response.body().getData().size());
            }

            @Override
            public void onFailure(Call<Tea> call, Throwable t) {
                Log.e("===onFailure===", "======" + t.getMessage());
            }
        });
    }

    // ================ 测试Rxjava ===============

    private void test() {
        Observable.just("0000")
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return 0;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void testTwo() {
        Flowable.just("00000")
                .subscribeOn(Schedulers.io())
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) throws Exception {
                        return 0;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("======", "======" + integer);
                    }
                });
    }

    private void testOne() {
        Observable stringObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("1");
                e.onNext("2");
                e.onComplete();
            }
        });

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) throws Exception {

            }
        };

        Subscriber subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        stringObservable.subscribe(consumer);
        stringObservable.subscribe(observer);

    }

    // ============== 测试EvenBus =================

    /**
     * 方法命名随意
     * 发送只是根据消息的对象(即传进去的对象，如：StringEvent)进行区分
     * 因此没有必要创建一个泛型的消息类，需要每一个事件创建一个对象
     *
     * ThreadMode：ThreadMode.POSTING、ThreadMode.MAIN、ThreadMode.BACKGROUND、ThreadMode.ASYNC
     *
     * ThreadMode.POSTING：默认使用该模式，表示该方法会在当前发布事件的线程执行
     * ThreadMode.MAIN：表示会在UI线程中执行
     * ThreadMode.BACKGROUND：若当前线程非UI线程则在当前线程中执行，否则加入后台任务队列，使用线程池调用
     * ThreadMode.ASYNC：加入后台任务队列，使用线程池调用
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStringEvent(StringEvent event) {
        tvShow.setText(event.getEvent());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStringEvent2(IntEvent event) {
        Log.e("========", "=======" + event.getEvent());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAbsEvent(AbsEvent<String> event) {
        Log.e("=====string===", "=======" + event.getEvent());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAbsEvent2(AbsEvent<Integer> event) {
        Log.e("====int====", "=======" + event.getEvent());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAbsEvent3(AbsEvent<StringEvent> event) {
        Log.e("====string====", "=======" + event.getEvent().getEvent());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAbsEvent4(AbsEvent<IntEvent> event) {
        Log.e("====int====", "=======" + event.getEvent().getEvent());
    }

}
