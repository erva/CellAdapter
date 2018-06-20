package io.erva.sample.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import io.erva.celladapter.v7.Cell
import io.erva.celladapter.v7.CellAdapter
import io.erva.sample.DividerItemDecoration
import io.erva.sample.R
import io.erva.sample.base.BaseSampleActivity
import io.erva.sample.multi.MultiChoiceActivity
import io.erva.sample.single.SingleChoiceActivity
import kotlinx.android.synthetic.main.activity_with_recycler_view.*

class SampleActivity : AppCompatActivity() {

    private var adapter: CellAdapter = CellAdapter().let {
        it.cell(MenuItemCell::class) {
            item(MenuItemModel::class)
            listener(object : Cell.Listener<MenuItemModel> {
                override fun onCellClicked(item: MenuItemModel) {
                    startActivity(Intent(this@SampleActivity, item.clazz))
                }
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_recycler_view)
        setTitle(R.string.toolbar_title)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(this))
        recycler_view.adapter = adapter
        adapter.items.addAll(arrayOf(
                MenuItemModel(R.string.sample_base, BaseSampleActivity::class.java),
                MenuItemModel(R.string.sample_single_choice, SingleChoiceActivity::class.java),
                MenuItemModel(R.string.sample_multi_choice, MultiChoiceActivity::class.java))
        )
        adapter.notifyDataSetChanged()
    }
}