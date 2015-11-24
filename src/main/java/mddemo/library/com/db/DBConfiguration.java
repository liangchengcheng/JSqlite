package mddemo.library.com.db;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import mddemo.library.com.activityanimation_master.ConfigBean;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月22日13:51:43
 * Description: 数据库的配置
 */
public class DBConfiguration {

    //上下文对象
    private Context context;

    //数据库的路径
    private String db_file_path;

    //数据库的版本的号
    private int db_version;

    private SqlSet sqlSet;

    /**
     * 构造函数
     * @param context 上下文对象
     */
    public DBConfiguration(Context context,ConfigBean configBean,SqlSet sqlSet){
        this.context=context;
        this.sqlSet=sqlSet;
        setDb_file_path(configBean.getDb_file_path());
        setDb_version(configBean.getDb_version());
    }

    /**
     * 获取上下文
     * @return 上下文
     */
    public Context getContext(){
        return context;
    }

    /**
     * 获取数据库文件路径
     * @return 得到数据库文件的路径
     */
    public String getDb_file_path(){
        return db_file_path;
    }

    /**
     * 获取版本号
     * @return 版本号
     */
    public int getDb_version(){
        return db_version;
    }

    public SqlSet getSqlSets(){
        return sqlSet;
    }

    public void setDb_file_path(String db_file_path) {
        this.db_file_path = db_file_path;
    }

    public void setDb_version(int db_version) {
        this.db_version = db_version;
    }
}
