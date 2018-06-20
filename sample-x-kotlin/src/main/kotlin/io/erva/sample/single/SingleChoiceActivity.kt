package io.erva.sample.single

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.erva.celladapter.x.Cell
import io.erva.celladapter.x.CellAdapter
import io.erva.celladapter.x.select.SelectableCellAdapter
import io.erva.celladapter.x.select.mode.SingleSelectionManager
import io.erva.sample.DividerItemDecoration
import io.erva.sample.R
import kotlinx.android.synthetic.main.activity_with_recycler_view.*

class SingleChoiceActivity : AppCompatActivity() {

    val singleSelectionManager = SingleSelectionManager()

    private var adapter: CellAdapter = SelectableCellAdapter(selectionManager = singleSelectionManager).let {
        it.cell(SingleChoiceCell::class) {
            item(SingleChoiceModel::class)
            listener(object : Cell.Listener<SingleChoiceModel> {
                override fun onCellClicked(item: SingleChoiceModel) {
                    supportActionBar!!.subtitle = String.format("Selected %d", singleSelectionManager.getSelectedPosition())
                }
            })
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
        supportActionBar!!.subtitle = String.format("Selected %d", singleSelectionManager.getSelectedPosition())
    }
}