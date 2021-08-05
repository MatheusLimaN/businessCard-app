package br.com.matheus.businesscard

import android.app.Application
import br.com.matheus.businesscard.data.AppDatabase
import br.com.matheus.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}