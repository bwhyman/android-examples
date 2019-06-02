# Service
https://developer.android.google.cn/guide/components/services.html  
https://developer.android.google.cn/guide/components/bound-services.html  
https://developer.android.google.cn/training/run-background-service/create-service.html  

自定义服务，封装操作值  
重写onCreate()方法，创建子线程执行操作  
自定义Binder子类，重写onBind()方法  
重写onStartCommand()方法，接收初始化参数  
修改项目配置，注册自定义服务  

在activity中，自定义类实现ServiceConnection接口  
基于自定义ServiceConnection服务连接类获取绑定对象  
与服务互交，完成操作  