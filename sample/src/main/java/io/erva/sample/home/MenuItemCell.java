package io.erva.sample.home;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import io.erva.celladapter.Cell;
import io.erva.celladapter.Layout;
import io.erva.sample.BaseCell;

@Layout(android.R.layout.simple_list_item_1)
public class MenuItemCell extends BaseCell<MenuItemModel, Cell.Listener<MenuItemModel>> {

    @BindView(android.R.id.text1) TextView titleTv;

    public MenuItemCell(View view) {
        super(view);
    }

    @Override
    protected void bindView() {
        titleTv.setText(getItem().titleId);
    }
}