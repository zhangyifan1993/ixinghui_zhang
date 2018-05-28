package com.example.zhangyifn.myixinghui.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.zhangyifn.myixinghui.R;


/**
 * Created by ycs on 2016/6/15.
 */
public class MyEditText extends RelativeLayout implements TextWatcher {

    private EditText et;
    private ImageView iv_clear;
    private ImageView iv_show;

    //输入类型状态值,默认不可见
    private boolean visible = false;

    public MyEditText(Context context) {
        super(context);
        initView(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    private void initView(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.my_edit_text,this,true);
        et = (EditText) view.findViewById(R.id.et);
        iv_clear = (ImageView) view.findViewById(R.id.iv_clear);
        iv_show = (ImageView) view.findViewById(R.id.iv_show);
        iv_clear.setVisibility(View.GONE);
        iv_clear.setOnClickListener(clickListener);
        iv_show.setOnClickListener(showListener);
        et.addTextChangedListener(this);
        setFocusable(false);
    }
    public void setTextListener(final ImTextListener listener){
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                listener.afterTextListener();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String text = et.getText().toString().toString();
        et.setSelection(text.length());
        if(TextUtils.isEmpty(text)){
            iv_clear.setVisibility(View.GONE);
        }else{
            iv_clear.setVisibility(View.VISIBLE);
            et.setSelection(text.length());
        }
    }

    //点击清除按钮，清空edittext
    private OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            et.setText("");
        }
    };
    //点击眼睛，设置输入类型
    private OnClickListener showListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(iv_show.isSelected()){
                iv_show.setSelected(false);
                setType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_PASSWORD);
            }else{
                iv_show.setSelected(true);
                setType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }
            visible = !visible;
        }
    };

    /**
     * 设置edit中的hint文字
     * @param str
     */
    public void setHint(String str){
        et.setHint(str);
    }

    /**
     * 设置输入类型
     * @param type
     */
    public void setType(int type){
        et.setInputType(type);
    }

    /**
     * 设置眼睛图标是否显示
     * @param visibleShow
     */
    public void setVisibleShow(int visibleShow){
        iv_show.setVisibility(visibleShow);
    }

    /**
     * 获取edittext对象
     * @return
     */
    public EditText getEt(){
        return et;
    }

    /**
     * 获取imageview对象
     * @return
     */
    public ImageView getIv_clear(){
        return iv_clear;
    }

    /**
     * 设置输入长度
     * @param length
     */
    public void setLength(int length){
        et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(length)});
    }
    public interface ImTextListener{
        void afterTextListener();
    }
    //设置最大行数
    public void setLine(int line){
        et.setMaxLines(line);
        et.setEllipsize(TextUtils.TruncateAt.START);
    }
}
