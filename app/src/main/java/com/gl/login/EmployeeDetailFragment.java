package com.gl.login;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gl.login.com.gl.login.dao.EmployeeData;
import com.gl.login.com.gl.login.model.Employee;

public class EmployeeDetailFragment extends Fragment {

    private TextView mEmployeeName;
    private ImageView mEmployeeImageView;
    private TextView mEmployeeDesignation;
    private TextView mEmployeeLastCompany;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_detail,container,false);
        initViews(view);
        Intent intent = getActivity().getIntent();
        String position = intent.getStringExtra("position");
        if(position!= null){
            int number = Integer.parseInt(position);
            Employee employee = EmployeeData.addEmployeeDetails().get(number);
            mEmployeeName.setText(employee.getName());
            mEmployeeImageView.setImageResource(employee.getImage());
            mEmployeeDesignation.setText(employee.getDesignation());
            mEmployeeLastCompany.setText(employee.getCompany());
        }

        return view;
    }

    /**
     * INIT view
     *
     */
    private void initViews(View view) {
        mEmployeeName = view.findViewById(R.id.nameTextDetails);
        mEmployeeImageView = view.findViewById(R.id.imageDetailsView);
        mEmployeeDesignation= view.findViewById(R.id.employeeDesignation);
        mEmployeeLastCompany=view.findViewById(R.id.companyTextView);
    }

}
