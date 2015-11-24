package mddemo.library.com.activityanimation_master;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.esri.core.geometry.Polyline;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import mddemo.library.com.dao.Dao;
import mddemo.library.com.db.DaoFactory;
import mddemo.library.com.db.SqlSet;
import mddemo.library.com.db.SqlSetConfiguration;

/**
 * 最简单的就是直接执行DBConnection 里面的open和execSQL（sql语句即可）
 */
public class MainActivity extends AppCompatActivity {
    private String extrernalPath = Environment.getExternalStorageDirectory().getPath();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        copyBigDataToSD();
    }

    /**
     * 测试增加语句
     * @param javabeans bean
     */
    private void Insert(Javabean javabeans ){
        SqlSet sqlSet=SqlSetConfiguration.getSqlSet(getSqlstr(getJavaBean()),null);
        Dao dao = DaoFactory.getDao(MainActivity.this, getConfig(), sqlSet);
        int a = dao.exesql();
    }

    private void Delete(){

    }

    /**
     * 测试查询操作
     * @return bean集合
     */
    private List<Javabean> Select(){
        SqlSet sqlSet=SqlSetConfiguration.getSqlSet("select * from uploadline",Javabean.class);
        Dao dao = DaoFactory.getDao(MainActivity.this, getConfig(), sqlSet);
        return  dao.queryList();
    }

    private void Update(){

    }

    /**
     * 设置数据库的配置路径和版本
     * @return 配置对象
     */
    private ConfigBean getConfig(){
        ConfigBean configBean=new ConfigBean();
        configBean.setDb_file_path(Constant.db_file_path);
        configBean.setDb_version(Constant.db_version);
        return configBean;
    }

    /**
     * 测试用的javabean
     * @return javabean
     */
    private Javabean getJavaBean(){
        Javabean j=new Javabean();
        j.setId("1");
        j.setSign("1");
        j.setTablename("1");
        Polyline polyline=new Polyline();
        j.setLine(polyline);
        return j;
    }

    /**
     * 获取增加语句
     * @param gpsLine 传入的javabean对象
     * @return sql语句
     */
    public static  String getSqlstr(Javabean gpsLine){
        StringBuilder sqlStr=new StringBuilder();
        sqlStr.append("INSERT INTO uploadline" + "(id,sign,tablename,line) values (");
        sqlStr.append("\"").append(gpsLine.getId()).append("\"").append(",");
        sqlStr.append("\"").append(gpsLine.getSign()).append("\"").append(",");
        sqlStr.append("\"").append(gpsLine.getTablename()).append("\"").append(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gpsLine.getLine().getPointCount(); i++) {
            sb.append(gpsLine.getLine().getPoint(i).getX() + " " + gpsLine.getLine().getPoint(i).getY() + ",");
        }
        String sl="LINESTRING(" + sb.toString().substring(0, sb.length() - 1) + ")";
        sqlStr.append("GeomFromText('").append(sl).append("',4326)");
        sqlStr.append(");");

        return sqlStr.toString();
    }

    private void copyBigDataToSD() {
        try {
            InputStream myInput;
            OutputStream myOutput = new FileOutputStream(extrernalPath+ "/lwcj.sqlite");
            myInput = getAssets().open("lwcj.sqlite");
            byte[] buffer = new byte[1024];
            int length = myInput.read(buffer);
            while (length > 0) {
                myOutput.write(buffer, 0, length);
                length = myInput.read(buffer);
            }
            myOutput.flush();
            myInput.close();
            myOutput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
