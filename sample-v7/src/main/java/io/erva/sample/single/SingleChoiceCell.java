package io.erva.sample.single;

import android.view.View;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.OnClick;
import io.erva.celladapter.Layout;
import io.erva.celladapter.v7.Cell;
import io.erva.celladapter.v7.select.mode.SelectionManager;
import io.erva.sample.BaseSelectableCell;
import io.erva.sample.R;

@Layout(R.layout.item_single)
public class SingleChoiceCell extends BaseSelectableCell<SingleChoiceModel, Cell.Listener<SingleChoiceModel>> {

    @BindView(R.id.rb_single) RadioButton radioButton;

    public SingleChoiceCell(View view) {
        super(view);
    }

    @Override
    protected void bindView() {
        radioButton.setText(getItem().singleTitle);
        radioButton.setChecked(selectionManager.isSelected(getAdapterPosition()));
    }

    @Override
    public void setSelectionManager(SelectionManager selectionManager) {
        this.selectionManager = selectionManager;
    }

    @OnClick(R.id.rb_single)
    void radioButtonClicked() {
        selectionManager.toggleSelection(getAdapterPosition());
        getListener().onCellClicked(getItem());
    }
}