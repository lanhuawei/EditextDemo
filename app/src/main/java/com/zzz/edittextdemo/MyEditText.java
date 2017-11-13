package com.zzz.edittextdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by 请叫我张懂 on 2017/11/12.
 */

public class MyEditText extends android.support.v7.widget.AppCompatEditText {
    private FocusViewAdapter mFocusViewAdapter;


    public void setAdapter(FocusViewAdapter mFocusViewAdapter) {
        this.mFocusViewAdapter = mFocusViewAdapter;
    }

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        if (null != mFocusViewAdapter && MotionEvent.ACTION_DOWN == event.getAction()) {
//            View currentView = mFocusViewAdapter.getCurrentView();
//            if (isHide(currentView, event)) {
//                Log.i("TAG", "收起键盘");
//            } else {
//                Log.i("TAG", "打开键盘");
//            }
//        }
//        return super.dispatchTouchEvent(event);
//    }
//
//    /**
//     * 是否收起键盘
//     *
//     * @param currentView
//     * @param event
//     * @return
//     */
//    private boolean isHide(View currentView, MotionEvent event) {
//        boolean result = false;
//        if (null != currentView && currentView instanceof MyEditText) {
//            //左上
//            int[] location = {0, 0};
//            currentView.getLocationInWindow(location);
//            int left = location[0];
//            int top = location[1];
//            int bottom = top + currentView.getHeight();
//            int right = left + currentView.getWidth();
//            Log.i("tag", "isHide: left --> " + left + " top --> " + top +" bottom --> " + bottom+" right --> " + right);
//            Log.i("tag", "isHide: event.getX() --> " + event.getX() + " event.getY() --> " + event.getY());
//
//            if (event.getX() >= left && event.getX() <= right &&
//                    event.getY() >= top && event.getY() <= bottom) {
//                result = false;
//            } else {
//                result = true;
//            }
//        }
//        return result;
//    }

    public abstract static class FocusViewAdapter {
        public abstract View getCurrentView();
    }
}
