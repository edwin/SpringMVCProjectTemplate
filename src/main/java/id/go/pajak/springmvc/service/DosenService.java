package id.go.pajak.springmvc.service;

import id.go.pajak.springmvc.bean.Base;
import id.go.pajak.springmvc.bean.Dosen;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author edwin < edwinkun at gmail dot com >
 */
@Service("dosenService")
@Transactional
public class DosenService extends BaseService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveOrUpdate(Object o) throws Exception {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    @Override
    public List<String[]> select(int start, int end, String orderby, String search) {
        
        StringBuilder stringBuilder = new StringBuilder("from Dosen d where d.nama like :search");
        if(!search.equals("%"))
            search = "%"+search+"%";
        
        if(orderby != null)
            stringBuilder.append(" order by nik ").append(orderby);
        
        List<Dosen> dosens = sessionFactory.getCurrentSession().createQuery(stringBuilder.toString())
                .setString("search", search)
                .setFirstResult(start)
                .setMaxResults(end)
                .list();
        
        List<String[]> strings = new ArrayList<String[]>();
        for (Dosen dosen : dosens) {
            String[] ses = new String[3];
            ses[0] = dosen.getNik();
            ses[1] = dosen.getNama();
            ses[2] = dosen.getAlamat();
            
            strings.add(ses);
        }
        return strings;
    }
    
    @Override
    public Object select(String nik) {
        return (Dosen) sessionFactory.getCurrentSession().createQuery("from Dosen "
                + "where nik = :nik")
                .setString("nik", nik)
                .uniqueResult();
    }

    @Override
    public void delete(Object o) throws Exception {
        sessionFactory.getCurrentSession().delete(o);
    }

    @Override
    public long getSize(String search) {
        StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(d) FROM Dosen d where d.nama like :search");
        if(!search.equals("%"))
            search = "%"+search+"%";
        return (Long) sessionFactory.getCurrentSession().createQuery(stringBuilder.toString())
                .setString("search", search)
                .uniqueResult();
    }
}
