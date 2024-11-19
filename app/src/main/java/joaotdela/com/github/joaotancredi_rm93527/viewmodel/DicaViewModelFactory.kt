package joaotdela.com.github.joaotancredi_rm93527.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel

class DicaViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DicaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DicaViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}