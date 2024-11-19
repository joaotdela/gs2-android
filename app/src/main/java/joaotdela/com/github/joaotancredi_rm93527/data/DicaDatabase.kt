package joaotdela.com.github.joaotancredi_rm93527.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import joaotdela.com.github.joaotancredi_rm93527.model.DicaModel

@Database(entities = [DicaModel::class], version = 1)
abstract class DicaDatabase : RoomDatabase() {
    abstract fun dicaDao(): DicaDao
}