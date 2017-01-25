package me.takimitsuha.rollingnumber;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by Taki on 2017/1/25.
 */
public class RollingNumberView extends TextView {
    private Handler mHandler;
    private Runnable mRunnable;
    private double oldnum;
    private double newnum;
    private double startnum = 0;

    public RollingNumberView(Context context, Handler handler) {
        super(context);
    }

    public RollingNumberView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public RollingNumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public CharSequence getText() {
        return super.getText();
    }

    public void setText(CharSequence text, BufferType type, Handler myHandler) {
        mHandler = myHandler;
        oldnum = 0.00;
        newnum = Double.valueOf(text.toString());
        // 转化国际化数字显示
        // 若想在数字前面在上￥符号 ，将getIntegerInstance()方法改为getCurrencyInstance () 方法
        final NumberFormat af = NumberFormat.getIntegerInstance();
        // 设置精确到小数点后两位
        af.setMinimumFractionDigits(2);
        mRunnable = new Runnable() {

            @Override
            public void run() {
                // 设置每次添加的度量
                oldnum += newnum / 30;
                if (startnum < newnum) {
                    if (oldnum > newnum)
                        oldnum = newnum;
                    setText(af.format(oldnum));
                    mHandler.postDelayed(mRunnable, 50);
                } else if (oldnum == newnum) {
                    setText(af.format(oldnum));
                }
            }
        };
        mHandler.postDelayed(mRunnable, 50);
    }

}
