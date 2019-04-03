package com.example.cardswapviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Modle>modles;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Modle> modles, Context context) {
        this.modles = modles;
        this.context = context;
    }

    @Override
    public int getCount() {
        return modles.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,container,false);


        ImageView imageView;
        TextView title,dsc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        dsc = view.findViewById(R.id.dsc);

        imageView.setImageResource(modles.get(position).getImage());
        title.setText(modles.get(position).getTitle());
        dsc.setText(modles.get(position).getDsc());

        container.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
