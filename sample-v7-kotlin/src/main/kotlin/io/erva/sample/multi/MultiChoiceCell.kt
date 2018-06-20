package io.erva.sample.multi

import android.view.View
import io.erva.celladapter.Layout
import io.erva.celladapter.v7.Cell
import io.erva.celladapter.v7.select.SelectableCell
import io.erva.sample.R
import kotlinx.android.synthetic.main.item_multi.view.*

@Layout(R.layout.item_multi)
class MultiChoiceCell(view: View) : SelectableCell<MultiChoiceModel, Cell.Listener<MultiChoiceModel>>(view) {

    override fun bindView() {
        view.cb_multi.text = item().multiTitle
        view.cb_multi.isChecked = selectionManager.isSelected(adapterPosition)
        view.cb_multi.setOnClickListener {
            selectionManager.toggleSelection(adapterPosition)
            listener()?.onCellClicked(item())
        }
    }
}