package com.example.sleeptracker

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface sleepDao {
    @Insert
    suspend fun insertSleep(sleep:sleep)

    @Query("SELECT * FROM sleep")
    suspend fun getSleep() : LiveData<List<sleep>>

    @Query("SELECT * FROM sleep WHERE id=:sleep_id")
    suspend fun getSleepId(sleep_id: Int)

    @Update
    suspend fun updateSleep(sleep: sleep)

    @Delete
    suspend fun deletSleep(sleep:sleep)


    @Query("delete from sleep where id = :sleep_id")
    suspend fun deleteAsSleep(sleep_id: Int)
}