package bl;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionUtil {

    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Session openSession() {
        System.err.println("!!!!!!!!!!: " + HibernateUtil.getSessionFactory()) ;
        System.err.println("!!!!!!!!!!: " + HibernateUtil.getSessionFactory().openSession()) ;

        return HibernateUtil.getSessionFactory().openSession();
    }

    public Session openTransactionSession() {
        session = openSession();

        if(session == null) {
            System.out.println("NULL");
        } else {
            System.out.println("IS NOT NULL ");
        }

        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeTransactionSession() {
        transaction.commit();
        closeSession();
    }
}