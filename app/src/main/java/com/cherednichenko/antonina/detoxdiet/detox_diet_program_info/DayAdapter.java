package com.cherednichenko.antonina.detoxdiet.detox_diet_program_info;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cherednichenko.antonina.detoxdiet.R;
import com.cherednichenko.antonina.detoxdiet.detox_diet_data.DayInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tonya on 8/29/16.
 */
public class DayAdapter extends RecyclerView.Adapter<DayAdapter.dayViewHolder> {

    private List<DayInfo> dayList;
    private Context context;

    public DayAdapter(Context context, List<DayInfo> dayList) {
        this.context = context;
        this.dayList = dayList;
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    @Override
    public void onBindViewHolder(dayViewHolder dayViewHolder, int i) {
        DayInfo di = dayList.get(i);
        dayViewHolder.name.setText(di.getName());
        dayViewHolder.description.setText(di.getDescription());
        dayViewHolder.description.setVisibility(TextView.VISIBLE);

        if (di.getOnlyPhoto() == 1) {
            try {
                Picasso
                        .with(context)
                        .load(di.getPhoto())
                        .fit()
                        .into(dayViewHolder.oneBigImage);

            } catch (Exception e) {
                System.out.println("Error while loading image " + di.getPhoto());
            }

            //dayViewHolder.oneBigImage.setImageResource(R.drawable.wedding_detox_day1);
            dayViewHolder.oneBigImage.setVisibility(ImageView.VISIBLE);
            dayViewHolder.description.setVisibility(TextView.INVISIBLE);
        }
    }

    @Override
    public dayViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.day_layout, viewGroup, false);
        final dayViewHolder holder = new dayViewHolder(view);
        return holder;
    }

    public class dayViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView description;
        protected ImageView oneBigImage;

        public dayViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.day_name);
            description = (TextView) v.findViewById(R.id.day_description);
            oneBigImage = (ImageView) v.findViewById(R.id.one_big_day_photo);
        }
    }
}

