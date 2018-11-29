package com.newwave_preintern.leaverequestemployee.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.newwave_preintern.leaverequestemployee.Activity.HistoryDetailActivity;
import com.newwave_preintern.leaverequestemployee.Model.Request;
import com.newwave_preintern.leaverequestemployee.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private static List<Request> requestList;
    private Context context;
    private Request requestIntent;

    public HistoryAdapter(List<Request> requestList, Context context) {
        this.requestList = requestList;
        this.context = context;
        notifyDataSetChanged();
    }

    public void setData(List<Request> list)
    {
        this.requestList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history_cardview_listiems, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Request request = requestList.get(i);
        Integer days = request.getRequestTotalDays();

        myViewHolder.historyDate.setText(request.getRequestCreatedDate().substring(0, 10));
        myViewHolder.historyNoOfLeaveDays.setText(days.toString());
        myViewHolder.historyReason.setText(request.getRequestReason());
        myViewHolder.historyStartDate.setText(request.getRequestStartDate().substring(0, 10));
        myViewHolder.historyEndDate.setText(request.getRequestEndDate().substring(0, 10));
        if(request.getRequestDetermine().equals("accept"))
        {
            myViewHolder.imgHistoryDecision.setImageResource(R.drawable.ic_leave_accept);
        }
        else if (request.getRequestDetermine().equals("pending"))
        {
            myViewHolder.imgHistoryDecision.setImageResource(R.drawable.ic_request_pending);
        }
        else myViewHolder.imgHistoryDecision.setImageResource(R.drawable.ic_leave_denied);
        myViewHolder.view.setOnClickListener(view ->
        {
            requestIntent = new Request(request.getRequestEmployeeId(),request.getRequestTotalDays(),request.getRequestStartDate(),
                    request.getRequestEndDate(), request.getRequestReason(), request.getRequestDetermine(), request.getRequestHelpingEmpId(),
                    request.getRequestExplained(),request.getRequestAssignTask(),request.getRequestCreatedDate(),request.getRequestUpdateDate());

            Intent intent = new Intent(context, HistoryDetailActivity.class);
            intent.putExtra("decision", request.getRequestDetermine());
            intent.putExtra("request", requestIntent);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.tvHistoryDate) TextView historyDate;
        @BindView(R.id.tvHistoryNoOfLeaveDays) TextView historyNoOfLeaveDays;
        @BindView(R.id.tvHistoryReason) TextView historyReason;
        @BindView(R.id.tvHistoryStartDate) TextView historyStartDate;
        @BindView(R.id.tvHistoryEndDate) TextView historyEndDate;
        @BindView(R.id.imgHistoryDecisionCard) ImageView imgHistoryDecision;

        public View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }

    }
}
