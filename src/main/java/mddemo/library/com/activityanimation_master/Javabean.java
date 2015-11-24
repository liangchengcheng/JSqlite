package mddemo.library.com.activityanimation_master;

import com.esri.core.geometry.Polyline;

import java.io.Serializable;

/**
 * Created by chengcheng on 2015/11/23.
 */
public class Javabean implements Serializable{

    private String id;

    private String tablename;

    private String sign;

    private Polyline line;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Polyline getLine() {
        return line;
    }

    public void setLine(Polyline line) {
        this.line = line;
    }
}
