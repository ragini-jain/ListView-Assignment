package com.gl.login.com.gl.login.model;

public class Employee{

    private String name;
    private String designation;
    private int image;
    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Employee(String name, String designation, int image,String comapny) {
        this.name = name;
        this.designation = designation;
        this.image = image;
        this.company=comapny;
    }
    public Employee(){}
}
