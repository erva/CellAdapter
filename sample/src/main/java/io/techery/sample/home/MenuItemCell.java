package io.techery.sample.home;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import io.techery.celladapter.Cell;
import io.techery.celladapter.Layout;
import io.techery.sample.BaseCell;

@Layout(android.R.layout.simple_list_item_1)
public class MenuItemCell extends BaseCell<MenuItem, Cell.Listener<MenuItem>> {

    @BindView(android.R.id.text1) TextView titleTv;

    public MenuItemCell(View view) {
        super(view);
    }

    @Override
    protected void bindView() {
        titleTv.setText(getItem().titleId);
    }
}