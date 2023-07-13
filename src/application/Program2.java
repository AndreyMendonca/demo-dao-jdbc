package application;


import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		DepartmentDao department = DaoFactory.createDepartmentDao();
		
		/*
		System.out.println("===Test 1: Department Insert===");
		Department dep = new Department(null,"Adm");
		department.insert(dep);
		System.out.println("Insert id: " + dep.getId()); */
		
		System.out.println();
		System.out.println("===Test 2: Department findById===");
		Department dep = department.findById(10);
		System.out.println(dep);
		
		System.out.println();
		System.out.println("===Test 2: Department findAll===");
		List<Department> list = department.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println();
		System.out.println("===Test 2: Department DeletById===");
		Scanner sc = new Scanner(System.in);
		System.out.print("How id delete: ");
		int id = sc.nextInt();
		department.deleteById(id);
		System.out.println("DELETE!");
		sc.close();
		
		System.out.println();
		System.out.println("===Test 2: Department Upgrade===");
		dep.setName("ADM UPGRADE");
		department.update(dep);
		System.out.println("UPGRADE!");
		
	}
}
