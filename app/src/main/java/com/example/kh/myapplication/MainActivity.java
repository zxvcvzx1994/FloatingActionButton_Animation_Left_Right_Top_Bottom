package com.example.kh.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.fabMain)
    FloatingActionButton fabMain;
    @BindView(R.id.fabLeft)
    FloatingActionButton fabLeft;
    @BindView(R.id.fabRight)
    FloatingActionButton fabRight;
    @BindView(R.id.fabTop)
    FloatingActionButton fabTop;
    private int count=0;
    @BindView(R.id.fabBot)
    FloatingActionButton fabBot;
    Animation moveleft,moveright,movetop,movebot,back;
    private boolean show = false;
    private final String TAG =  "vo cong vinh";
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        moveleft = AnimationUtils.loadAnimation(this, R.anim.move_left);
        movetop  = AnimationUtils.loadAnimation(this, R.anim.move_top);
        moveright = AnimationUtils.loadAnimation(this, R.anim.move_right);
        movebot = AnimationUtils.loadAnimation(this, R.anim.move_bot);
        back =  AnimationUtils.loadAnimation(this, R.anim.back);
    }

    @OnClick(R.id.fabMain)
        public void fab1(){
        if(show==false){
             show();
        }else{

                hide();
        }

    }

    private void show(){

        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) fabBot.getLayoutParams();
        param.topMargin = 0;
        fabBot.setLayoutParams(param);
        fabBot.startAnimation(movebot);

        FrameLayout.LayoutParams param1 = (FrameLayout.LayoutParams) fabTop.getLayoutParams();
        param1.bottomMargin = 0;
        fabTop.setLayoutParams(param1);
        fabTop.startAnimation(movetop);

        FrameLayout.LayoutParams params2 = (FrameLayout.LayoutParams) fabLeft.getLayoutParams();
        params2.rightMargin =0;
        fabLeft.setLayoutParams(params2);
        fabLeft.startAnimation(moveleft);

        FrameLayout.LayoutParams params3= (FrameLayout.LayoutParams) fabRight.getLayoutParams();
        params3.leftMargin = 0;
        fabRight.setLayoutParams(params3);
        fabRight.startAnimation(moveright);

        show=true;
    }

    private void hide(){
        FrameLayout.LayoutParams param = (FrameLayout.LayoutParams) fabBot.getLayoutParams();
        param.topMargin = (int) (fabBot.getHeight()*1.7);
        fabBot.setLayoutParams(param);
        fabBot.startAnimation(movetop);

        FrameLayout.LayoutParams param1 = (FrameLayout.LayoutParams) fabTop.getLayoutParams();
        param1.bottomMargin = (int) (fabBot.getHeight()*1.7);
        fabTop.setLayoutParams(param1);
        fabTop.startAnimation(movebot);

        FrameLayout.LayoutParams params2 = (FrameLayout.LayoutParams) fabLeft.getLayoutParams();
        params2.rightMargin = (int) (fabLeft.getWidth()*1.7);
        fabLeft.setLayoutParams(params2);
        fabLeft.startAnimation(moveright);

        FrameLayout.LayoutParams params3 = (FrameLayout.LayoutParams) fabRight.getLayoutParams();
        params3.leftMargin = (int) (fabRight.getWidth()*1.7);
        fabRight.setLayoutParams(params3);
        fabRight.startAnimation(moveleft);


        show = false;
    }




}
