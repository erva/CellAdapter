package io.techery.sample.multi;

import android.view.View;
import android.widget.CheckBox;

import butterknife.BindView;
import butterknife.OnClick;
import io.techery.celladapter.Cell;
import io.techery.celladapter.Layout;
import io.techery.celladapter.select.SelectableCell;
import io.techery.celladapter.select.mode.SelectionManager;
import io.techery.sample.BaseCell;
import io.techery.sample.R;

@Layout(R.layout.item_multi)
public class MultiChoiceCell extends BaseCell<MultiChoiceModel, Cell.Listener<MultiChoiceModel>> implements SelectableCell {

    @BindView(R.id.cb_multi) CheckBox checkBox;

    private SelectionManager selectionManager;

    public MultiChoiceCell(View view) {
        super(view);
    }

    @Override
    protected void syncUiWithItem() {
        checkBox.setText(getItem().multiTitle);
        checkBox.setChecked(selectionManager.isSelected(getAdapterPosition()));
    }

    @Override
    public void setSelectionManager(SelectionManager selectionManager) {
        this.selectionManager = selectionManager;
    }

    @OnClick(R.id.cb_multi)
    void checkBoxClicked() {
        selectionManager.toggleSelection(getAdapterPosition());
        getListener().onCellClicked(getItem());
    }
}