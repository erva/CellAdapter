package io.techery.sample.multi;

import android.view.View;
import android.widget.CheckBox;

import butterknife.BindView;
import butterknife.OnClick;
import io.techery.celladapter.Cell;
import io.techery.celladapter.Layout;
import io.techery.sample.BaseSelectableCell;
import io.techery.sample.R;

@Layout(R.layout.item_multi)
public class MultiChoiceCell extends BaseSelectableCell<MultiChoiceModel, Cell.Listener<MultiChoiceModel>> {

    @BindView(R.id.cb_multi) CheckBox checkBox;

    public MultiChoiceCell(View view) {
        super(view);
    }

    @Override
    protected void bindView() {
        checkBox.setText(getItem().multiTitle);
        checkBox.setChecked(selectionManager.isSelected(getAdapterPosition()));
    }

    @OnClick(R.id.cb_multi)
    void checkBoxClicked() {
        selectionManager.toggleSelection(getAdapterPosition());
        getListener().onCellClicked(getItem());
    }
}