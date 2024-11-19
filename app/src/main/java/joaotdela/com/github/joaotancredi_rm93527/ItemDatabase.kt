package joaotdela.com.github.joaotancredi_rm93527

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [ItemModel::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}