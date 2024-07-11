package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
               
        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== TEST 1: seller findBy id ===");
        Seller seller  = sellerDao.findById(3);
        System.out.println(seller);
        
        System.out.println("\n=== TEST 2: seller findBy Department ===");
        Department d = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(d);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        System.out.println("\n=== TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "gerg@gmail.com", new Date(), 4000.0, d);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId() );
        
        System.out.println("\n=== TEST 5: seller insert ===");
        seller  = sellerDao.findById(1);
        seller.setName("Martha Waine");
        seller.setEmail("martha@gmail.com");
        sellerDao.update(seller);
        System.out.println("Uptade completed!");

        System.out.println("\n=== TEST 6: seller delete ===");
        sellerDao.delete(11);
        System.out.println("Delete completed!");
    }
}
