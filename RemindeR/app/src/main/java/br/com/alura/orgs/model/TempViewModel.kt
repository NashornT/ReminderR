package br.com.alura.orgs.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TempViewModel: ViewModel() {

    val dias = MutableLiveData<Any>()
}