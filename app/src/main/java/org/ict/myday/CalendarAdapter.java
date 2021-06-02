package org.ict.myday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import org.ict.myday.Model.CalendarHeader;
import org.ict.myday.Model.Day;
import org.ict.myday.Model.EmptyDay;
import org.ict.myday.Model.ViewModel;

import java.util.Calendar;
import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter {

    private final int HEADER_TYPE = 0;
    private final int EMPTY_TYPE = 1;
    private final int DAY_TYPE = 2;

    private List<Object> mCalendarList;

    public CalendarAdapter(List<Object> calendarList) {
        mCalendarList = calendarList;
    }

    public void setCalendarList(List<Object> calendarList){
        mCalendarList = calendarList;
        notifyDataSetChanged(); // 리스트를 갱신하기 위해 사용
    }

    @Override
    public int getItemViewType(int position){ // 뷰타입 나누기
        Object item = mCalendarList.get(position);
        if (item instanceof Long) {
            return HEADER_TYPE; // 날짜 타입
        } else if (item instanceof String) {
            return EMPTY_TYPE; // 비어있는 날짜 타입
        } else {
            return DAY_TYPE; // 일자 타입
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // 날짜 타입
        if (viewType == HEADER_TYPE) {
            HeaderViewHolder viewHolder =
                    new HeaderViewHolder(inflater.inflate(
                            R.layout.item_cal_header, parent, false));

            StaggeredGridLayoutManager.LayoutParams params =
                    (StaggeredGridLayoutManager.LayoutParams)viewHolder.itemView.getLayoutParams();
            params.setFullSpan(true); // span 하나로 통합
            viewHolder.itemView.setLayoutParams(params);

            return viewHolder;
        } else if (viewType == EMPTY_TYPE) {
            return new EmptyViewHolder(inflater.inflate(
                    R.layout.item_cal_empty, parent, false));
        } else {
            return new DayViewHolder(inflater.inflate(
                    R.layout.item_cal_day, parent, false));
        }

    }

    // 데이터 넣어서 완성시키는 것것
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        if (viewType == HEADER_TYPE) {
            HeaderViewHolder viewHolder = (HeaderViewHolder) holder;
            Object item = mCalendarList.get(position);
            CalendarHeader model = new CalendarHeader();

            // long type의 현재시간
            if (item instanceof Long) {
                // 현재시간 넣으면, 패턴에 맞게 model에 데이터 들어감(2021년 5월)
                model.setHeader((Long)item);
            }
            // view에 표시
            viewHolder.bind(model);
        } else if (viewType == EMPTY_TYPE) {
            EmptyViewHolder viewHolder = (EmptyViewHolder) holder;
            EmptyDay model = new EmptyDay();
            viewHolder.bind(model);
        } else if (viewType == DAY_TYPE) {
            DayViewHolder viewHolder = (DayViewHolder) holder;
            Object item = mCalendarList.get(position);
            Day model = new Day();
            if (item instanceof Calendar) {
                // Model에 Calendar값을 넣어서 몇일인지 데이터 너힉
                model.setCalendar((Calendar) item);
            }
            // Model의 데이터를 View에 표현
            viewHolder.bind(model);
        }
    }


    @Override
    public int getItemCount() {
        if (mCalendarList != null) {
            return mCalendarList.size();
        }
        return 0;
    }

    /* viewHolder */
    private class HeaderViewHolder extends RecyclerView.ViewHolder { // 날짜 타입 ViewHolder

        TextView itemHeaderTitle;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            initView(itemView);
        }

        public void initView(View v){
            itemHeaderTitle = (TextView)v.findViewById(R.id.item_header_title);
        }

        public void bind(ViewModel model){
            // 일자 값 가져오기
            String header = ((CalendarHeader)model).getHeader();
            // header에 표시하기
            itemHeaderTitle.setText(header);
        }
    }

    private class EmptyViewHolder extends RecyclerView.ViewHolder { // 비어있는 요일 타입 ViewHolder
        public EmptyViewHolder(@NonNull View itemView){
            super(itemView);
            initView(itemView);
        }
        public void initView(View v){

        }
        public void bind(ViewModel model){

        }
    }

    private class DayViewHolder extends RecyclerView.ViewHolder { // 요일 타입 ViewHolder
        TextView itemDay;

        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        public void initView(View v){
            itemDay = (TextView)v.findViewById(R.id.item_day);
        }

        public void bind(ViewModel model) {
            // 일자 값 가져오기
            String day = ((Day)model).getDay();
            // 일자 값 View에 보이게하기
            itemDay.setText(day);
        }
    }
}
