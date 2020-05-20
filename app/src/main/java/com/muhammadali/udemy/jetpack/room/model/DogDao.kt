package com.muhammadali.udemy.jetpack.room.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Created by Muhammad Ali on 13-May-20.
 * Email muhammad.ali9385@gmail.com
 */

@Dao
interface DogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg dog: DogBreed): List<Long>

    @Query("SELECT * FROM dogbreed")
    suspend fun getAllDogs(): List<DogBreed>

    @Query("SELECT * FROM dogbreed WHERE uuid=:dogId")
    suspend fun getDog(dogId: Int): DogBreed

    @Query("DELETE  FROM dogbreed ")
    suspend fun deleteAllDogs()


    @Query("DELETE FROM dogbreed WHERE uuid=:dogId")
    suspend fun deleteDog(dogId: Int)

}