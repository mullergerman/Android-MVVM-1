package com.german.numbers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class NumberViewModel(application: Application): AndroidViewModel(application) {
    private val registroRepository = RegistroRepository(application)
    internal val allRegistros: LiveData<List<Registro>> = registroRepository.getAllRegistros()

    fun add(registro: Registro) = viewModelScope.launch {
        registroRepository.insertRegistro(registro)
    }
}