package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("===Test 1: Seller findById===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n===Test 2: Seller findByDepartment===");
		Department dep = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n===Test 3: Seller findAll===");
		list = sellerDao.findAll();
		for(Seller s : list) {
			System.out.println(s);
		}
		
		System.out.println("\n===Test 4: Seller Insert===");
		Seller newSeller = new Seller(null,"Greg","greg@gmail",new Date(),3000.00,dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted!! New ID = " + newSeller.getId());
		
		System.out.println("\n===Test 5: Seller UpDate===");
		seller = sellerDao.findById(1);
		seller.setName("Andrey Update");
		sellerDao.update(seller);
		System.out.println("UpDate!!");
		
		System.out.println("\n===Test 6: Seller deteleById===");
		Scanner sc = new Scanner(System.in);
		System.out.print("How id delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete!!");
		sc.close();
	}

}
