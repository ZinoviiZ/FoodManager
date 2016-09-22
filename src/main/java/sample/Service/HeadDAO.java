package sample.Service;

import org.hibernate.Session;
import sample.Classes.*;
import sample.Classes.Producer;
import sample.Hibernate.HibernateUtil;

import java.util.List;

/**
 * Created by Zinoviy on 29.05.16.
 */
public class HeadDAO {
    public static void add(String name, String info, String using, int price, Producer producer, Packing packing, Kind kind, Target target) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean h = false;
        Head head = new Head(name, info, using, price, producer, packing, kind, target);

        List<Head> listHead = session.createQuery("from head").list();
        List<Kind> kindList = session.createQuery("from Kind").list();
        List<Packing> packingList = session.createQuery("from Packing").list();
        List<Producer> producersList = session.createQuery("from Producer").list();
        List<Target> targetList = session.createQuery("from Target").list();
        for(Head next : listHead)
        {
            if(head.getName().equals(next.getName()) && head.getInfo().equals(next.getInfo()) && head.getUsing().equals(next.getUsing()) &&
                    head.getPrice() == next.getPrice() && head.getProducer().getRating() == next.getProducer().getRating() &&
                    head.getProducer().getFirm().equals(next.getProducer().getFirm()) && head.getProducer().getCountry().getCountry().equals(next.getProducer().getCountry().getCountry())
                && head.getPacking().getWeight() == next.getPacking().getWeight() && head.getPacking().getPacking().equals(next.getPacking().getPacking()) &&
                    head.getKind().getKind().equals(next.getKind().getKind()) && head.getTarget().getTarget().equals(next.getTarget().getTarget()))
            {
                h = true;
                break;
            }
        }


        if( h == false)
        {
                for(Kind next : kindList)
                {
                    if(next.getKind().equals(kind.getKind()))
                    {
                        kind = next;
                        break;
                    }
                }

                for(Packing next : packingList)
                {
                    if(next.getPacking().equals(packing.getPacking()) && next.getWeight() == packing.getWeight())
                    {
                        packing = next;
                        break;
                    }
                }


                for(Producer next : producersList)
                {
                    if(next.getCountry().getCountry().equals(producer.getCountry().getCountry()) &&
                            next.getFirm().equals(producer.getFirm()) && next.getRating() == producer.getRating())
                    {
                        producer = next;
                        break;
                    }
                }


                for(Target next : targetList)
                {
                    if(next.getTarget().equals(target.getTarget()))
                    {
                        target = next;
                        break;
                    }
                }

            System.out.println("Add head");
            System.out.println(producer);
            System.out.println(packing);
            System.out.println(kind);
            System.out.println(target);
            session.save(new Head(name, info, using, price, producer, packing, kind, target));
        }
        else {
            System.out.println("Dont add head. Head is already created");
        }
        System.out.println();
        session.getTransaction().commit();
    }
    public static void delete(long id)
    {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Head head = (Head) session.get(Head.class, id);
            session.delete(head);
            session.flush();
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.out.println("Inncorect id");
        }
    }

}
