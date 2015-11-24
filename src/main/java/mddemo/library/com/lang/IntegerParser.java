package mddemo.library.com.lang;

import java.util.LinkedList;
import java.util.List;
import jsqlite.Stmt;
import mddemo.library.com.dao.DBParser;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月22日00:43:25
 * Description:
 */
public class IntegerParser extends DBParser {
    @Override
    public Object toBean(Stmt stmt, Class bean) throws Exception {
        return toBeanList(stmt,bean).get(0);
    }

    @Override
    public List toBeanList(Stmt stmt, Class bean) throws Exception {
        List<Integer> result=new LinkedList<>();
        while(stmt.step()){
            result.add(stmt.column_int(0));
        }
        return result;
    }
}
