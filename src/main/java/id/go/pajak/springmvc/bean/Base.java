package id.go.pajak.springmvc.bean;

import java.util.List;

/**
 *
 * @author edwin < edwinkun at gmail dot com >
 */
public class Base {

    private Integer sEcho;
    private Long iTotalRecords;
    private Long iTotalDisplayRecords;

    private List<String[]> aaData;
    
    public Base() {
    }

    public Integer getsEcho() {
        return sEcho;
    }

    public void setsEcho(Integer sEcho) {
        this.sEcho = sEcho;
    }

    
    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<String[]> getAaData() {
        return aaData;
    }

    public void setAaData(List<String[]> aaData) {
        this.aaData = aaData;
    }
    
}
