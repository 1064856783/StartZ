package test;

public class Employee{
   String name;
   int age;
   String designation;
   double salary;
   // Employee ��Ĺ�����
   public Employee(String name){
      this.name = name;
   }
   // ����age��ֵ
   public void empAge(int empAge){
      age =  empAge;
   }
   /* ����designation��ֵ*/
   public void empDesignation(String empDesig){
      designation = empDesig;
   }
   /* ����salary��ֵ*/
   public void empSalary(double empSalary){
      salary = empSalary;
   }
   /* ��ӡ��Ϣ */
   public void printEmployee(){
      System.out.println("Name:"+ name );
      System.out.println("Age:" + age );
      System.out.println("Designation:" + designation );
      System.out.println("Salary:" + salary);
   }
   
   public static void main(String args[]){
	      /* ʹ�ù����������������� */
	      Employee empOne = new Employee("James Smith");
	      Employee empTwo = new Employee("Mary Anne");

	      // ��������������ĳ�Ա����
	      empOne.empAge(26);
	      empOne.empDesignation("Senior Software Engineer");
	      empOne.empSalary(1000);
	      empOne.printEmployee();

	      empTwo.empAge(21);
	      empTwo.empDesignation("Software Engineer");
	      empTwo.empSalary(500);
	      empTwo.printEmployee();
	   }
}

	 
