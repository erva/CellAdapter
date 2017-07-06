package io.techery.sample.cell;

import android.view.View;
import android.widget.TextView;

import io.techery.sample.R;

import io.techery.sample.BaseCell;
import io.techery.sample.model.BetaModel;
import io.techery.celladapter.Cell;
import io.techery.celladapter.Layout;

import butterknife.BindView;

@Layout(R.layout.item_beta)
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