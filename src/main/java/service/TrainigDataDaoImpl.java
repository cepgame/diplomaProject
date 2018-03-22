package service;

import bl.SessionUtil;
import dao.TrainingDataDao;
import entity.PersonalData;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class TrainigDataDaoImpl extends SessionUtil implements TrainingDataDao {

    @Override
    public void add(PersonalData pd) {
        openTransactionSession();

        Session session = getSession();
        session.save(pd);

        closeTransactionSession();
    }

    @Override
    public List<PersonalData> getAll() {
        String sql = "SELECT * FROM \"Training_data\"";
        openTransactionSession();
        Session session = getSession();

        // Throws NoSuchMethodException on setMaxResult
        Query query = session.createNativeQuery(sql).addEntity(PersonalData.class).setCacheable(true).setMaxResults(100);
        List<PersonalData> trainingData = query.getResultList();

        closeTransactionSession();

        return trainingData;
    }

    @Override
    public void remove(PersonalData pd) {
        openTransactionSession();

        Session session = getSession();
        session.remove(pd);

        closeTransactionSession();
    }
}
