package mddemo.library.com.db;

import android.content.Context;

import mddemo.library.com.activityanimation_master.ConfigBean;
import mddemo.library.com.dao.Dao;
import mddemo.library.com.dao.SqlHelper;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月22日13:47:36
 * Description:
 */
public class DaoFactory {
    private static Dao dao;

    public static Dao getDao(Context context,ConfigBean configBean,SqlSet sqlSet){
        if (dao==null){
            DBConfiguration dbConfiguration=new DBConfiguration(context,configBean,sqlSet);
            DBConnection dbConnection=new DBConnection(dbConfiguration);
            SqlHelper sqlHelper=new DefaultSqlHelper(dbConnection);
            dao=new BaseDefaultDao(sqlHelper);
        }
        return dao;
    }

}
