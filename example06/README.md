# RecyclerView
https://developer.android.google.cn/guide/topics/ui/layout/recyclerview
### create RecyclerView
androidx.recyclerview.widget.RecyclerView  
不包含在基本组件中，引入后自动下载依赖  
创建RecyclerView中item布局样式  
创建实体类news封装数据  
创建自定义adapter  
在adapter中创建viewholder  
adapter添加news集合属性   
添加有参构造函数  
adapter继承RecyclerView.Adapter，并声明VM泛型为自定义的VM类型  
重写getItemCount()方法返回集合元素数量，即需要渲染的item数量  
重写onBindViewHolder()方法，当视图item滚动，绑定对应数据到item中的相应控件  
重写onCreateViewHolder()方法，声明item布局样式，并将view item对象，交由viewholder持有  
RecyclerView默认不包含点击事件及点击动画，需手动实现  
### OnItemClicklistener
在item布局样式中添加点击波纹动画  
在adapter onBindViewHolder()方法为item view设置点击监听  
高级，自定义接口，实现在activity等的点击监听
### SwipeRefreshLayout
添加下拉刷新功能，将RecyclerView嵌入SwipeRefreshLayout  
通过Handler模拟耗时操作，添加元素  

