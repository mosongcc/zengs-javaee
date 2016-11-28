package com.zengs.commons.util;

import java.util.Date;

/**
 * Created by songz on 2016/10/27.
 */
public class Person extends User {

    private int id;
    private String name;
    private Date cdate;
/*

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
