package cn.beescm.commonbusiness.widget;

import android.content.Context;
import android.content.DialogInterface;

import cn.beescm.commonbusiness.R;
import cn.beescm.commonbusiness.databinding.DigLoginwaitBinding;
import cn.beescm.commonbusiness.base.BaseDialog;

/**
 * Created by zhangshaofang on 2017/6/30
 */
public class DialogWait extends BaseDialog<DigLoginwaitBinding> {

    public DialogWait(Context context) {
        super(context, R.style.Dialog_Fullscreen);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dig_loginwait;
    }

    @Override
    public void setMessage(String message) {
        mBinding.tvMessage.setText(message);
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {

    }
}
