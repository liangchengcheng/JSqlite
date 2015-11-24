package mddemo.library.com.db;

import java.util.List;
import java.util.Map;

import mddemo.library.com.dao.Dao;
import mddemo.library.com.dao.SqlHelper;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月23日13:12:57
 * Description:
 */
public class BaseDefaultDao implements Dao {

    private SqlHelper sqlHelper;

    /**
     * 构造函数
     * @param sqlHelper sqlHelper
     */
    public BaseDefaultDao(SqlHelper sqlHelper) {
        this.sqlHelper=sqlHelper;
    }

    @Override
    public <T> T queryOne() {
        List<T> list=  queryList();
        return list==null||list.size()==0?null:list.get(0);
    }

    @Override
    public <T> List<T> queryList() {
        List<T> list= sqlHelper.rawQuery();
        return list;
    }

    @Override
    public int exesql() {
        return sqlHelper.execSQL();
    }
}
