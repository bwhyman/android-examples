# UI
#### Dimension:
dp，像素密度，设备屏幕尺寸无关的，描述控件间距离等  
sp，描述字体大小  
px，像素，相对的绝对单元，与CSS相似等，图片等    

#### Layouts
##### Relative Layout & Linear Layout
理解Linear与Relative布局的区别；主要属性；相同属性与不同属性

android:orientation，LinearLayout方向

android:layout_gravity，控件本身的显示位置。仅在LinearLayout内有效，受android:orientation属性影响

android:gravity，控件内内容的显示位置。

android:layout_weight，比重，android:orientation相应方向的值需设为0dp。

要求：完成基于orientation 排列方向及weight比重的经典布局

##### ConstraintLayout
与Relative的区别：仅对相同位置/方向进行相对的约束

https://developer.android.google.cn/training/constraint-layout/index.html

#####	Tutorial
https://developer.android.com/guide/topics/ui  
https://developer.android.google.cn/guide/topics/ui/declaring-layout.html
