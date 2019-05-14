# DrawerLayout & NavigationView
基于DrawerLayout创建抽屉布局，从内向外逐层构建  
引入com.google.android.material:material:1.0.0依赖  
创建基本主内容布局，声明layout_behavior属性避免被appbar覆盖  
可声明使用showIn属性，增加预览效果  
创建appbar布局，声明toolbar，引入主内容布局(需声明使用noactionbar样式)  
基于menu创建抽屉导航选项  
基于DrawerLayout创建抽屉布局，引入appbar布局，NavigationView引用menu导航  
可选创建抽屉头部布局，并引入到NavigationView属性(自定义了头部背景样式)  
Activity代码中添加actionbar  
监听navigationView OnNavigationItemSelectedListener  
任意item被点击，关闭抽屉  

抽屉与下导航，选一种作为app主布局即可  
