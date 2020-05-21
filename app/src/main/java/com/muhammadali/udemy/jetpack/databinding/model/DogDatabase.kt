package com.muhammadali.udemy.jetpack.databinding.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by Muhammad Ali on 17-May-20.
 * Email muhammad.ali9385@gmail.com
 */
@Database(entities = [DogBreed::class], version = 1)
abstract class DogDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao

    companion object {
        @Volatile
        private var instance: DogDatabase? = null
        private var lock = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, DogDatabase::class.java, "DogDatabase2")
                .build()
    }
}