package seawright.carringtondemo;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;

import seawright.carringtondemo.AnimationActivity;
import seawright.carringtondemo.DialogActivity;
import seawright.carringtondemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Quiz4 extends Dialog {


    private int checkedID;

    @BindView(R.id.rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.quiz4_ok_bt)
    public void okClick(){
        if(checkedID==R.id.rb1){
            listener.onClickListener();
        }
        else if(checkedID==R.id.rb2){
            listener.onClick2Listener();
        }
        dismiss();
    }

    @OnClick(R.id.quiz4_cancel_bt)
    public void cancelClick(){
        listener.onClickCancel();
        dismiss();
    }

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
        public void onClick2Listener();
        public void onClickCancel();

    }


    public Quiz4(@NonNull Context context, ICustomDialogEventListener listener) {
        super(context, R.style.dialog);
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                checkedID = checkedId;

            }
        });
    }
}