package br.com.matheus.businesscard.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ListAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.children
import androidx.core.widget.doOnTextChanged
import br.com.matheus.businesscard.App
import br.com.matheus.businesscard.R
import br.com.matheus.businesscard.data.BusinessCard
import br.com.matheus.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val items = listOf(
            "#F06292",
            "#E57373",
            "#9575CD",
            "#4FC3F7",
            "#4DB6AC",
            "#DCE775",
            "#FFB74D",
            "#A1887F"
        )
        val adapter = ListItemAdapter(this@AddBusinessCardActivity, items)

        binding.dropdownCorItems.setAdapter(adapter)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                cor = binding.dropdownCor.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.dropdownCor.editText?.doOnTextChanged { text, start, before, count ->
            binding.dropdownCor.editText?.setBackgroundColor(Color.parseColor(text.toString()))
        }
    }
}