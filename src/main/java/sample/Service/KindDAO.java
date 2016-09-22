package sample.Service;

import org.hibernate.Session;
import sample.Classes.*;
import sample.Hibernate.HibernateUtil;

import java.util.List;

/**
 * Created by Zinoviy on 29.05.16.
 */
public class KindDAO {
    public static void add(String kind) {
        boolean a = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Kind> list = session.createQuery("from Kind").list();
        for(Kind next : list)
        {
            if(next.getKind().equals(kind)) a = true;
        }
        if(a == false)
        {
            System.out.println("Add kind");
            session.save(new Kind(kind));
        }
        else
        {

            System.out.println("Don`t add kind. Kind is already added");
        }
        session.getTransaction().commit();

    }
    public static void delete(long id)
    {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Kind kind = (Kind) session.get(Kind.class, id);
            session.delete(kind);
            session.flush();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Inncorect id");
        }
    }

}
