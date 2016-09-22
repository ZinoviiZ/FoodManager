package sample.Service;

import org.hibernate.Session;
import sample.Classes.*;
import sample.Hibernate.HibernateUtil;

import java.util.List;

/**
 * Created by Zinoviy on 29.05.16.
 */
public class PackingDAO {
    public static void add(String packing,int weight) {
        boolean a = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Packing> list = session.createQuery("from Packing").list();
        for(Packing next : list)
        {
            if((next.getPacking().equals(packing)) && (next.getWeight() == weight)) a = true;
        }
        if(a == false)
        {
            System.out.println("Add packing");
            session.save(new Packing(packing,weight));
        }
        else
        {

            System.out.println("Don`t add packing. Packing is already added");
        }
        session.getTransaction().commit();

    }
    public static void delete(long id)
    {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Packing packing = (Packing) session.get(Packing.class, id);
            session.delete(packing);
            session.flush();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Inncorect id");
        }
    }

}
