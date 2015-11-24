package mddemo.library.com.dao;

import java.util.List;

import jsqlite.Stmt;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:   2015年11月22日00:26:35
 * Description: 数据操作对象
 */
public interface IDataBase {

    /**
     * 打开数据库连接
     */
    void open();

    /**
     * 关闭数据连接
     */
    void close(Stmt stmt);

    /**
     * 执行除了select之外的sql
     */
    void execSQL(String sql)throws Exception;

    /**
     * 执行查询的sql语句
     */
    Stmt rawQuery(String sql);

}
