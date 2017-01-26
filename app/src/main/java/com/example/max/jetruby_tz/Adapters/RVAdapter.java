package com.example.max.jetruby_tz.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.max.jetruby_tz.R;
import com.example.max.jetruby_tz.Model.Shot;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ShotsViewHolder> {

    private List<Shot> shots;
    private int rowLayout;
    private Context context;

    public RVAdapter(List<Shot> shots, int rowLayout, Context context) {
        this.shots = shots;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    public void addElements(List<Shot> extraElements) {
        shots.addAll(extraElements);
    }

    @Override
    public ShotsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_shots, viewGroup, false);
        ShotsViewHolder shotsViewHolder = new ShotsViewHolder(v);
        return shotsViewHolder;
    }

    @Override
    public void onBindViewHolder(ShotsViewHolder shotsViewHolder, int i) {
        Boolean anim = shots.get(i).animated;
        if (anim == false) {
            shotsViewHolder.shotsTitle.setText(shots.get(i).title);
            String descrip = shots.get(i).description;
            if (descrip != null) {
                shotsViewHolder.shotsDescription.setText(Html.fromHtml(shots.get(i).description));
            }
            String hidpiImage = shots.get(i).images.hidpi;
            String normalImage = shots.get(i).images.normal;
            String image;
            if (hidpiImage != null) {
                image = hidpiImage;
            } else {
                image = normalImage;
            }
            Glide.with(context)
                    .load(image)
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(shotsViewHolder.shotsImage);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return shots.size();
    }

    public static class ShotsViewHolder extends RecyclerView.ViewHolder {

        TextView shotsTitle;
        TextView shotsDescription;
        ImageView shotsImage;

        ShotsViewHolder(View itemView) {
            super(itemView);
            shotsTitle = (TextView) itemView.findViewById(R.id.shots_title);
            shotsDescription = (TextView) itemView.findViewById(R.id.shots_description);
            shotsImage = (ImageView) itemView.findViewById(R.id.shots_images);
        }
    }
}
