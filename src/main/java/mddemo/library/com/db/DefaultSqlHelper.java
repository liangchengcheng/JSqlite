package mddemo.library.com.db;

import android.util.Log;

import com.hdsx.jts.io.ArcGisGeometryUtils;
import com.hdsx.jts.io.JTSGeometryUtils;
import com.hdsx.jts.utile.ReflectUtil;
import com.vividsolutions.jts.geom.Geometry;

import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jsqlite.Stmt;
import mddemo.library.com.dao.DBParser;
import mddemo.library.com.dao.SqlHelper;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月23日14:07:44
 * Description:
 */
public class DefaultSqlHelper implements SqlHelper {

    private DBConnection dbConnection;

    private String logTag="DefaultSqlHelper";

    @Override
    public SqlSet getSqlSet() {
        return dbConnection.getConfiguration().getSqlSets();
    }

    @Override
    public int execSQL() {
        SqlSet sqlSet = getSqlSet();
        if (sqlSet == null) {
            Log.e(logTag, "sql语句不存在");
            return 0;
        }
        String sql = sqlSet.getSql();
        dbConnection.open();
        try {
            dbConnection.execSQL(sql);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public <T> List<T> rawQuery() {
        SqlSet sqlSet = getSqlSet();
        if (sqlSet == null) {
            Log.e(logTag, "sql语句不存在");
            return null;
        }

        String sql = sqlSet.getSql();
        dbConnection.open();
        List<T> result = null;
        Stmt stmt = null;
        try {
            stmt = dbConnection.rawQuery(sql);
            DBParser<?> dbParser = DBParser.getParser(sqlSet.getResultType().getName());
            result = (List<T>) dbParser.toBeanList(stmt, sqlSet.getResultType());
        } catch (SQLException e) {
            Log.e(logTag, "******************" + e.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e(logTag, "返回类型    " + sqlSet.getResultType() + "类不存在");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt!=null) {
                    stmt.close();
                }
            } catch (jsqlite.Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public DefaultSqlHelper(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

}
