package sample.Service;

import org.hibernate.Session;
import sample.Classes.Country;
import sample.Classes.Target;
import sample.Hibernate.HibernateUtil;

import java.util.List;

/**
 * Created by Zinoviy on 29.05.16.
 */
public class TargetDAO {
    public static void add(String target) {
        boolean a = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Target> list = session.createQuery("from Target").list();
        for(Target next : list)
        {
            if(next.getTarget().equals(target)) a = true;
        }
        if(a == false)
        {
            System.out.println("Add target");
            session.save(new Target(target));
        }
        else
        {

            System.out.println("Don`t add target. Target is already added");
        }
        session.getTransaction().commit();

    }
    public static void delete(long id)
    {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Target target = (Target) session.get(Target.class, id);
            session.delete(target);
            session.flush();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Inncorect id");
        }
    }

}
