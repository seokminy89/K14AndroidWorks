package com.kosmo.a04framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameActivity extends AppCompatActivity {

    //이미지를 표현할 때 사용하는 뷰 객체
    // 전역적으로 사용하기 위해 멤버변수 형태로 생성.
    ImageView dream01;//현재숨김상태
    ImageView dream02;//현재보임상태
    
    //이미지 토글을 위한 변수
    int imageToggle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        
        //res에 저장된 이미지의 id를 통해 얻어온 후 변수에 저장
        dream01 = findViewById(R.id.dream01);
        dream02 = findViewById(R.id.dream02);
    }////onCreate 끝

    /*
    버튼의 onclick속성에 호출할 메서드를 연결한 상태이므로
    별도의 리스너 처리가 필요없다. 해당 메서드를 정의할때는
    반드시 View객체를 매개변수로 삽입해야 한다.
     */
    public  void  imageChange(View v){
        /*
        xml의 android:visibility 속성을 Java에서 처리할 때 아래와 같이
        setter의 형태로 설정할 수 있다.
         */
        if(imageToggle==0){
            dream01.setVisibility(v.VISIBLE); //보임처리
            dream02.setVisibility(v.INVISIBLE); //숨김처리
            imageToggle=1;
        }
        else if(imageToggle==1){
            dream01.setVisibility(v.INVISIBLE); //숨김처리
            dream02.setVisibility(v.VISIBLE); //보임처리
            imageToggle=0;
        }
    }
    //현재 실행중인 액티비티를 종료한다.
    public void returnMain(View v){
        finish();
    }
}