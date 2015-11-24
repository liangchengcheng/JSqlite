package mddemo.library.com.db;

import android.util.Log;

import java.util.List;

import jsqlite.Constants;
import jsqlite.Database;
import jsqlite.Stmt;
import mddemo.library.com.dao.IDataBase;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月23日13:20:31
 * Description:
 */
public class DBConnection implements IDataBase{

    //数据库的配置对象
    private DBConfiguration dbConfiguration;

    //long tag
    private String logTag="DBConnection";

    //数据库
    private jsqlite.Database database =null;

    /**
     * 得到数据库配置对象
     * @return 配置对象
     */
    public DBConfiguration getConfiguration(){
        return dbConfiguration;
    }

    /**
     * 构造喊出
     * @param configuration 配置
     */
    public DBConnection(DBConfiguration configuration){
        this.dbConfiguration=configuration;
    }

    @Override
    public void open() {
        try{
            if (database==null){
                database=new Database();
                database.open(dbConfiguration.getDb_file_path(), Constants.SQLITE_OPEN_READWRITE);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void close(Stmt stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (database != null) {
                database.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execSQL(String sql) throws Exception {
        Stmt stmt=null;
        try{
            Log.e(logTag,"正在执行的sql语句"+sql);
            stmt=database.prepare(sql);
            stmt.step();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
               if (stmt!=null){
                   stmt.close();
               }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Stmt rawQuery(String sql) {
        try{
            Log.e(logTag, "正在执行sql语句" + sql);
            Stmt stmt=database.prepare(sql);
            return stmt;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
