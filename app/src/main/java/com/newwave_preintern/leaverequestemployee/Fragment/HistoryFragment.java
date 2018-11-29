package com.newwave_preintern.leaverequestemployee.Fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.newwave_preintern.leaverequestemployee.Adapter.HistoryAdapter;
import com.newwave_preintern.leaverequestemployee.Model.Employee;
import com.newwave_preintern.leaverequestemployee.Model.Request;
import com.newwave_preintern.leaverequestemployee.Model.RequestList;
import com.newwave_preintern.leaverequestemployee.R;
import com.newwave_preintern.leaverequestemployee.ViewModel.RequestViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryFragment extends Fragment {

    @BindView(R.id.recyclerviewHistory)
    RecyclerView recyclerView;

    private Employee employee;
    private HistoryAdapter historyAdapter;
    private RequestViewModel requestViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        ButterKnife.bind(this,view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        addData();
        return view;
    }

    private void addData()
    {
        employee = (Employee) getActivity().getIntent().getSerializableExtra("employee");
        requestViewModel = ViewModelProviders.of(getActivity()).get(RequestViewModel.class);
        requestViewModel.getRequestHistory(getContext(), employee.getEmployeeId())
                .observe(getActivity(), requestList ->
                {
                    historyAdapter = new HistoryAdapter(requestList.getRequestList(), getContext());
                    historyAdapter.setData(requestList.getRequestList());
                    recyclerView.setAdapter(historyAdapter);
                });
    }

}
