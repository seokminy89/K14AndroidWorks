package com.kosmo.a30fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
자동생성 메뉴를 통해 프래그먼트 생성
    기본패키지 > 우클릭 > new > Fragment > blank > 선택
    생성된 후 onCreateView() 빼고 모든주석과 메서드 전부 지우기

    프래그먼트는 액티비티와 비슷하게 화면을 표현하기 위해 생성한다.
    Java파일과 XML파일로 구성되어 있는것은 액티비티와 동일하지만
    Manifests에 등록되지 않는다.
    즉 전체화면이라기보단 부분화면을 표현할 때 주로 사용한다.
 */
public class TopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top, container, false);
    }
}