package com.urovo.ums_pmc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.urovo.ums_pmc.util.NumericalKeyboardView;

/**
 * Created by Administrator on 2017/8/16.
 */

public class PayAmtAcivity extends BaseActivity implements View.OnClickListener {
    private EditText et_payamt;
    private NumericalKeyboardView nkv;

    @Override
    protected void initListener() {
        et_payamt.addTextChangedListener(new MyEditChangeListener(et_payamt));
        et_payamt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @SuppressLint("ClickableViewAccessibility")
            public boolean onTouch(View v, MotionEvent event) {
                return true;//屏蔽触摸事件
            }
        });

        nkv.setCallback(new NumericalKeyboardView.Callback() {
            @Override
            public void onKeyPressed(String text) {
                et_payamt.getEditableText().replace(et_payamt.getSelectionStart(), et_payamt.getSelectionEnd(), text);
            }

            @Override
            public void onKeyBackspacePressed() {
                if (!PayAmtAcivity.this.onKeyBackspacePressed()) {
                    if (et_payamt != null && et_payamt.length() > 0) {
                        et_payamt.setText(et_payamt.getText().subSequence(0, et_payamt.length() - 1));
                        et_payamt.setSelection(et_payamt.getText().length());
                    }
                }
            }

            @Override
            public void onKeyEnterPressed() {
                if (!PayAmtAcivity.this.onKeyEnterPressed(et_payamt.getText().toString())) {
                    startActivity(new Intent(PayAmtAcivity.this, PayResultActivity.class));
                }
            }

        });

        et_payamt.setSelection(et_payamt.getText().length());
    }

    private boolean onKeyEnterPressed(String string) {
        return false;
    }

    private boolean onKeyBackspacePressed() {
        return false;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        et_payamt = (EditText) findViewById(R.id.et_payamt);
        nkv = (NumericalKeyboardView) findViewById(R.id.nkv);
    }

    @Override
    protected int getLayout() {
        return R.layout.payamt_activity;
    }

    @Override
    protected void setMap(Bundle outState) {

    }

    @Override
    protected void getMap(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {

    }

    private class MyEditChangeListener implements TextWatcher {

        private boolean status = true;
        private EditText et3;
        private StringBuffer sb = new StringBuffer();

        public MyEditChangeListener(EditText et) {
            this.et3 = et;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (status) {
                status = false;
                et3.setText(dealString(s.toString()));
                et3.setSelection(et3.length());
            } else {
                status = true;
            }
        }

        private String dealString(String arg1) {
            if (sb.length() != 0) {
                sb.delete(0, sb.length());
            }
            if (arg1.length() == 0) {
                return "";
            } else if (arg1.length() == 1) {
                if (arg1.equals(".")) {
                    return "";
                }
                if (arg1.equals("0")) {
                    return "";
                }
                double re = Double.parseDouble(arg1);
                re = re / 100;
                return re + "";
            } else if (arg1.length() == 2) {
                if (arg1.equals("00")) {
                    return "";
                }
            } else {
                sb.append(arg1);
                if (sb.length() - 1 - sb.indexOf(".") == 4) {
                    double content = Double.parseDouble(sb.toString());
                    if (content < 0.1) {
                        sb.delete(0, 3);
                        sb.insert(1, ".");
                    } else if (content < 1) {
                        sb.delete(0, 2);
                        sb.insert(2, ".");
                    } else {
                        int index = sb.indexOf(".");
                        sb.deleteCharAt(index);
                        sb.insert(index + 2, ".");
                    }
                } else if (sb.length() - 1 - sb.indexOf(".") == 3) {
                    if (arg1.charAt(0) == '0') {
                        if (arg1.charAt(2) == '0') {
                            sb.deleteCharAt(2);
                        } else {
                            sb.delete(0, 2);
                            sb.insert(1, ".");
                        }
                    } else {
                        int index = sb.indexOf(".");
                        sb.deleteCharAt(index);
                        sb.insert(index + 1, ".");
                    }
                } else {
                    int index = sb.indexOf(".");
                    if (index > 1) {
                        sb.deleteCharAt(index);
                        sb.insert(index - 1, ".");
                    } else {
                        if (sb.charAt(0) == '0') {
                            sb.insert(2, "0");
                        } else {
                            sb.deleteCharAt(index);
                            sb.insert(index - 1, ".");
                            sb.insert(index - 1, "0");
                        }
                    }
                }
            }
            return sb.toString();
        }

    }
}
