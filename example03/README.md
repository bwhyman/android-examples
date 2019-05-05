# UI-Events
#### IDs
后端仅基于ID名称获取组件，无法基于不同布局文件区分组件ID，也无法区分组件类型。调用到不是当前布局上组件，运行时才能发现错误。
因此，ID的名称必须能够体现具体的完整的信息，从而避免出错。
较好的命名方法，布局类型_布局名称_组件类型_组件名称  
findViewById()
### Events
理解Callback模式，理解Android中Callback的设计与使用  
理解掌握2种实现监听的方法  
Input Events & Event Listeners  
View.OnClickListener: onClick()  
EditText: TextChangedListener
View.OnLongClickListener: onLongClick()  
View.OnFocusChangeListener: onFocusChange()  
View.OnTouchListener: onTouch()  
View.OnKeyListener: onKey()  

### Examples
内容：控件对象的获取，控件的相应事件监听器。  
要求：接收EditText的输入，点击button后将输入结果显示在TextView，并使Button变为不可用状态。  

