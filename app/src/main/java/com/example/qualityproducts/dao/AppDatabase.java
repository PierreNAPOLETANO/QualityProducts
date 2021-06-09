package com.example.qualityproducts.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.qualityproducts.dao.ProductDao;
import com.example.qualityproducts.dao.UserDao;
import com.example.qualityproducts.model.User;
import com.example.qualityproducts.model.Product;

@Database(entities = {User.class, Product.class}, version = AppDatabase.DATABASE_VERSION, exportSchema = false)
public abstract class AppDatabase  extends RoomDatabase {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "qualityProduct";

    public abstract ProductDao productDao();
    public abstract UserDao userDao();

    public static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                                   .fallbackToDestructiveMigration().allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
