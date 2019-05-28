# Connecting to the Network
### Network Request/Response & Image Resources
添加请求权限  
Android 9以后，要求网络请求必须为HTTPS加密请求，不便于测试，创建配置关闭该功能  
创建自定义application类，配置  
引入Retrofit框架依赖  
创建实体类   
创建封装响应数据的DTO类  
创建网络请求接口，声明与后端对应的restful请求地址，图片资源请求处理  
构造封装retrofit对象，声明缓存，请求相对根路径，转换器，拦截器等配置  
构造封装请求接口类型对象，并对外暴露  
编写布局文件  
监听事件，调用retrofit完成异步的网络请求，并将结果渲染到视图  

### Databinding & ViewModel & BindingAdapter
添加ViewModel LiveData依赖，声明启动Databinding  
创建Recyclerview item布局，绑定实体对象，自定义图片网络地址属性  
创建自定义图片绑定适配器，基于动态绑定的图片网络地址，下载图片并渲染  
创建ViewModel，声明绑定生命周期的可观测数据，新闻集合  
创建加载方法，通过网络加载数据，并更新可观测数据  
修改layout布局，绑定VM，添加recycleview  
创建recycleview的adapter，新闻集合属性，绑定item  
修改activity代码，构造recycleview，绑定VM，绑定生命周期，监听网络返回的数据，通知adapter更新  

### Post Request
在接口添加post请求  
创建第三个activity，实现2个输入框，1个button  
实现当点击button时，调用post请求向服务器发送数据  
 重写SecActivity onStart()方法，调用VM中的网络数据加载方法，确保从暂停状态恢复，重新加载  