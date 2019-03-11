package com.gl.login.com.gl.login.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gl.login.R;

import java.util.ArrayList;

public class Adapter extends BaseAdapter implements View.OnClickListener{

    Context context;
    private ArrayList<Employee> employees;
    LayoutInflater layoutInflater = null;


    public Adapter(Context context,ArrayList<Employee> employees){
      //  super(context, R.layout.row_item, employees);
       this.context = context;
       this.employees = employees;
       layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return employees.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView ==  null){
            convertView = inflater.inflate(R.layout.fragment_employee_list,null);
        }
        TextView  nameText = convertView.findViewById(R.id.employeeTextView);
        ImageView imageView = convertView.findViewById(R.id.imageViewInfo);
        TextView designation = convertView.findViewById(R.id.designationTextView);
        nameText.setText(employees.get(position).getName());
        designation.setText(employees.get(position).getDesignation());
        imageView.setImageResource(employees.get(position).getImage());
        return convertView;
    }

    @Override
    public void onClick(View v) {

    }
}
