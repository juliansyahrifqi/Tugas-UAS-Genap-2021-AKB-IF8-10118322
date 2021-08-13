package com.example.a10118322_rifqipratamaj_tugasuas;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>{

    private List<ViewPagerItem> viewPagerItems;

    public ViewPagerAdapter(List<ViewPagerItem> viewPagerItems) {
        this.viewPagerItems = viewPagerItems;
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewPagerViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.viewpager_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        holder.setViewPagerData(viewPagerItems.get(position));
    }

    @Override
    public int getItemCount() {
        return viewPagerItems.size();
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;
        private ImageView img_viewpager;

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.viewpager_title);
            description = itemView.findViewById(R.id.viewpager_description);
            img_viewpager = itemView.findViewById(R.id.viewpager_image);
        }

        void setViewPagerData(ViewPagerItem viewpagerItem) {
            title.setText(viewpagerItem.getTitle());
            description.setText(viewpagerItem.getDescription());
            img_viewpager.setImageResource(viewpagerItem.getImage());
        }
    }
}