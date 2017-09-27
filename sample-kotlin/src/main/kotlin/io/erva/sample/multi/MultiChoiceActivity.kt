package io.erva.sample.multi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.erva.celladapter.Cell
import io.erva.celladapter.CellAdapter
import io.erva.celladapter.select.SelectableCellAdapter
import io.erva.celladapter.select.mode.MultiSelectionManager
import io.erva.sample.DividerItemDecoration
import io.erva.sample.R
import kotlinx.android.synthetic.main.activity_with_recycler_view.*

class MultiChoiceActivity : AppCompatActivity() {

    val multiSelectionManager = MultiSelectionManager()

    //LinkedHashSet() just for pretty actionbar subtitle. Check lib source
    private var adapter: CellAdapter = SelectableCellAdapter(LinkedHashSet(), multiSelectionManager).let {
        it.cell(MultiChoiceCell::class) {
            item(MultiChoiceModel::class)
            listener(object : Cell.Listener<MultiChoiceModel> {
                override fun onCellClicked(item: MultiChoiceModel) {
                    supportActionBar!!.subtitle = String.format("Selected %s", multiSelectionManager.getSelectedPositions().toString())
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
            adapter.addItem(MultiChoiceModel("Multi select $it"))
        }
        adapter.notifyDataSetChanged()
        supportActionBar!!.subtitle = String.format("Selected %s", multiSelectionManager.getSelectedPositions().toString())
    }
}