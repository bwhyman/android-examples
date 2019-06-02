# Capture
声明外存储写入权限  
在配置中通过screenOrientation属性，将Activity强制设为横向或纵向屏幕，防止手机晃动后activity重置  
在xml资源目录下，创建共享目录配置  
在项目配置注册provider，并引用共享配置  

在activity自定义照相请求码，写入权限码  
在公共空间/DCIM/Camera/下，创建一个指定名称的图片文件，用于保存照片  
创建拍照方法，基于FileProvider获取图片URI地址  
启动需要结果的照相intent，封装请求吗及强制文件存储的URI地址    
重写onActivityResult()方法，基于请求码判断返回的执行请求  
未防止OOM，将图片按1/4渲染  

Android6以后，要求运行时动态申请权限(类似iOS)  
https://developer.android.google.cn/training/permissions/requesting  
重写onRequestPermissionsResult()方法，在用户授权后执行拍照方法  
刷新相册(可选)  

模拟器，可通过按住alt+鼠标移动镜头，wasd控制方向  
# Gallery
自定义调用相册请求码  
以ACTION_PICK启动intent  
重写onActivityResult()方法获取返回结果  
基于ContentResolver以及返回的图片URI地址，创建bitmap  
按1/4渲染    

 