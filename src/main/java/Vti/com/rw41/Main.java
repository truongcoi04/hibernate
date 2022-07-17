package Vti.com.rw41;

import Vti.com.rw41.entity.Product;
import Vti.com.rw41.entity.Student;
import Vti.com.rw41.entity.TestTable;
import Vti.com.rw41.enumurations.ProductStatus;
import Vti.com.rw41.repository.ProductRepository;
import Vti.com.rw41.utils.HibernateUtils;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {
//testInsert();
//testSelectandUpdate();
//testDelete();



//        List<Product> result = ProductRepository.findByName("Bò Húc");
//        for (Product product : result) {
//            System.out.println(product);
//        }



//        Session session = HibernateUtils.getSessionFactory().openSession();
//        session.beginTransaction();
//        for (int i = 0; i < 50; i++) {
//            TestTable testTable = new TestTable();
//            testTable.setName("Hihi" + i);
//            session.saveOrUpdate(testTable);
//        }
//        session.getTransaction().commit();

        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = new Student();
        student.setName("Hihi");
        session.saveOrUpdate(student);
        session.getTransaction().commit();





    }


    static  void testDelete() {
        Product product = ProductRepository.findById(1);
        if (product != null) {
            ProductRepository.delete(product);
        }
    }

    static  void testSelectandUpdate() {
        Product product = ProductRepository.findById(2);
        if (product != null) {
            product.setPrice(2.0);
            product.setProductName("Bò Húc");
            product.setStatust(ProductStatus.HOANTHANH);
            ProductRepository.saveOrUpdate(product);
        }
    }
    static void testInsert() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = new Product();
        product.setProductName("Cocacola");
        product.setPrice(1.0);
        product.setStatust(ProductStatus.CHUAHOANTHANH);
        product.setCreatedDate(LocalDateTime.now());
        session.saveOrUpdate(product);
        session.getTransaction().commit();
    }
}