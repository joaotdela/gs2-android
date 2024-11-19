package joaotdela.com.github.joaotancredi_rm93527

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class ItemModel (
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val desc: String
)