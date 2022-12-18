package com.makifinan.mvvmnewsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.makifinan.mvvmnewsapp.model.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase(){

    abstract fun getArticleDao():ArticleDao

    companion object{
        @Volatile
        private var instance :ArticleDatabase ?=null
        fun accessDatabase(context: Context):ArticleDatabase?{
            if (instance == null){
                synchronized(ArticleDatabase::class.java){
                    instance=Room.databaseBuilder(context.applicationContext,ArticleDatabase::class.java,"article_db.db")
                        .createFromAsset("article_db.db").build()
                }
            }
            return instance
        }



    }
}