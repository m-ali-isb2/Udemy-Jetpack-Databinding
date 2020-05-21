package com.muhammadali.udemy.jetpack.databinding.model

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

    @Query("SELECT * FROM dogbreed WHERE id=:dogId")
    suspend fun getDog(dogId: String): DogBreed

    @Query("DELETE  FROM dogbreed ")
    suspend fun deleteAllDogs()


    @Query("DELETE FROM dogbreed WHERE id=:dogId")
    suspend fun deleteDog(dogId: String)

}