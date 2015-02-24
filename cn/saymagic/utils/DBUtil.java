package cn.saymagic.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by saymagic on 15/2/24.
 */
public class DBUtil {
    /**
     * 批量执行asset文件下的dbname文件里的sql语句
     * @param context
     * @param database
     * @param dbname
     */
    private void executeSQLScript(Context context,SQLiteDatabase database, String dbname){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int len;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream = null;

        try{
            inputStream = assetManager.open(dbname);
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
            String[] createScript = outputStream.toString().split(";");
            for (int i = 0; i < createScript.length; i++) {
                String sqlStatement = createScript[i].trim();
                if (sqlStatement.length() > 0) {
                    database.execSQL(sqlStatement + ";");
                }
            }
        } catch (IOException e){
        } catch (SQLException e) {
        }
    }

}
