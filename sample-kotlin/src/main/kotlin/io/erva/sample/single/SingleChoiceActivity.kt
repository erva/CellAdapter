package io.erva.sample.single

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.erva.celladapter.CellAdapter
import io.erva.celladapter.select.SelectableCellAdapter
import io.erva.celladapter.select.mode.SingleSelectionManager
import io.erva.sample.DividerItemDecoration
import io.erva.sample.R
import kotlinx.android.synthetic.main.activity_with_recycler_view.*


class SingleChoiceActivity : AppCompatActivity() {

    val singleSelectionManager = SingleSelectionManager()

    private var adapter: CellAdapter = SelectableCellAdapter(selectionManager = singleSelectionManager).let {
        it.cell(SingleChoiceCell::class) {
            item(SingleChoiceModel::class)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_recycler_view)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(this))
        recycler_view.adapter = adapter

        for (it in 0..33) {
            adapter.addItem(SingleChoiceModel("Single select $it"))
        }
        adapter.notifyDataSetChanged()
    }
}