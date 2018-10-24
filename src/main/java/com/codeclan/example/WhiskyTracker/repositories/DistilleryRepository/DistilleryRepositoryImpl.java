package com.example.whiskytracker.repositories.distillery;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.example.whiskytracker.models.Distillery;
import com.example.whiskytracker.models.Region;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Distillery> findDistilleriesByRegion(Region region) {

        List<Distillery> distilleries = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Distillery.class);
            criteria.add(Restrictions.eq("region", region));
            distilleries = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return distilleries;
    }

    @Override
    @Transactional
    public List<Distillery> findDistilleriesByAge(int age) {

        List<Distillery> distilleries = null;
        Session session = entityManager.unwrap(Session.class);

        // select * from distilleries where id in (select distillery_id from whiskies where age=12);
        try {
            Criteria criteria = session.createCriteria(Distillery.class);
            Criteria criteria1 = criteria.createCriteria("whiskies");
            criteria1.add(Restrictions.eq("age", 12));
            distilleries = criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }


        return distilleries;
    }
}
