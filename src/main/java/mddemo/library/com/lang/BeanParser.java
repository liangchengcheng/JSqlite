package mddemo.library.com.lang;

import com.hdsx.jts.io.ArcGisGeometryUtils;
import com.hdsx.jts.io.JTSGeometryUtils;
import com.hdsx.jts.utile.ReflectUtil;
import com.vividsolutions.jts.geom.Geometry;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jsqlite.Stmt;
import mddemo.library.com.dao.DBParser;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月22日11:10:44
 * Description:
 */
public class BeanParser extends DBParser<Object>{

    @Override
    public Object toBean(Stmt stmt, Class<Object> bean) throws Exception {
        return toBeanList(stmt, bean).get(0);
    }

    @Override
    public List<Object> toBeanList(Stmt stmt, Class<Object> bean) throws Exception {
        if (stmt==null){
            return null;
        }
        List<Object> result=new LinkedList<>();
        int columnNum=stmt.column_count();
        String [] columnNames=new String[columnNum];
        for (int i=0;i<columnNum;i++){
            columnNames[i]=stmt.column_name(i).trim();
        }
        //通过反射构建实体对象
        Object t=null;
        Map<String,Field> fields= ReflectUtil.getFields(bean);
        Field field=null;
        while (stmt.step()){
            t=bean.newInstance();
            for (int i=0;i<columnNames.length;i++){
                field=fields.get(columnNames[i].toLowerCase());
                if (field==null) continue;
                if (com.vividsolutions.jts.geom.Geometry.class.isAssignableFrom(field.getType())){
                    field.set(t, JTSGeometryUtils.WKBToGeometry(stmt.column_bytes(i)));
                }
                else if(Geometry.class.isAssignableFrom(field.getType()))
                {
                    field.set(t, ArcGisGeometryUtils.WKBToGeometry(stmt.column_bytes(i)));
                }
                else if(Integer.class.isAssignableFrom(field.getType())||int.class.isAssignableFrom(field.getType()))
                {
                    field.setInt(t,stmt.column_int(i));
                }
                else if(Double.class.isAssignableFrom(field.getType())||double.class.isAssignableFrom(field.getType()))
                {
                    field.setDouble(t,stmt.column_double(i));
                }
                else if(Boolean.class.isAssignableFrom(field.getType())|boolean.class.isAssignableFrom(field.getType()))
                {
                    field.setBoolean(t,stmt.column_int(i)==0?false:true);
                }
                else if(String.class.isAssignableFrom(field.getType()))
                {
                    field.set(t,stmt.column_string(i));
                }
                else if(field.getType().isArray())
                {
                    field.set(t,stmt.column_bytes(i));
                }
            }
            result.add(t);
        }
        return result;
    }
}
