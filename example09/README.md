# Navigation
在module gradle配置引入navigation-fragment，navigation-ui依赖  
(不直接声明依赖，创建导航视图文件时也可自动引入，但AS会卡住假死)  
创建多个Fragment及布局  
创建navigation资源目录，创建nav_graph导航视图文件  
在导航视图中引入fragment，声明导航规则  
(也可设置fragment的独立global action)  
修改activity_main布局，添加NavHostFragment容器，，引用导航视图，声明必须属性   

# BottomNavigationView
com.google.android.material.bottomnavigation.BottomNavigationView  
自动包含选中状态样式：图标加亮+显示字体，区别未选中其他item  
创建menu文件，声明Navigation所需item，图标及文字，绑定Navigation中的fragment  
在activity布局声明引入底部导航BottomNavigationView控件，引用menu  
在activity中获取NavController对象及并绑定BottomNavigationView对象