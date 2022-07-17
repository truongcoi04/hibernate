package Vti.com.rw41.utils;

import Vti.com.rw41.entity.Product;
import Vti.com.rw41.entity.Student;
import Vti.com.rw41.entity.TestTable;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
public static SessionFactory getSessionFactory(){
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(TestTable.class);
            configuration.addAnnotatedClass(Student.class);
            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            return configuration.buildSessionFactory(registry);

}
}