package io.erva.sample.multi;

import android.view.View;
import android.widget.CheckBox;

import butterknife.BindView;
import butterknife.OnClick;
import io.erva.celladapter.Cell;
import io.erva.celladapter.Layout;
import io.erva.sample.BaseSelectableCell;
import io.erva.sample.R;

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