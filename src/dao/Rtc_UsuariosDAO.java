/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.RtcUsuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u09240620109
 */
public class Rtc_UsuariosDAO extends Rtc_AbstractDAO{

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
        Criteria criteria = session.createCriteria(RtcUsuario.class);
        criteria.add(Restrictions.eq("rtcIdusuarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcUsuario.class);
        criteria.add(Restrictions.like("rtcNome", "%"+nome+"%") );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listAtivo(String ativo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcUsuario.class);
        criteria.add(Restrictions.like("rtcAtivo", "%"+ativo+"%") );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

     public Object listNomeAtivo(String nome, String ativo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcUsuario.class);
        criteria.add(Restrictions.like("rtcNome", "%"+nome+"%") );
        criteria.add(Restrictions.ge("rtcAtivo", ativo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(RtcUsuario.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listLogin(String username, String senha) {
        session.beginTransaction();

        Criteria criteria = session.createCriteria(RtcUsuario.class);
        criteria.add(Restrictions.eq("rtcApelido", username));
        criteria.add(Restrictions.eq("rtcSenha", senha));

        RtcUsuario usuario = (RtcUsuario) criteria.uniqueResult();

        session.getTransaction().commit();
        return usuario;
    }
    
    public static void main(String[] args) {
        Rtc_UsuariosDAO usuariosDAO = new Rtc_UsuariosDAO();
        usuariosDAO.listAll();
        System.out.println("teste ok");
    }
    
}
