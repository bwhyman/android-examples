# ItemTouchHelper
ItemTouchHelper，用来协助处理RecyclerView中item的移动/滑动/拖拽等操作  
Callback内部类(非回调接口)，继承实现各种操作  
重写getMovementFlags()方法，决定拖拽滑动在哪个方向是被允许  
重写onSwiped()方法，Item横向滑动时回调，删除item  
DefaultItemAnimator类定义recyclerView item操作动画  
adapter添加/移除item必须通过notifyItemInserted()/notifyItemRemoved()方法，才有动画效果  
互交。重写onSwiped()方法可删除item，但无法删除数据，通过自定义回调接口实现  
依然通过SwipeRefreshLayout下拉刷新