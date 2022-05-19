package com.run;

import com.Utis.Categoryroom;
import com.Utis.Client;
import com.Utis.NewHibernateUtil;
import com.Utis.Zaselenie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        List<Client> clients = s.createQuery("from Client client where client.id in (select id from Bronirovanie" +
                " bron where bron.cost < :cost)").setParameter("cost", 90.0).list();
        for (Client client : clients) {
            System.out.println("Фамилия: " + client.getName() + ", email: " + client.getEmail());
        }
        t.commit();

        Transaction t1 = s.beginTransaction();
        List<Categoryroom> categoryrooms = s.createQuery("from Categoryroom catr where catr.id in (select id from" +
                " Room room where room.status = :status)").setParameter("status", "free").list();
        for (Categoryroom categoryroom : categoryrooms) {
            System.out.println("Тип комнаты: " + categoryroom.getCategory() + ", номер команты: " + categoryroom.getId() + ", количество мест: " + categoryroom.getCountmest());
        }
        t1.commit();


        Transaction t2 = s.beginTransaction();
        List<Zaselenie> zaselenies = s.createQuery("from Zaselenie zas where zas.idOplata in (select id from" +
                " Oplata oplata where oplata.dataoplata in (select max(op.dataoplata) from Oplata op where" +
                " op.forma = :forma))").setParameter("forma", "non-cash").list();
        for (Zaselenie zaselenie : zaselenies) {
            System.out.println("Дата бронирования: " + zaselenie.getDatabroni() + ", фамилия клиента: " +
                    zaselenie.getIdClient().getName() + ", комната:" + zaselenie.getRoom());
        }
        t2.commit();


        s.close();
        sf.close();
    }
}
