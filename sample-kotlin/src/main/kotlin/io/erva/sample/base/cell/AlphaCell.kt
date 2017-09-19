package io.erva.sample.base.cell

import android.view.View
import io.erva.celladapter.Cell
import io.erva.celladapter.Layout
import io.erva.sample.R
import io.erva.sample.base.model.AlphaModel
import kotlinx.android.synthetic.main.item_base_alpha.view.*

@Layout(R.layout.item_base_alpha)
class AlphaCell(view: View) : Cell<AlphaModel, AlphaCell.Listener>(view) {

    override fun bindView() {
        view.tv_alpha.text = item().alpha
        view.btn_one_press.setOnClickListener { listener()?.onPressOne(item()) }
        view.btn_two_press.setOnClickListener { listener()?.onPressTwo(item()) }
    }

    interface Listener : Cell.Listener<AlphaModel> {

        fun onPressOne(item: AlphaModel)

        fun onPressTwo(item: AlphaModel)
    }
}