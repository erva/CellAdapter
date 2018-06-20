package io.erva.sample.base.cell;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import io.erva.celladapter.Layout;
import io.erva.celladapter.v7.Cell;
import io.erva.sample.BaseCell;
import io.erva.sample.R;
import io.erva.sample.base.model.GammaModel;

@Layout(R.layout.item_base_gamma)
public class GammaCell extends BaseCell<GammaModel, Cell.Listener<GammaModel>> {

    @BindView(R.id.tv_gamma) TextView textView;

    public GammaCell(View view) {
        super(view);
    }

    @Override
    protected void bindView() {
        textView.setText(getItem().getGamma());
    }
}