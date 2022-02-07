package com.kosmo.a07resource;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯가져오기
        TextView textViewCode = findViewById(R.id.code_textview);
        ImageView imageViewCode = findViewById(R.id.code_imageview);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);


        //Java에서 리소스 사용을 위한 객체 생성.
        final Resources resources = getResources();
        //텍스트 설정(Strings.xml에서 가져온 내용)
        textViewCode.setText(R.string.code_message);
        //텍스트 크기 설정(dimens.xml에서 가져온 내용)
        textViewCode.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources.getDimension(R.dimen.dimenXml));
        //텍스트 컬러 설정(colors.Xml에서 가져온 내용)
        textViewCode.setTextColor(ContextCompat.getColor(this,R.color.colorXml));

        //이미지뷰에 Java코드로 이미지 설정하기
        imageViewCode.setImageResource(R.drawable.grandmother);

        //int형 배열을 출력하는 버튼
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                res의 arrays.xml에서 int_array항목을 가져와서 문자열로
                변경한 후 토스트로 출력한다.
                */
                Toast.makeText(v.getContext(),
                        Arrays.toString(resources.getIntArray(R.array.int_array)),
                        Toast.LENGTH_LONG).show();
            }
        });
        //String형 배열을 출력하는 버튼
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                //리소스를 읽어와서 String형 배열에 저장
                String[] idolArr = resources.getStringArray(R.array.str_array);
                //배열에 저장된 문자열을 하나의 문자열로 만들어준다.
                StringBuffer buf = new StringBuffer();
                for(String idol : idolArr){
                    buf.append(idol+"\r\n");
                }
                Toast.makeText(v.getContext(), buf, Toast.LENGTH_LONG).show();
            }
        });


    }
}