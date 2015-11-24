package mddemo.library.com.dao;

import java.util.List;
import java.util.Map;

import mddemo.library.com.db.SqlSet;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月22日11:35:18
 * Description:
 */
public interface Dao {

    /**
     * 查询单个对象
     * @param <T> 返回的结果
     * @return 对象的实体
     */
    <T> T queryOne();

    /**
     * 查询对象集合
     * @param <T> 返回的结果
     * @return 对象的实体集合
     */
    <T> List<T> queryList();

    /**
     *增加删除修改
     * @return 是否更新成功影响条数
     */
    int exesql();

}
