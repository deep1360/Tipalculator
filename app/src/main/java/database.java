import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String table_name = "registeruser";
    public static final String Col1 = "ID";
    public static final String Col2 = "username";
    public static final String Col3 = "password";


    public database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        SQLiteDatabase sqLiteDatabase = null;
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTERGER PRIMARY KEY AUTOINCREMENT,username TEXT , password TEXT");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_name);
        OnCreate(sqLiteDatabase);
    }

    private void OnCreate(SQLiteDatabase sqLiteDatabase) {
    }

    public long addUser(String user, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", user);
        contentValues.put("password", password);

        long res = db.insert("registeruser", null,contentValues);
        db.close();
        return  res;

    }

     public boolean checkUser(String username , String password ) {
         String[] columns = {Col1};
         SQLiteDatabase db = getReadableDatabase();
         String selection = Col2 + "+?" + "and" + Col3 + "=?";
         String[] selectionArgs = {username, password};
         Cursor cursor = db.query(table_name, columns, selection, selectionArgs, null, null, null);
         int count = cursor.getCount();
         cursor.close();
         db.close();
         if (count > 0)
             return true;
         else
             return false;
     }
     }



  