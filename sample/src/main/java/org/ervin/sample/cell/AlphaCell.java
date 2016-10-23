package org.ervin.sample.cell;

import android.view.View;
import android.widget.TextView;

import org.ervin.celladapterlib.Cell;
import org.ervin.celladapterlib.Layout;
import org.ervin.sample.BaseCell;
import org.ervin.sample.R;
import org.ervin.sample.model.AlphaModel;

import butterknife.BindView;
import butterknife.OnClick;

@Layout(R.layout.item_alpha)
public class AlphaCell extends BaseCell<AlphaModel, AlphaCell.Listener> {

	@BindView(R.id.tv_alpha)
	TextView textView;

	public AlphaCell(View view) {
		super(view);
	}

	@Override
	protected void syncUiWithItem() {
		textView.setText(getItem().getAlpha());
	}

	@Override
	public void prepareForReuse() {

	}

	@OnClick(R.id.btn_press)
	public void onPress(){
		if (getListener() != null) getListener().callbackSample(getItem());
	}

	public interface Listener extends Cell.Listener<AlphaModel> {

		void callbackSample(AlphaModel model);
	}
}