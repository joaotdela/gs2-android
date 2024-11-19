package joaotdela.com.github.joaotancredi_rm93527.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "DicaModel")
data class DicaModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String
)