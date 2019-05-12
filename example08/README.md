# Appbar & Toolbar
预使用功能丰富的appbar/toolbar，需先关闭android自带的title/actionbar  
自定义无title/actionbar样式的主题  
在AndroidManifest配置中引入自定义主题  
自定义独立的appbar布局文件，注意命名空间  
在activity layout中引入(类似JSP的include)  
在activity中获取toolbar对象，可动态修改各种属性  
动态置于ActionBar，开启左箭头(可选)等等  

https://developer.android.google.cn/training/appbar
# & Menu
 创建menu资源目录  
 创建menu布局文件  
 设置item title，icon等属性
  - app:showAsAction属性: always, collapseActionView, ifRoom, never, withText

重写activity onCreateOptionsMenu()方法，加载menu布局  
重写activity onOptionsItemSelected()方法，监听item点击事件  

https://developer.android.google.cn/guide/topics/ui/menus