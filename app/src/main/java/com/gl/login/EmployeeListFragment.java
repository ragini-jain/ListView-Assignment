package com.gl.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.gl.login.com.gl.login.dao.EmployeeData;
import com.gl.login.com.gl.login.model.Adapter;

public class EmployeeListFragment extends Fragment{
    public EmployeeListFragment(){}
    private ListView mEmployeeListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_employee,container,false);
        mEmployeeListView =view.findViewById(R.id.employeeListView);
        mEmployeeListView.setAdapter(new Adapter(getActivity(), EmployeeData.addEmployeeDetails()));
        mEmployeeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity().getBaseContext(),EmployeeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("position",Integer.toString(position));
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}
