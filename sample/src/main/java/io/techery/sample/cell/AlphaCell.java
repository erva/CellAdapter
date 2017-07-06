package io.techery.sample.cell;

import android.view.View;
import android.widget.TextView;

import io.techery.sample.R;

import io.techery.sample.BaseCell;
import io.techery.sample.model.AlphaModel;
import io.techery.celladapter.Cell;
import io.techery.celladapter.Layout;

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
	protected void bindView() {
		textView.setText(getItem().getAlpha());
	}

	@OnClick(R.id.btn_press)
	public void onPress(){
		if (getListener() != null) getListener().callbackSample(getItem());
	}

	public interface Listener extends Cell.Listener<AlphaModel> {

		void callbackSample(AlphaModel model);
	}
}