package utils;

import model.Point;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.List;

@Named("utils.PointDAO")
@SessionScoped
public class PointDAOImpl implements PointDAO, Serializable {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    @Resource
    private UserTransaction transaction;



    @Override
    public void insertPoint(Point point) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            transaction.begin();
            em.persist(point);
            transaction.commit();
        }
        catch (Exception e){
            try {
                transaction.rollback();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Point> getPoints() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return (List<Point>) em.createQuery("SELECT p from model.Point p").getResultList();
    }
}
