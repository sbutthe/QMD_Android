package com.qmd.jzen.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.qmd.jzen.R;

/**
 * Create by OJun on 2020/7/29.
 */
public class AboutItemView extends LinearLayout {
    ImageView imageView_head;
    TextView textView_title;
    CardView layout_cardview;

    public AboutItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initAttrs(context, attrs);
    }


    //初始化UI，可根据业务需求设置默认值。
    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_about_item, this, true);
        imageView_head = findViewById(R.id.imageView_head);
        textView_title = findViewById(R.id.textView_title);
        layout_cardview = findViewById(R.id.cardView_about_item);

    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.AboutItemView);
        String title = mTypedArray.getString(R.styleable.AboutItemView_title);
        setTitle(title);

        Drawable drawable = mTypedArray.getDrawable(R.styleable.AboutItemView_headPic);
        if (drawable != null) {
            imageView_head.setImageDrawable(drawable);
        }
        mTypedArray.recycle();
    }

    public void setOnClickListener(OnClickListener listener) {
        layout_cardview.setOnClickListener(listener);
    }

    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            textView_title.setText(title);
        }
    }

}
