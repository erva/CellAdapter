package io.techery.sample.cell;

import android.view.View;
import android.widget.TextView;

import io.techery.sample.R;

import io.techery.sample.BaseCell;
import io.techery.celladapter.Cell;
import io.techery.celladapter.Layout;
import io.techery.sample.model.GammaModel;

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