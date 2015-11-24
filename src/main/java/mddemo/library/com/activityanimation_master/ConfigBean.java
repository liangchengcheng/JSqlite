package mddemo.library.com.activityanimation_master;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:    2015年11月24日11:08:08
 * Description:  数据库的配置
 */
public class ConfigBean {

    private String db_file_path;
    private  int db_version;

    public String getDb_file_path() {
        return db_file_path;
    }

    public void setDb_file_path(String db_file_path) {
        this.db_file_path = db_file_path;
    }

    public int getDb_version() {
        return db_version;
    }

    public void setDb_version(int db_version) {
        this.db_version = db_version;
    }
}
