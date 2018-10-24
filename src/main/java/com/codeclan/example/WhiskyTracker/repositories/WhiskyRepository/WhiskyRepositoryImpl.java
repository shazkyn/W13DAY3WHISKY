package com.example.whiskytracker.repositories.whisky;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.plaf.synth.Region;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements com.example.whiskytracker.repositories.whisky.WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Whisky> findWhiskiesByYear(int year) {

        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);

        // Using Criteria

//        Criteria criteria = session.createCriteria(Whisky.class);
//        criteria.add(Restrictions.eq("year", year));
//        whiskies = criteria.list();

        // Using criteriaBuilder
        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Whisky> criteriaQuery = criteriaBuilder.createQuery(Whisky.class);
            Root<Whisky> whiskyRoot = criteriaQuery.from(Whisky.class);
            criteriaQuery.select(whiskyRoot).where(criteriaBuilder.equal(whiskyRoot.get("year"), year));
            TypedQuery<Whisky> query = session.createQuery(criteriaQuery);
            whiskies = query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return whiskies;
    }

    @Override
    @Transactional
    public List<Whisky> findWhiskiesByRegion(Region region) {

        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            //  SELECT * FROM whiskies WHERE whiskies.distillery_id IN (SELECT id FROM distilleries WHERE distilleries.region = 1);
            Criteria criteria = session.createCriteria(Whisky.class);
            Criteria distilleryCriteria = criteria.createCriteria("distillery");
            distilleryCriteria.add(Restrictions.eq("region", region));
            whiskies = criteria.list();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return whiskies;
    }

    @Override
    @Transactional
    public List<Whisky> findWhiskiesByAgeAndRegion(int age, Region region) {

        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Whisky.class);
            criteria.add(Restrictions.eq("age", age));
            Criteria distilleryCriteria = criteria.createCriteria("distillery");
            distilleryCriteria.add(Restrictions.eq("region", region));
            whiskies =  criteria.list();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return whiskies;
    }
}

