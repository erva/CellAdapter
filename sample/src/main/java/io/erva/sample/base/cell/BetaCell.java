package io.erva.sample.base.cell;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import io.erva.celladapter.Cell;
import io.erva.celladapter.Layout;
import io.erva.sample.BaseCell;
import io.erva.sample.R;
import io.erva.sample.base.model.BetaModel;

@Layout(R.layout.item_base_beta)
public class BetaCell extends BaseCell<BetaModel, BetaCell.Listener> {

    @BindView(R.id.tv_beta) TextView textView;

    public BetaCell(View view) {
        super(view);
    }

    @Override
    protected void bindView() {
        textView.setText(getItem().getBeta());
    }

    public interface Listener extends Cell.Listener<BetaModel> {

    }
}