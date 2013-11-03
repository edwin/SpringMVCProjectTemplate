package id.go.pajak.springmvc.service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 *  ini class yang akan digunakan sebagai base class atau class induk yang akan di-extends oleh class lain dibawah 
 *  package service
 * 
 * @author edwin < edwinkun at gmail dot com >
 */
public abstract class BaseService {

    protected SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
    
    public abstract void saveOrUpdate(Object o) throws Exception;
    public abstract List<String[]> select(int start, int end, String orderby, String search);
    public abstract Object select(String id);
    public abstract void delete(Object o) throws Exception;
    
    public abstract long getSize(String search);
}
