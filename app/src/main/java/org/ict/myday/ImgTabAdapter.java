package org.ict.myday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ict.myday.Diary.Diary;

import java.util.List;

public class ImgTabAdapter extends RecyclerView.Adapter<ImgTabAdapter.ViewHolder> {

    private List<Diary> items;

    public ImgTabAdapter(List<Diary> items) { this.items = items; }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemImageView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new ViewHolder(itemImageView);
    }

//    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Diary item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgZone;

        public ViewHolder( View itemView) {
            super(itemView);
            imgZone = itemView.findViewById(R.id.imgZone);
        }

        public void setItem(Diary item){
//            imgZone.setImageResource(item.getImage());
        }
    }
}
