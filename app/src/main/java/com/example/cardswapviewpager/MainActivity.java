package com.example.cardswapviewpager;

import android.animation.ArgbEvaluator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Modle>modles;
    Integer [] colours = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modles = new ArrayList<>();
        modles.add(new Modle(R.drawable.th,"Coffe","Coffe is Daily Food, I is a energy drink"));
        modles.add(new Modle(R.drawable.aus,"Australia","Australia Cricket Team Winimg pic of world cup"));
        modles.add(new Modle(R.drawable.worldcup,"World Cup","Icc World Cup 2019 Trophi thid is "));
        modles.add(new Modle(R.drawable.them,"Them","Icc world cup 2019 Them is this"));

        adapter = new Adapter(modles,this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colours_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4)
        };
        colours = colours_temp;

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i <(adapter.getCount()-1)&& i <(colours.length - 1))
                {
                   viewPager.setBackgroundColor(
                           (Integer) argbEvaluator.evaluate(v,
                                   colours[i],colours[i + 1]));
                }else {
                    viewPager.setBackgroundColor(colours[colours.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }
}
