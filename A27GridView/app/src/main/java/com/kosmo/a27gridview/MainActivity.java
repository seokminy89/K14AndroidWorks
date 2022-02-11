package com.kosmo.a27gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  static final  String TAG = "KOSMO";

    //데이터 준비(팀명, 인원수, 이미지)->차후 JSON으로 대체해야 함.
    String[] names = {
            "엑소","방탄소년단","워너원","뉴이스트","갓세븐","비투비","빅스",
            "엑소2","방탄소년단2","워너원2","뉴이스트2","갓세븐2","비투비2","빅스2",
            "엑소3","방탄소년단3","워너원3","뉴이스트3","갓세븐3","비투비3","빅스3"};
    String[] ages = {
            "9", "7", "11", "5", "7", "7", "6",
            "93", "72", "114", "51", "72", "72", "63",
            "94", "71", "115", "53", "71", "76", "69"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //어댑터객체 생성(커스텀+데이터적용)
        final MyAdapter adapter = new MyAdapter();
        //그리드뷰 위젯 가져오기
        GridView gridView1 = findViewById(R.id.gridView1);
        //어댑터와 그리드뷰 연결
        gridView1.setAdapter(adapter);
        //각 아이템을 클릭했을때의 리스너 부착
        gridView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //콜백되는 index를 통해 행과 열을 계산해서 로그로 출력한다.
                int row = position / 2;
                int column = position % 2;
                Log.d(TAG, "position : "+ position);
                Log.d(TAG, "Row index : "+ row + " Column index :" + column);
                Log.d(TAG, names[row * 2 + column]);
                //토스트로 출력
                Toast.makeText(getApplicationContext(),
                        "그룹명:"+names[position]+",인원수:"+ages[position],
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    //커스텀 어댑터 객체 생성
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            //전체 항목수
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            //하나의 항목을 반환
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            //인덱스를 반환
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            //Java코드로 리니어 레이아웃 생성
            LinearLayout layout = new LinearLayout(getApplicationContext());
            //방향은 수직방향으로 설정
            layout.setOrientation(LinearLayout.VERTICAL);

            //텍스트뷰1 : 그룹명
            TextView view1 = new TextView( getApplicationContext() );
            view1.setText(names[position]);
            view1.setTextSize(40.0f);
            view1.setTextColor(Color.BLUE);
            //텍스트뷰1 : 인원
            TextView view2 = new TextView( getApplicationContext() );
            view2.setText(ages[position]);
            view2.setTextSize(40.0f);
            view2.setTextColor(Color.RED);
            //레이아웃에 위젯 추가
            layout.addView(view1);
            layout.addView(view2);

            return layout;
        }
    }
}