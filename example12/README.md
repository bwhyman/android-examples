# DataBinding & ViewModel & LiveData
https://developer.android.google.cn/topic/libraries/data-binding

在项目gradle配置中，启动dataBinding  
添加整合了viewmodel livedata的依赖lifecycle-extensions  

**官方推荐一个activity对应绑定一个ViewModel**  

**基本实现，基于mainactivity**  
创建实体类  
创建自定义viewmodel类  
声明页面数据绑定/生命周期绑定的MutableLiveData类型数据  
创建修改方法，在子线程中修改数据  
修改layout文件，添加数据绑定标签  
绑定自定义的ViewModel类  
在控件，通过表达式绑定数据，或方法  
修改activity代码，获取自定动态创建的binding对象，获取自定义viewmodel对象  
将vm绑定到UI页面  
将绑定数据绑定到activity生命周期    

**整合recycleview的实现，基于secactivity**  
创建实体类，创建VM  
创建更新可观测数据  
初始化时，异步更新可观测数据  
创建方法，异步更新可观测数据  
创建recycleview item布局，绑定实体类中属性  
修改layout，绑定VM，绑定VM中更新方法  
创建自定义adapter，初始化数据集合，重写基本方法  
创建viewholder  
重写onCreateViewHolder()方法，动态创建数据绑定对象  
修改viewholder hold绑定对象  
重写onBindViewHolder()方法，将当前viewholder的binding对象绑定对应的集合数据  

**DiffUtil.Callback**  
自定义DiffUtil.Callback类，重写相关方法，实现更新adapter时的计算依据  
adapter对外提供自己的更新方法  
基于自定义Callback类，实现高效的，仅针对需更新项的，支持动画效果的，动态更新  

修改activity代码，获取binding/viewmodel对象，绑定生命周期等  
初始化recycleview，adapter等  
监听自定义viewmodel中的数据更新，等有更新时，调用adapter提供的更新方法，通知其更新  

## Two-way data binding
双向绑定要比vue复杂。例如，封装在可观测数据内，数据的改变无法直接响应    