package mddemo.library.com.db;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月24日13:07:02
 * Description:
 */
public class SqlSetConfiguration {

    public static SqlSet getSqlSet(String sql ,Class<?> cl){
        SqlSet sqlSet = new SqlSet();
        sqlSet.setType(getSqlSetType(sql));
        if (getSqlSetType(sql).equals(SqlSates.query)){
            sqlSet.setResultType(cl);
        }
        sqlSet.setSql(sql);
        return sqlSet;
    }

    public static String getSqlSetType(String sql){
        String typeStr=SqlSates.query;
        if (sql.startsWith("select")){
            typeStr=SqlSates.query;
        }else if (sql.startsWith("insert")){
            typeStr=SqlSates.insert;
        }else if (sql.startsWith("delete")){
            typeStr=SqlSates.delete;
        }else if (sql.startsWith("update")){
            typeStr=SqlSates.update;
        }
        return typeStr;
    }
}
