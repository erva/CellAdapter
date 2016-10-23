package org.ervin.sample.cell;

import android.view.View;
import android.widget.TextView;

import org.ervin.celladapterlib.Cell;
import org.ervin.celladapterlib.Layout;
import org.ervin.sample.BaseCell;
import org.ervin.sample.R;
import org.ervin.sample.model.BetaModel;

import butterknife.BindView;

@Layout(R.layout.item_beta)
public class BetaCell extends BaseCell<BetaModel, BetaCell.Listener> {

	@BindView(R.id.tv_beta)
	TextView textView;

	public BetaCell(View view) {
		super(view);
	}

	@Override
	protected void syncUiWithItem() {
		textView.setText(getItem().getBeta());
	}

	@Override
	public void prepareForReuse() {

	}

	public interface Listener extends Cell.Listener<BetaModel> {

	}
}