package mddemo.library.com.dao;

import java.util.List;

import mddemo.library.com.db.DBConnection;
import mddemo.library.com.db.SqlSet;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月22日13:45:13
 * Description:
 */
public interface SqlHelper {

    SqlSet getSqlSet();
    /**
     * 执行select之外的sql
     * @return 返回受影响的条数
     */
    int execSQL();

    /**
     * 执行select查询
     * @return 结果
     */
    <T> List<T> rawQuery();

    /**
     * 得到连接对象.
     * @return the db connection
     */
    DBConnection getDbConnection();

}
