# Room
https://developer.android.google.cn/training/data-storage/room/index.html
### Query
引用Room依赖  
SQLite数据库，SQLite操作无需系统权限  
启动/引入数据绑定，VM，等  
自定义引入application备用  
创建实体类  
创建操作实体类的DAO层接口  
创建数据库工厂，封装构造过程，暴露DAO接口(代理类)  
创建VM，从数据库获取数据，加载到observer对象  
创建item layout，recyclerview adapter，完成基本绑定操作  
修改activity代码，完成初始化，数据监听等操作  


### Insert
创建VM，声明绑定数据，声明添加方法，调用接口实现数据的插入  
视图双向绑定VM数据，执行VM插入方法  

创建展示详细信息activity，修改adapter，绑定item点击监听，传递被点击item对应的数据ID参数跳转  
展示详细信息  
### Snackbar  
