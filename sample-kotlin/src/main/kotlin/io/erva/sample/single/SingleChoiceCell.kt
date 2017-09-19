package io.erva.sample.single

import android.view.View
import io.erva.celladapter.Cell
import io.erva.celladapter.Layout
import io.erva.celladapter.select.SelectableCell
import io.erva.sample.R
import kotlinx.android.synthetic.main.item_single.view.*

@Layout(R.layout.item_single)
class SingleChoiceCell(view: View) : SelectableCell<SingleChoiceModel, Cell.Listener<SingleChoiceModel>>(view) {

    override fun bindView() {
        view.rb_single.text = item().singleTitle
        view.rb_single.isChecked = selectionManager.isSelected(adapterPosition)
        view.rb_single.setOnClickListener {
            selectionManager.toggleSelection(adapterPosition)
            listener()?.onCellClicked(item())
        }
    }
}