package io.erva.sample.base.cell

import android.view.View
import io.erva.celladapter.Layout
import io.erva.celladapter.v7.Cell
import io.erva.sample.R
import io.erva.sample.base.model.BetaModel
import kotlinx.android.synthetic.main.item_base_beta.view.*

@Layout(R.layout.item_base_beta)
class BetaCell(view: View) : Cell<BetaModel, BetaCell.Listener>(view) {

    override fun bindView() {
        view.tv_beta.text = item().beta
    }

    interface Listener : Cell.Listener<BetaModel>
}