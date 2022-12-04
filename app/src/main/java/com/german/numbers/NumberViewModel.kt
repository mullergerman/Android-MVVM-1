package com.german.numbers

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class NumberViewModel(application: Application): AndroidViewModel(application) {
    // "dataset" almacena la información proveniente de los repositorios que resulta relevante para la view.
    private var dataset: MutableList<Registro>? = mutableListOf()

    private val registroRepository = RegistroRepository(application)
    private val repoLiveData: LiveData<List<Registro>> = registroRepository.getAllRegistros()
    var listener: (()->Unit)? = null

    init {
        val observer = Observer<List<Registro>>{newListRegistro ->
            val count = newListRegistro.size
            if(dataset!!.size>1) {
                val newRegistro = newListRegistro[count - 1]
                dataset?.add(newRegistro)
            }else{
                dataset?.addAll(newListRegistro)
            }
            listener?.invoke()
        }
        repoLiveData.observeForever(observer)
    }

    fun getDataset():List<Registro>{
        return dataset as List<Registro>
    }

    fun add(registro: Registro) = viewModelScope.launch {
        registroRepository.insertRegistro(registro)
    }


}