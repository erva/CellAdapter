package org.ervin.sample.cell;

import android.view.View;
import android.widget.TextView;

import org.ervin.celladapterlib.Cell;
import org.ervin.celladapterlib.Layout;
import org.ervin.sample.BaseCell;
import org.ervin.sample.R;
import org.ervin.sample.model.GammaModel;

import butterknife.BindView;

@Layout(R.layout.item_gamma)
public class GammaCell extends BaseCell<GammaModel, GammaCell.Listener> {

	@BindView(R.id.tv_gamma)
	TextView textView;

	public GammaCell(View view) {
		super(view);
	}

	@Override
	protected void syncUiWithItem() {
		textView.setText(getItem().getGamma());
	}

	@Override
	public void prepareForReuse() {

	}

	public interface Listener extends Cell.Listener<GammaModel> {

	}
}