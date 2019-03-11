package com.gl.login.com.gl.login.dao;

import com.gl.login.R;
import com.gl.login.com.gl.login.model.Employee;

import java.util.ArrayList;

public class EmployeeData {
    /**
     * Added Data In Employee
     *
     */
   public static ArrayList<Employee> addEmployeeDetails(){
       ArrayList<Employee> employeeList = new ArrayList<>();
       employeeList.add(new Employee("Ragini Jain","Java Developer", R.drawable.girl6,"Global Logic"));
       employeeList.add(new Employee("Swati Khobragade","Java Developer",R.drawable.girl8,"TCS"));
       employeeList.add(new Employee("Komal Nistane","Manager",R.drawable.girl_image2,"Tech Mahindra"));
       employeeList.add(new Employee("Ajit Pawar","Android Developer",R.drawable.boy1,"Persistent"));
      // employeeList.add(new Employee("Vishal Jha","Automation Tester",R.drawable.boy3,"Infosys"));
       employeeList.add(new Employee("Richa Bedre","HR",R.drawable.girl_image1,"HCL"));
       employeeList.add(new Employee("Pankaj Jain","CA",R.drawable.boy2,"Infocept"));
       employeeList.add(new Employee("Rahul Sharma","UI Developer",R.drawable.boy4,"All India Reporter"));
       return employeeList;
   }


}
