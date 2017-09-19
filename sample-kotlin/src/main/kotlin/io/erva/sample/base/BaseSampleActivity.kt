package io.erva.sample.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import io.erva.celladapter.CellAdapter
import io.erva.sample.DividerItemDecoration
import io.erva.sample.R
import io.erva.sample.base.cell.AlphaCell
import io.erva.sample.base.cell.BetaCell
import io.erva.sample.base.cell.GammaCell
import io.erva.sample.base.model.AlphaModel
import io.erva.sample.base.model.BetaModel
import io.erva.sample.base.model.GammaModel
import kotlinx.android.synthetic.main.activity_with_recycler_view.*

class BaseSampleActivity : AppCompatActivity() {

    private var toast: Toast? = null
    private var adapter: CellAdapter = CellAdapter().let {
        it.cell(AlphaCell::class) {
            item(AlphaModel::class)
            listener(object : AlphaCell.Listener {

                override fun onPressOne(item: AlphaModel) {
                    showToast(String.format("%s%npress button %d", item.alpha, 1))
                }

                override fun onPressTwo(item: AlphaModel) {
                    showToast(String.format("%s%npress button %d", item.alpha, 2))
                }

                override fun onCellClicked(item: AlphaModel) {
                    showToast(item.alpha)
                }
            })
        }
        it.cell(BetaCell::class) {
            item(BetaModel::class)
            listener(object : BetaCell.Listener {
                override fun onCellClicked(item: BetaModel) {
                    showToast(item.beta)
                }
            })
        }
        it.cell(GammaCell::class) {
            item(GammaModel::class)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_recycler_view)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addItemDecoration(DividerItemDecoration(this))
        recycler_view.adapter = adapter

        for (i in 0..33) {
            adapter.items.add(AlphaModel(String.format("AlphaModel %d", i)))
            adapter.items.add(BetaModel(String.format("BetaModel %d", i)))
            adapter.items.add(GammaModel(String.format("GammaModel %d", i)))
        }
        adapter.notifyDataSetChanged()
    }

    override fun onStop() {
        super.onStop()
        dismissToast()
    }

    private fun showToast(text: String) {
        dismissToast()
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
        toast?.show()
    }

    private fun dismissToast() {
        toast?.cancel()
    }
}