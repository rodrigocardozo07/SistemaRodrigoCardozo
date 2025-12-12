/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RtcVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jaque
 */
public class Rtc_VendasDAO extends Rtc_AbstractDAO{
     @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcVendas.class);
        criteria.add(Restrictions.eq("rtcIdvenda", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listStatus(String status) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcVendas.class);
        criteria.add(Restrictions.like("rtcStatusvenda", "%"+status+"%") );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
      public Object listTotal(double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcVendas.class);
        criteria.add(Restrictions.ge("rtcTotal", total) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
       public Object listStatusTotal(String status, double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcVendas.class);
        criteria.add(Restrictions.like("rtcStatusvenda", "%"+status+"%") );
        criteria.add(Restrictions.ge("rtcTotal", total) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
}
