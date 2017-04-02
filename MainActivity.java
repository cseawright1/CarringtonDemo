package seawright.carringtondemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import seawright.carringtondemo.R;
import butterknife.ButterKnife;
import butterknife.OnClick;
import seawright.carringtondemo.Util.UtilLog;
import seawright.carringtondemo.bean.Book;

public class MainActivity extends BaseActivity implements View.OnTouchListener{
    private ImageButton bt1;
    private ImageButton bt3;

    int counter = 0;
    private GestureDetector mGestureDetector;
    @BindView(R.id.Hw4)
    LinearLayout linear;
    @BindView(R.id.main_fl)
    FrameLayout fl;

    @OnClick(R.id.main_anim_bt)
    public void toAnimation(){
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.quiz4_bt)
    public void Quiz4(){
        final Quiz4 dialog = new Quiz4(this, new Quiz4.ICustomDialogEventListener() {
            @Override
            public void onClickListener() {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }

            @Override
            public void onClick2Listener() {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }

            @Override
            public void onClickCancel() {
                Intent intent = new Intent(MainActivity.this,ViewPagerActivity.class);
                intent.putExtra("key","value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Carrington");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
        dialog.show();
    }

    @OnClick(R.id.animator_bt)
    public void toAnimatior(){
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.left_button)
    public void left_button(){
        if(counter==0){
            ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 0, 950, 950, 950);
            animator.setDuration(1000);
            animator.start();
            counter++;
        }
        else{
            ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 950, 0, 0, 0);
            animator.setDuration(1000);
            animator.start();
            counter = 0;
        }
    }

    @OnClick(R.id.bt2)
    public void button2Click(){
        Intent intent= new Intent(this , DialogActivity.class);
        startActivityForResult(intent, 2);
    }
    @OnClick(R.id.right_button)
    public void rightbuttonClick(){
        Intent intent= new Intent(this ,Activity_A.class);
        startActivityForResult(intent, 2);
    }
    @OnClick(R.id.main_timer_bt)
    public void toTimer(){
        toActivity(ActivityTimer.class);

    }

    @Override
    protected void onStart() {
        super.onStart();
        toastShort("onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);

    }
    private void initialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle= new Bundle();
                bundle.putInt("integer",12345);
                intent.putExtras(bundle);
                Book book= new Book();
                book.setName("Android");
                book.setAuthor("Carrington");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity(ListViewActivity.class);
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:
                String message= data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
            case 3:
                toastShort("ListView");
                break;
            default:


        }
    }

    public void onClick(View v) {
        Toast.makeText(this ,"Button2 was clicked",Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        UtilLog.logD("testD", "Toast");
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return true;
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e){
            UtilLog.logD("MyGesture", "onDown");
            toastShort("onDown");
            return false;
        }

        public void onShowPress(MotionEvent e){
            UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }

        public void onLongPress(MotionEvent e){
            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }

        public boolean onSingleTapUp(MotionEvent e){
            toastShort("onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){
            UtilLog.logD("MyGesture", "onSingleTap" + e);
            toastShort("onSingleTapConfirmed");

            if(counter == 1){
                ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 950, 0, 0, 0, 0);
                animator.setDuration(1000);
                counter = 0;
                animator.start();
            }

            return true;
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            UtilLog.logD("MyGesture", "onScroll:" + (e2.getX() - e1.getX()) + " " + distanceX);
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "onScroll", Toast.LENGTH_SHORT);
            //toastShort("onScroll");
            toast.show();
            return true;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2,float velocityX, float velocityY){
            UtilLog.logD("MyGesture", "onFling: " + (e1.getY() - e2.getY() + " " + velocityX) );
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "onFling", Toast.LENGTH_SHORT);
            //toastShort("onFling");
            if (counter == 0){
                ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 0, 950, 950, 950, 950);
                animator.setDuration(1000);
                animator.start();
                counter++;
            }

            else{
                ObjectAnimator animator = ObjectAnimator.ofFloat(linear, "translationX", 950, 0, 0, 0, 0);
                animator.setDuration(1000);
                animator.start();
                counter = 0;
            }

            toast.show();
            return true;

        }

        public boolean onDoubleTap(MotionEvent e){
            toastShort("onDoubleTap");
            return true;
        }

    }
}
