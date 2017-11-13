package com.zzz.edittextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author 请叫我张懂
 */
public class MainActivity extends AppCompatActivity {
    private EditTextPlus etLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLogin = (EditTextPlus) this.findViewById(R.id.et_login);
        etLogin.setOnDeleteListener(new EditTextPlus.OnDeleteListener() {
            @Override
            public void onDelete() {
                Log.i("tag", "onDelete");
            }
        });
        etLogin.setEditHintText("hint测试");
        etLogin.setHeadText("测试");
        etLogin.setEditTextColor(R.color.EditTextPlusDefaultTextColor);
        etLogin.setOnEditorOptActionListener(new EditTextPlus.OnEditorOptActionListener() {
            @Override
            public void onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_NEXT:
                        Log.i("tag", "onEditorAction: IME_ACTION_NEXT");
                        break;
                    default:
                        Log.i("tag", "onEditorAction: default");
                        break;
                }
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            View currentView = getCurrentFocus();
            if (isHide(currentView, event)) {
                Log.i("TAG", "收起键盘");
                keyboardutils.closeKeybord((EditText) currentView, MainActivity.this);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    /**
     * 是否收起键盘
     *
     * @param currentView
     * @param event
     * @return
     */
    private boolean isHide(View currentView, MotionEvent event) {
        boolean result = false;
        if (null != currentView && currentView instanceof EditText) {
            //左上
            int[] location = {0, 0};
            currentView.getLocationInWindow(location);
            int left = location[0];
            int top = location[1];
            int bottom = top + currentView.getHeight();
            int right = left + currentView.getWidth();
            Log.i("tag", "isHide: left --> " + left + " top --> " + top + " bottom --> " + bottom + " right --> " + right);
            Log.i("tag", "isHide: event.getX() --> " + event.getX() + " event.getY() --> " + event.getY());

            if (event.getX() >= left && event.getX() <= right &&
                    event.getY() >= top && event.getY() <= bottom) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }
}
