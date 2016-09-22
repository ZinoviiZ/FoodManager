package sample.Service;

import org.hibernate.Session;
import sample.Classes.*;
import sample.Hibernate.HibernateUtil;

import java.util.List;

/**
 * Created by Zinoviy on 29.05.16.
 */
public class ProducerDAO {
    public static void add(String firm, int rating, Country country) {
        boolean a = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Producer> list = session.createQuery("from Producer").list();
        for(Producer next : list)
        {
            if(next.getFirm().equals(firm) && next.getCountry().getCountry().equals(country.getCountry()) && (next.getRating() == rating)) a = true;
        }
        if(a == false)
        {
            System.out.println("Add producer");
            Country country1 = null;
            boolean b = false;

                List<Country> listC = session.createQuery("from Country").list();
                for(Country next : listC)
                {
                    if(next.getCountry().equals(country.getCountry()))
                    {
                        b = true;
                        country1 = next;
                        break;
                    }
                }
                if(b == false)
                {
                    System.out.println("Add country");
                    session.save(new Producer(firm,rating,country));

                }
                else
                {
                    session.save(new Producer(firm,rating,country1));
                    System.out.println("Don`t add country. Country is already added");
                }
        }
        else
        {
            System.out.println("Don`t add producer. Producer is already added");
        }
        session.getTransaction().commit();

    }
    public static void delete(long id)
    {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Producer producer = (Producer) session.get(Producer.class, id);
            session.delete(producer);
            session.flush();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Inncorect id");
        }
    }

}
