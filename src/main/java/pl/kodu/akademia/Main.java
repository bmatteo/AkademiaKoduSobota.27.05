package pl.kodu.akademia;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.kodu.akademia.entities.Customer;
import pl.kodu.akademia.entities.CustomerB2B;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) {
        factory = new Configuration().configure().buildSessionFactory();

        /*Customer customer1 = new Customer();
        customer1.setName("Gracjan");
        customer1.setSurname("Zwierzyniec");
        customer1.setNationality("Korea");

        System.out.println(Main.persistCustomer(customer1));*/

        /*ArrayList<Customer> list = Main.getCustomerList();

        for (Customer c : list) {
            System.out.println(c.getId() + " " + c.getName() + " " + c.getSurname() + " " + c.getNationality());
        }*/

        CustomerB2B customerB2B = new CustomerB2B();
        customerB2B.setName("AkademiaKodu");
        customerB2B.setNip("871236587234");
        customerB2B.setNationality("Poland");

        System.out.println(Main.addCustomerB2B(customerB2B));

        System.exit(0);
    }

    public static Integer persistCustomer(Customer customer) {
        Session session = Main.factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(customer);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return id;
    }

    public static ArrayList<Customer> getCustomerList() {
        Session session = Main.factory.openSession();
        Transaction tx = null;
        ArrayList<Customer> customers = new ArrayList<Customer>();

        try {
            tx = session.beginTransaction();
            List customerTemp = session.createQuery("FROM pl.kodu.akademia.entities.Customer WHERE id = 5").list();
            for (Iterator iterator = customerTemp.iterator(); iterator.hasNext();) {
                Customer c = (Customer) iterator.next();
                customers.add(c);
            }
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return customers;
    }

    public static Integer addCustomerB2B(CustomerB2B customerB2B) {
        Session session = Main.factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            id = (Integer) session.save(customerB2B);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return id;
    }
}
