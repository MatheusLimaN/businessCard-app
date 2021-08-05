package br.com.matheus.businesscard.ui

import android.content.Context
import android.graphics.Color
import br.com.matheus.businesscard.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListItemAdapter(context: Context, private var items: List<String>) :
    ArrayAdapter<String>(context, 0, items) {

    override fun getItem(position: Int): String {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item, parent, false)
            val textView = view!!.findViewById<View>(R.id.txv_item) as TextView
            textView.setText(items[position])
        }
        val string = items[position]
        if (string != null) {
            val textView = view.findViewById<View>(R.id.txv_item) as TextView
            textView?.setText(string)
            textView?.setBackgroundColor(Color.parseColor(string))
        }
        return view!!
    }
}