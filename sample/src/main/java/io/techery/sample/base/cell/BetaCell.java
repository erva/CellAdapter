package io.techery.sample.base.cell;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import io.techery.celladapter.Cell;
import io.techery.celladapter.Layout;
import io.techery.sample.BaseCell;
import io.techery.sample.R;
import io.techery.sample.base.model.BetaModel;

@Layout(R.layout.item_base_beta)
public class BetaCell extends BaseCell<BetaModel, BetaCell.Listener> {

	@BindView(R.id.tv_beta)
	TextView textView;

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