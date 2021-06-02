package org.ict.myday;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {

    private ArrayList<String> mData = null;

    // 생성자에서 데이터 리스트 객체를 전달받음
    SimpleTextAdapter(ArrayList<String> list){
        mData = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleTextAdapter.ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.title.setText(text);
        holder.content.setText(text);
    }

    @Override
    public int getItemCount() {
        return mData.size();

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        mData.set(pos,"item clicked.pos=" + pos);

                        notifyItemChanged(pos);

                //뷰 객체에 대한 참조
                title = itemView.findViewById(R.id.title);
                content = itemView.findViewById(R.id.content);
                    }
                }
          });
        }
    }
}



