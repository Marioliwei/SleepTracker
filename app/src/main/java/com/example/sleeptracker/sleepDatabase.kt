package com.example.sleeptracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(sleep::class),version=1)
abstract class sleepDatabase:RoomDatabase() {
    //create an instance of the DAO
    abstract fun sleepDao(): sleepDao

    companion object{
        //create an instance of the room database
        //singleton prevents multiple instance of the database
        @Volatile
        private var INSTANCE : sleepDatabase?=null

        fun getDatabase(context: Context) : sleepDatabase{
            val tempDB = INSTANCE
            if(tempDB!=null){
                return tempDB
            }
            //create an instance of the database
            synchronized(this){
                val instance = Room.databaseBuilder(context,sleepDatabase::class.java, "new_db").build()
                INSTANCE=instance

                return instance
            }
        }
    }
}