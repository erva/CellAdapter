package io.erva.sample.base.cell

import android.view.View
import io.erva.celladapter.Cell
import io.erva.celladapter.Layout
import io.erva.sample.R
import io.erva.sample.base.model.GammaModel
import kotlinx.android.synthetic.main.item_base_gamma.view.*

@Layout(R.layout.item_base_gamma)
class GammaCell(view: View) : Cell<GammaModel, Cell.Listener<GammaModel>>(view) {

    override fun bindView() {
        view.tv_gamma.text = item().gamma
    }
}