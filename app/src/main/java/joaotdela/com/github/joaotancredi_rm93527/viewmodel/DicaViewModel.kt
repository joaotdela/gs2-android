package joaotdela.com.github.joaotancredi_rm93527.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import joaotdela.com.github.joaotancredi_rm93527.data.DicaDao
import joaotdela.com.github.joaotancredi_rm93527.data.DicaDatabase
import joaotdela.com.github.joaotancredi_rm93527.model.DicaModel
import kotlinx.coroutines.launch

class DicaViewModel(application: Application) : AndroidViewModel(application){

    private val dicaDao : DicaDao
    val dicas : LiveData<List<DicaModel>>


    init {
        val database = Room.databaseBuilder(
            getApplication(),
            DicaDatabase::class.java,
            "dica_database"
        ).build()
        dicaDao = database.dicaDao()
        dicas = dicaDao.getAll()
        dicasPreCarregadas()
    }

    fun dicasPreCarregadas() {
        viewModelScope.launch {
            if (dicaDao.getAll().value.isNullOrEmpty()) {
                val listaDicas = listOf(
                    DicaModel(title = "Desligue aparelhos que não estão em uso", description = "Aparelhos consomem energia mesmo no modo de espera."),
                    DicaModel(title = "Use lâmpadas LED", description = "Troque lâmpadas incandescentes por LED para economizar energia."),
                    DicaModel(title = "Aproveite a luz natural", description = "Mantenha cortinas abertas para reduzir o uso de iluminação elétrica."),
                    DicaModel(title = "Desligue o monitor do computador", description = "Desligue o monitor quando não estiver em uso por longos períodos."),
                    DicaModel(title = "Use eletrodomésticos eficientes", description = "Procure por aparelhos com o selo de eficiência energética.")
                )
                Thread {
                    dicaDao.insert(listaDicas) // Coloquei pois dava erro ao usar no mainactivity ou aqui nesse arquivo
                }.start()
            }
        }
    }

    fun searchDicas(query: String): LiveData<List<DicaModel>> {
        return dicaDao.selectDicas(query)
    }

}
