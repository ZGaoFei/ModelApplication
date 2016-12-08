#### 模型项目

    说明：
        本项目意在测试一些新的知识的使用，属于最低级的测试，没有任何的封装。其中包括了
        rxjava, retrofit, rxAndroid, okhttp, eventbus, butterKnife, logger, dagger
        目前包含这些，仅是简单的使用和了解。
        以后准备添加的还有一些图片处理的库，如：
        glide, fresco
        如果有新的知识，会持续更新。敬请期待……

---
> rxjava + retrofit + rxandroid + okhttp

    问题：
        retrofit2.0 相较与1.0的改动比较大，注意区分

        rx.Observable 是 rxjava 1.1.5 包下面的东西
        io.reactivex.Observable 是 rxjava 2.0.1 包下面的东西

        如果导入全部的四个包时，会报导包重复问题，需要在gradle文件里做处理
        经过测试发现 rxjava 1.1.5 是导入 retrofit2.adapter.rxjava 包时导入的
        测试发现，将 rxjava 和 rxandroid 包去掉仍然可以使用
        因为 retrofit2.adapter.rxjava 已经将 rxjava 包导入
        并且不会出现导包重复的异常
        如果导入 rxandroid 包，会自动导入 rxjava 包（rxandroid 自带 rxjava 包）

> eventbus

    回调的消息方法随意命名（尽量见名知意）
    发送只是根据消息的对象(即传进去的对象，如：StringEvent)进行区分
    因此没有必要创建一个泛型的消息类，需要每一个事件创建一个对象

    hreadMode：ThreadMode.POSTING、ThreadMode.MAIN、ThreadMode.BACKGROUND、ThreadMode.ASYNC
    ThreadMode.POSTING：默认使用该模式，表示该方法会在当前发布事件的线程执行
    ThreadMode.MAIN：表示会在UI线程中执行
    ThreadMode.BACKGROUND：若当前线程非UI线程则在当前线程中执行，否则加入后台任务队列，使用线程池调用
    ThreadMode.ASYNC：加入后台任务队列，使用线程池调用

> logger

    logger是一个非常个性的log打印工具
    完全不需要进行大量的配置，直接可以拿来使用，非常方便

> butterknife

    这是一个专门用于布局，点击事件和相应的资源文件的依赖注入库
    在设置时，不可以将view设置为 private 或者 static 类型

> dagger2

    同样是一个依赖注入的库，面向的是方法，类，接口等

    总共分为 @Inject @Module @Provides @Component和另外两个
    @Inject：请求依赖(用在构造函数，域或方法)。需要注入的方法。
    @Module：用于类，该类的方法提供依赖。作为实例对象的容器。
    @Provides：用于@Module注解的类中的方法。标注能够提供实例化对象的方法。
    @Component：是模块和注入之间的接口。作为桥梁，注入对象的通道。

    在 Component 中需要标明 Module 和需要注入的 Activity
    在编译的时候会自动生成 Dagger<Component name/> 类

    如果在一个 Activity 中需要添加多个 Module 时，
    可以在 Component 的 @Component(modules = {TestModule.class, SimpleModule.class}) 中添加

> JUnit 和 Mock 构成单元测试

