package fiek.unipr.stayfit.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context ) {
        super(context, "UsersDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Users(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, LastName TEXT, Email TEXT, Password TEXT, Gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public DbResponse getData(){
        DbResponse obj = new DbResponse();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + DatabaseModelHelper.UsersTable, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            obj.name = cursor.getString(cursor.getColumnIndex(DatabaseModelHelper.UsersName));
            obj.lastName = cursor.getString(cursor.getColumnIndex(DatabaseModelHelper.UsersName));;
        }
        cursor.close();
        return obj;
    }
}
