package joaotdela.com.github.joaotancredi_rm93527.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import joaotdela.com.github.joaotancredi_rm93527.model.DicaModel
@Dao
interface DicaDao {
    @Query("SELECT * FROM DicaModel")
    fun getAll(): LiveData<List<DicaModel>>

    @Insert
    fun insert(dica: List<DicaModel>)

    @Query("SELECT * FROM DicaModel WHERE title LIKE :query || '%'")
     fun selectDicas(query: String): LiveData<List<DicaModel>>

}