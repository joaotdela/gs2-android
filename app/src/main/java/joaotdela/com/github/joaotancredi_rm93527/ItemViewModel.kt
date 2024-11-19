package joaotdela.com.github.joaotancredi_rm93527

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room

class ItemViewModel(application: Application) : AndroidViewModel(application){
    var items = mutableListOf<ItemModel>()
    val itemsLiveData = MutableLiveData<List<ItemModel>>()
    init {
        val database = Room.databaseBuilder(
            getApplication(),
            ItemDatabase::class.java,
            "items_database"
        ).build()
        itemDao = database.ItemDao()
        itemsLiveData = itemDao.getAll()
    }
    fun addItems(){
        items.add(ItemModel(
            id = 1,
            title = "Use lâmpadas LED",
            desc = "As lâmpadas LED consomem até 80% menos energia do que as incandescentes e têm uma vida útil muito maior."
        ))

        items.add(ItemModel(
            id = 2,
            title = "Desligue aparelhos em standby",
            desc = "Equipamentos como TVs e computadores consomem energia mesmo quando estão no modo de espera. Desligue-os completamente."
        ))

        items.add(ItemModel(
            id = 3,
            title = "Aproveite a luz natural",
            desc = "Sempre que possível, abra as cortinas durante o dia para aproveitar a luz do sol, reduzindo o uso de lâmpadas artificiais."
        ))

        items.add(ItemModel(
            id = 4,
            title = "Utilize o modo econômico de aparelhos",
            desc = "A maioria dos dispositivos, como TVs e ar-condicionados, tem modos que otimizam o consumo de energia. Use essas configurações sempre que possível."
        ))

        items.add(ItemModel(
            id = 5,
            title = "Descongele alimentos naturalmente",
            desc = "Evite usar micro-ondas ou água quente para descongelar alimentos. O processo natural de descongelamento usa menos energia."
        ))

        items.add(ItemModel(
            id = 6,
            title = "Lave roupas com água fria",
            desc = "Aquecedores de água são grandes consumidores de energia. Lavar roupas com água fria ou morna pode reduzir bastante o consumo."
        ))

        items.add(ItemModel(
            id = 7,
            title = "Use a pressão adequada no chuveiro",
            desc = "Chuveiros com alta pressão consomem mais energia. Opte por chuveiros com vazão mais econômica."
        ))

        items.add(ItemModel(
            id = 8,
            title = "Mantenha os eletrodomésticos bem conservados",
            desc = "Eletrodomésticos limpos e bem mantidos funcionam de forma mais eficiente, consumindo menos energia."
        ))

        items.add(ItemModel(
            id = 9,
            title = "Feche portas e janelas ao ligar o ar-condicionado",
            desc = "Manter o ambiente bem vedado ajuda o ar-condicionado a funcionar com mais eficiência, economizando energia."
        ))

        items.add(ItemModel(
            id = 10,
            title = "Desligue a luz ao sair de um ambiente",
            desc = "Mesmo quando as lâmpadas são de baixo consumo, sempre que possível, desligue-as quando não for necessário."
        ))

        itemsLiveData.value = items
    }

}