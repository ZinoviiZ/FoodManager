package sample.Service;

import org.hibernate.Session;
import sample.Classes.Country;
import sample.Hibernate.HibernateUtil;

import java.util.List;

/**
 * Created by Zinoviy on 29.05.16.
 */
public class CountryDAO {
    public static void add(String country) {
        boolean a = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Country> list = session.createQuery("from Country").list();
        for(Country next : list)
        {
            if(next.getCountry().equals(country)) a = true;
        }
        if(a == false)
        {
            System.out.println("Add country");
            session.save(new Country(country));
        }
        else
        {

            System.out.println("Don`t add country. Country is already added");
        }
        session.getTransaction().commit();

    }
    public static void delete(long id)
    {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Country country = (Country) session.get(Country.class, id);
            session.delete(country);
            session.flush();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Inncorect id");
        }
    }

}
