package com.urovo.ums_pmc.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.urovo.ums_pmc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字键盘的View
 *
 * @author KuCoffee
 */
public class NumericalKeyboardView extends FrameLayout implements View.OnClickListener, OnItemClickListener {
    protected GridView gvKeys;
    protected Button btnBackspace;
    protected Button btnEnter;
    protected KeysAdapter keysAdapter;
    protected Callback callback;

    public NumericalKeyboardView(Context context) {
        super(context);
        init();
    }

    public NumericalKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumericalKeyboardView(Context context, AttributeSet attrs,
                                 int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * @param callback 设置回调接口
     */
    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    /**
     * 初始化键盘布局，初始化键盘按钮，初始化数字键显示，初始化键盘监听。
     */
    protected void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_numerical_keyboard, this, true);
        gvKeys = (GridView) findViewById(R.id.gvKeys);
        btnBackspace = (Button) findViewById(R.id.btnBackspace);
        btnEnter = (Button) findViewById(R.id.btnEnter);
        keysAdapter = new KeysAdapter();

        gvKeys.setOnItemClickListener(this);
        btnBackspace.setOnClickListener(this);
        btnEnter.setOnClickListener(this);

        gvKeys.setAdapter(keysAdapter);
    }

    /**
     * 设置数字按钮事件，回调事件给接口
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        if (parent == gvKeys) {
            String text = keysAdapter.getItem(position);
            if (callback != null) {
                callback.onKeyPressed(text);
            }
        }
    }

    /**
     * 设置确认，取消按钮事件，回调接口
     */
    @Override
    public void onClick(View v) {
        if (v == btnBackspace) {
            if (callback != null) {
                callback.onKeyBackspacePressed();
            }
        } else if (v == btnEnter) {
            if (callback != null) {
                callback.onKeyEnterPressed();
            }
        }
    }

    private class KeysAdapter extends BaseAdapter {
        private List<String> texts;

        private KeysAdapter() {
            super();
            this.texts = new ArrayList<String>();
            this.texts.add("1");
            this.texts.add("2");
            this.texts.add("3");
            this.texts.add("4");
            this.texts.add("5");
            this.texts.add("6");
            this.texts.add("7");
            this.texts.add("8");
            this.texts.add("9");
            this.texts.add(" ");
            this.texts.add("0");
            this.texts.add("00");
        }

        @Override
        public int getCount() {
            return this.texts.size();
        }

        @Override
        public String getItem(int position) {
            return this.texts.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean isEnabled(int position) {
            if (TextUtils.isEmpty(getItem(position))) {
                return false;
            }
            return super.isEnabled(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_keys, parent, false);
                convertView.setTag(new ViewHolder(convertView));
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.updateItem(getItem(position));
            return convertView;
        }

        private class ViewHolder {
            private TextView tvContent;

            public ViewHolder(View rootView) {
                super();
                this.tvContent = (TextView) rootView.findViewById(R.id.tvContent);
            }

            public void updateItem(String text) {
                tvContent.setText(text);
            }
        }
    }

    /**
     * 当键盘上的按键按下时回调
     *
     * @param
     */
    public interface Callback {
        /**
         * 返回按下键的text
         */
        public void onKeyPressed(String text);

        /**
         * 当删除键按下时回调
         */
        public void onKeyBackspacePressed();

        /**
         * 当回车键按下时回调
         */
        public void onKeyEnterPressed();
    }
}
