package com.newwave_preintern.leaverequestemployee.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.newwave_preintern.leaverequestemployee.Activity.LeaveFormActivity;
import com.newwave_preintern.leaverequestemployee.Activity.Tab;
import com.newwave_preintern.leaverequestemployee.Model.Employee;
import com.newwave_preintern.leaverequestemployee.R;
import com.newwave_preintern.leaverequestemployee.ViewModel.EmployeeViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RemainLeavesFragment extends Fragment {

    @BindView(R.id.imgHeart1) ImageView heart1;
    @BindView(R.id.imgHeart2) ImageView heart2;
    @BindView(R.id.imgHeart3) ImageView heart3;
    @BindView(R.id.imgHeart4) ImageView heart4;
    @BindView(R.id.imgHeart5) ImageView heart5;
    @BindView(R.id.imgHeart6) ImageView heart6;
    @BindView(R.id.imgHeart7) ImageView heart7;
    @BindView(R.id.imgHeart8) ImageView heart8;
    @BindView(R.id.imgHeart9) ImageView heart9;
    @BindView(R.id.imgHeart10) ImageView heart10;
    @BindView(R.id.imgHeart11) ImageView heart11;
    @BindView(R.id.imgHeart12) ImageView heart12;

    @BindView(R.id.tvRemainNo) TextView remainLeave;

    ArrayList<ImageView> imageList;

    private Employee employee;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_reamin_leaves, container, false);

        ButterKnife.bind(this, view);

        employee = (Employee) getActivity().getIntent().getSerializableExtra("employee");
        setImage(employee.getEmployeeRemainingLeave(), view);
        remainLeave.setText(employee.getEmployeeRemainingLeave()+"");

        return view;

    }

    @OnClick(R.id.btLeave)
    public void btLeave()
    {
        Intent intent = new Intent(getContext(), LeaveFormActivity.class);
        employee = (Employee) getActivity().getIntent().getSerializableExtra("employee");
        intent.putExtra("employeeId", employee.getEmployeeId());
        intent.putExtra("employeeName", employee.getEmployeeName());
        intent.putExtra("remainLeave", employee.getEmployeeRemainingLeave());
        startActivity(intent);
    }

    private void setImage(int i, View view) {

        ButterKnife.bind(this, view);

        imageList = new ArrayList<>();
        imageList.add(heart1);
        imageList.add(heart2);
        imageList.add(heart3);
        imageList.add(heart4);
        imageList.add(heart5);
        imageList.add(heart6);
        imageList.add(heart7);
        imageList.add(heart8);
        imageList.add(heart9);
        imageList.add(heart10);
        imageList.add(heart11);
        imageList.add(heart12);

        for(int j=0; j<i ; j++)
        {
            imageList.get(j).setImageDrawable(getResources().getDrawable(R.drawable.heart));
        }


    }
}
