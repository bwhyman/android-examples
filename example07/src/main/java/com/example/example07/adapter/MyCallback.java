package com.example.example07.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MyCallback extends ItemTouchHelper.Callback {
    private static final String TAG = "MyCallback";
    private AdapterCallback adapterCallback;

    public interface AdapterCallback {
        void remove(int position);
    }

    public MyCallback(AdapterCallback adapterCallback) {
        this.adapterCallback = adapterCallback;
    }

    /**
     * 该方法返回一个整数，用来指定拖拽和滑动在哪个方向是被允许的。
     * 在其中使用makeMovementFlags(int dragFlags, int swipeFlags)返回，
     * 该方法第一个参数用来指定拖动，第二个参数用来指定滑动。
     * ItemTouchHelper.UP  //滑动拖拽向上方向
     * ItemTouchHelper.DOWN//向下
     * ItemTouchHelper.LEFT//向左
     * ItemTouchHelper.RIGHT//向右
     * ItemTouchHelper.START//依赖布局方向的水平开始方向
     * ItemTouchHelper.END//依赖布局方向的水平结束方向
     *
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        // Log.i(TAG, "" + "getMovementFlags");
        //允许上下的拖动
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //只允许从右向左侧滑
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(0, swipeFlags);
    }

    /**
     * onMove方法是拖拽的回调，参数viewHolder是拖动的Item，target是拖动的目标位置的Item,
     * 该方法如果返回true表示切换了位置，反之返回false。
     *
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

        return false;
    }

    /**
     * onSwiped方法为Item滑动回调，viewHolder为滑动的item，direction为滑动的方向。
     *
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        switch (direction) {
            case ItemTouchHelper.LEFT:
                adapterCallback.remove(viewHolder.getAdapterPosition());
        }

    }
}
