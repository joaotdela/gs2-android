package joaotdela.com.github.joaotancredi_rm93527

import androidx.lifecycle.LiveData
import androidx.room.Dao

import androidx.room.Query
@Dao
interface ItemDao {
    @Query("SELECT * FROM ItemModel")
    fun getAll(): LiveData<List<ItemModel>>
}