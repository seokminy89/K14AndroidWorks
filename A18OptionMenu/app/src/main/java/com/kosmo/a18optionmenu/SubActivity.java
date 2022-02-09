package com.kosmo.a18optionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    private RelativeLayout layout;
    private ImageView imageView;
    private float rotation;
    private float scaleXY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        layout = findViewById(R.id.layout);
        imageView = findViewById(R.id.imageview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,101,1,"옵션메뉴1")
                .setIcon(R.drawable.away)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(Menu.NONE,102,2,"옵션메뉴2")
                .setIcon(R.drawable.busy)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menu.add(Menu.NONE,103,3,"옵션메뉴3")
                .setIcon(R.drawable.offline)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        menu.add(0,1,11,"Red[빨간색]");
        menu.add(0,2,12,"Green[녹색]");
        menu.add(0,3,13,"Blue[파란색]");

        SubMenu subMenu = menu.addSubMenu(0,4,14,"이미지변환");
        subMenu.add(0,5,1,"90도회전");
        subMenu.add(0,6,2,"2배확대");
        subMenu.add(0,7,3,"2배축소");

        menu.add(0,99,15,"메인엑티비티Go");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case 101://옵션메뉴1
                Toast.makeText(this, "옵션메뉴1선택",
                        Toast.LENGTH_SHORT).show();
                break;
            case 102://옵션메뉴2
                Toast.makeText(this, "옵션메뉴2선택",
                        Toast.LENGTH_SHORT).show();
                break;
            case 103://옵션메뉴3
                Toast.makeText(this, "옵션메뉴3선택",
                        Toast.LENGTH_SHORT).show();
                break;
            case 1://배경색 Red로 변경
                layout.setBackgroundColor(Color.RED);
                break;
            case 2://배경색 Green으로 변경
                layout.setBackgroundColor(Color.GREEN);
                break;
            case 3://배경색 Blue로 변경
                layout.setBackgroundColor(Color.BLUE);
                break;
            case 5://이미지 90도 회전
                if(rotation==360) rotation=0;
                rotation += 90;
                imageView.setRotation(rotation);
                break;
            case 6://이미지 2배확대
                if(scaleXY!=5) scaleXY += 2;
                imageView.setScaleX(scaleXY);
                imageView.setScaleY(scaleXY);
                break;
            case 7://이미지 2배축소
                if(scaleXY > 1) scaleXY -= 2;
                imageView.setScaleX(scaleXY);
                imageView.setScaleY(scaleXY);
                break;
            case 99:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
