package mddemo.library.com.dao;

import java.util.List;

import jsqlite.Stmt;
import mddemo.library.com.lang.BeanParser;
import mddemo.library.com.lang.IntegerParser;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月22日00:34:20
 * Description:
 */
public abstract class DBParser<T> {

    /**
     *  将Stmt对象转化为bean对象.
     * @param stmt Stmt对象
     * @param bean 实体类
     * @return 实体类
     * @throws Exception  异常
     */
    public abstract T toBean(Stmt stmt,Class<T> bean) throws  Exception;

    /**
     * 将Stmt对象转换成list<bean> 对象
     * @param stmt Stmt对象
     * @param bean list<bean> 集合
     * @return 集合
     * @throws Exception 异常
     */
    public abstract List<T> toBeanList(Stmt stmt,Class<T> bean) throws Exception;

    public static DBParser<?> getParser(String classType){
        if (classType.equals(Integer.class.getName())){
            return new IntegerParser();
        }
        else{
            return new BeanParser();
        }
    }
}
