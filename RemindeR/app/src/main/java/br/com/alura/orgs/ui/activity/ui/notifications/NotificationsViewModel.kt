package br.com.alura.orgs.ui.activity.ui.notifications

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime

class NotificationsViewModel : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    val current = LocalDate.now().toString()

    @RequiresApi(Build.VERSION_CODES.O)
    val dia :String = current.takeLast(2)

    @RequiresApi(Build.VERSION_CODES.O)
    val mes :String = current.take(7).takeLast(2)

    @RequiresApi(Build.VERSION_CODES.O)
    val ano :String = current.take(4)


    @RequiresApi(Build.VERSION_CODES.O)
    private val _text = MutableLiveData<String>().apply {
        value = "$dia/$mes/$ano"
    }
    @RequiresApi(Build.VERSION_CODES.O)
    val text: LiveData<String> = _text



}

