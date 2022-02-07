package com.kosmo.a08datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //앱 전체에서 사용하기 위해 멤버변수 생성.
    Calendar calendar; //현재 날짜, 시간을 얻기 위해 생성.
    TextView date_tv, time_tv; //텍스트뷰 객체(시간, 날짜 표시)
    int yearStr, monthStr, dayStr;//현재날짜
    int hourStr, minuteStr, secondStr; //현재시간

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //텍스트 뷰 위젯 가져오기
        date_tv = (TextView)findViewById(R.id.date_tv);
        time_tv = (TextView)findViewById(R.id.time_tv);

        //캘린더 클래스를 통해 날짜와 시간을 구한다.
        calendar = Calendar.getInstance();

        yearStr = calendar.get(calendar.YEAR);
        monthStr = calendar.get(calendar.MONTH);
        dayStr = calendar.get(calendar.DATE);

        hourStr = calendar.get(calendar.HOUR_OF_DAY);
        minuteStr = calendar.get(calendar.MINUTE);
        secondStr = calendar.get(calendar.SECOND);
        //현재 날짜와 시간을 텍스트뷰에 설정.(첫 화면 버튼 위에 나오는 날짜와시간설정.)
        date_tv.setText(yearStr+"년"+(monthStr+1)+"월"+dayStr+"일");
        time_tv.setText(hourStr+"시"+minuteStr+"분"+secondStr+"초");

        //날짜 버튼을 눌렀을때 데이트피커를 띄워준다.
        Button btn_datepicker = findViewById(R.id.btn_datepicker);
        btn_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //데이트피커 대화창 객체생성
                /*
                new DatePickerDialog(컨텍스트, 리스너, 년, 월, 일)
                위 생성자를 통해 객체를 생성한 후 show()를 통해 화면에 출력한다.
                */
                DatePickerDialog dialog = new DatePickerDialog(
                    v.getContext(),
                    listener,
                    yearStr, monthStr, dayStr
                );
                //show()메서드를 통해 화면에 띄워준다.
                dialog.show();// show()부분이 없으면 안뜸. 실질적 실행을 담당.
            }
        });

        //시간 버튼을 눌렀을때 타임피커를 띄워준다.
        Button btn_timepicker = findViewById(R.id.btn_timepicker);
        btn_timepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /*
                new TimePickerDialog(컨텍스트, 리스너, 시, 분, 24시간포맷);
                ※ 24시간 포맷에 : true입력시(24시간제로 표시), false입력시(12시간제로 표시)
                 */
                new TimePickerDialog(
                    v.getContext(),
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            //선택한 시간을 텍스튜 뷰에 표시한다.
                            time_tv.setText(
                                    String.format("설정된시간%n%d시 %d분", hourOfDay, minute));
                            Toast.makeText(getApplicationContext(),
                                    String.format("설정된시간%n%d시 %d분", hourOfDay, minute),
                                    Toast.LENGTH_LONG).show();
                        }
                    },
                    hourStr,
                    minuteStr,
                    true
                ).show();
            }
        });
    }////onCreate 끝

    //데이트피커 리스너 선언(onCreate() 외부에 별도로 정의)
    private  DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            //선택한 날짜를 텍스트 뷰에 입력한다.
            date_tv.setText(String.format("설정된날짜%n%d년 %d월 %d일", year, (month+1), dayOfMonth));
            /*
            Calender객체를 통해 얻어온 날짜 중 월은 0~11까지를 반환하므로
            +1 해줘야 한다.
             */
            //위의 내용을 토스트로 띄워준다.
            Toast.makeText(getApplicationContext(),
                    year+"년"+(month+1)+"월"+dayOfMonth+"일",
                    Toast.LENGTH_LONG).show();
        }
    };////end of listener
}////메인 class 끝