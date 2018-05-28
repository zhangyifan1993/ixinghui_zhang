package com.example.zhangyifn.myixinghui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhangyifn.myixinghui.MainActivity;
import com.example.zhangyifn.myixinghui.R;


/**
 * Created by Mr.Z on 15/12/15.
 */
public class MyTitle extends RelativeLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;
    private ImageView back;
    private TextView title;
    private TextView textleft;
    private RelativeLayout backLayout;
    private RelativeLayout right;
    private OnClickListener backOnClickListener;
    private ImageView rightBtn;
    private ImageView rightBtn2;
    private RelativeLayout layout_title;

    private TextView rightTextView;
    private ImageView left_image;

    public MyTitle(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MyTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        mView = LayoutInflater.from(mContext).inflate(R.layout.layout_my_title, this, true);
        layout_title = (RelativeLayout) mView.findViewById(R.id.layout_title);
        backLayout = (RelativeLayout) mView.findViewById(R.id.back_layout);
        back = (ImageView) mView.findViewById(R.id.back_btn);
        left_image = (ImageView) mView.findViewById(R.id.left_image);
        title = (TextView) mView.findViewById(R.id.title_name);
        textleft = (TextView) mView.findViewById(R.id.textleft);
        rightBtn = (ImageView) mView.findViewById(R.id.right_btn);
        rightBtn2 = (ImageView) mView.findViewById(R.id.right_btn2);
        right = (RelativeLayout) mView.findViewById(R.id.right);
        rightTextView = (TextView) mView.findViewById(R.id.right_text);
    }

    public void setRightButton(int backDrawableId, OnClickListener onClickListener) {

        if (backDrawableId != -1) {
            rightBtn.setImageResource(backDrawableId);
        }
        if (onClickListener != null) {
            rightBtn.setVisibility(View.VISIBLE);
            right.setOnClickListener(onClickListener);
        } else {
            rightBtn.setVisibility(View.GONE);
        }

    }

    public void setLeftButton(int backDrawableId, OnClickListener onClickListener) {

        if (backDrawableId != -1) {
            left_image.setImageResource(backDrawableId);
        }
        if (onClickListener != null) {
            left_image.setVisibility(View.VISIBLE);
            left_image.setOnClickListener(onClickListener);
        } else {
            left_image.setVisibility(View.GONE);
        }

    }

    public void setRightButton2(int backDrawableId, OnClickListener onClickListener) {

        if (backDrawableId != -1) {
            rightBtn2.setImageResource(backDrawableId);
        }
        if (onClickListener != null) {
            rightBtn2.setVisibility(View.VISIBLE);
            rightBtn2.setOnClickListener(onClickListener);
        } else {
            rightBtn2.setVisibility(View.GONE);
        }

    }

    /**
     * 隐藏标题
     */
    public void hideTitle() {
        title.setVisibility(View.GONE);
    }

    /**
     * 隐藏右侧按钮
     */
    public void hideRightBtn() {
        right.setVisibility(View.GONE);
    }

    /**
     * 显示右侧按钮
     */
    public void visibleRightBtn() {
        right.setVisibility(View.VISIBLE);
    }

    /**
     * 显示标题
     */
    public void visibleTitle() {
        title.setVisibility(View.VISIBLE);
    }

    /**
     * @param visible
     */
    public void setRightButtonVisible(boolean visible) {
        if (visible) {
            right.setVisibility(View.VISIBLE);
        } else {
            right.setVisibility(View.GONE);
        }
    }

    /**
     * 修改右侧按钮文字
     */
    public void setRightBtnText(String str) {
        rightTextView.setText(str);
    }

    /**
     * 设置背景颜色
     *
     * @param color
     */
    public void setBackgroundColor(int color) {
        layout_title.setBackgroundColor(color);
    }

    /**
     * 设置左边返回键
     *
     * @param backDrawableId
     * @param onClickListener
     */
    public void setBackButton(int backDrawableId, OnClickListener onClickListener) {

        backLayout.setOnClickListener(this);
        title.setOnClickListener(this);

        if (backDrawableId != -1) {
            back.setImageResource(backDrawableId);
        }
        if (onClickListener != null) {
            backOnClickListener = onClickListener;
            back.setVisibility(View.VISIBLE);
        } else {
            back.setVisibility(View.GONE);
        }

    }

    //获取左边的img
    public ImageView getBack() {
        return back;
    }


    /**
     * 设置左边返回键
     *
     * @param backDrawableId
     * @param text
     * @param onClickListener
     */
    public void setBackButton(int backDrawableId, String text, OnClickListener onClickListener) {

        backLayout.setOnClickListener(this);
        title.setOnClickListener(this);

        if (backDrawableId != -1) {
            back.setImageResource(backDrawableId);
        }
        if (onClickListener != null) {
            backOnClickListener = onClickListener;
            back.setVisibility(View.VISIBLE);
        } else {
            back.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(text)) {
            textleft.setVisibility(VISIBLE);
            textleft.setText(text);
        }

    }

    /**
     * 设置左边返回键
     *
     * @param text
     * @param onClickListener
     */
    public void setBackButton(String text, OnClickListener onClickListener) {

        backLayout.setOnClickListener(this);
        title.setOnClickListener(this);
        back.setVisibility(INVISIBLE);

        if (onClickListener != null) {
            backOnClickListener = onClickListener;
            back.setVisibility(View.VISIBLE);
        } else {
            back.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(text)) {
            textleft.setVisibility(VISIBLE);
            textleft.setText(text);
        }

    }

    /**
     * 标题文字
     *
     * @param name
     */
    public void setTitleName(String name) {
        if (name != null) {
            title.setText(name);

        }

    }

    /**
     * 标题文字yanse
     *
     * @param color
     */
    public void setTitleColor(int color) {
        if (color != 0) {
            title.setTextColor(color);
        }

    }

    /**
     * 设置右侧按钮
     *
     * @param str
     * @param onClickListener
     */
    public void setRightButton(String str, OnClickListener onClickListener) {
        rightTextView.setText(str);
        rightTextView.setVisibility(View.VISIBLE);
        rightTextView.setOnClickListener(onClickListener);
    }

    @Override
    public void onClick(View view) {

        int i = view.getId();
        if (i == R.id.back_layout) {
            if (null != backOnClickListener) {
                backOnClickListener.onClick(view);
            }
        }
    }

    //返回右边的文本
    public TextView getRightTextView() {
        return rightTextView;
    }

    //返回右边的img
    public ImageView getRightImageView() {
        return rightBtn;
    }

    public RelativeLayout getRl() {
        return right;
    }

    /**
     * 设置了左边返回键
     *
     * @param activity
     */
    public void setBack(final Activity activity) {
        setBackButton(-1, new OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    /**
     * 设置了左边返回键
     *
     * @param activity
     */
    public void setBack(final Activity activity, final boolean isToMain) {
        setBackButton(-1, new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isToMain){
                    activity.startActivity(new Intent(activity, MainActivity.class));
                    activity.finish();
                }

            }
        });
    }

    public void setBackImage(int reId) {
        back.setImageResource(reId);
    }
}
