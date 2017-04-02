package seawright.carringtondemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends BaseActivity {

    private Animation alphaAnimation;
    private Animation scaleAnimation;
    private Animation setAnimation;
    private Animation rotateAnimation;
    private Animation transAnimation;


    @BindView(R.id.anim_tv)
    TextView tv;

    @OnClick(R.id.anim_alpha)
    public void alpha(){
        tv.startAnimation(alphaAnimation);
    }

    @OnClick(R.id.anim_set)
    public void set(){
        tv.startAnimation(setAnimation);
    }

    @OnClick(R.id.anim_rotate)
    public void rotate(){
        tv.startAnimation(rotateAnimation);
    }

    @OnClick(R.id.anim_scale)
    public void scale(){
        tv.startAnimation(scaleAnimation);
    }

    @OnClick(R.id.anim_trans)
    public void trans(){
        tv.startAnimation(transAnimation);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
        initialAnimation();
        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                toastShort("click");
            }
        });
    }

    private void initialAnimation(){
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        transAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_trans);

    }

}
