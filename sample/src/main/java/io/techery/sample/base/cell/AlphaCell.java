package io.techery.sample.base.cell;

import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.techery.celladapter.Cell;
import io.techery.celladapter.Layout;
import io.techery.sample.BaseCell;
import io.techery.sample.R;
import io.techery.sample.base.model.AlphaModel;

@Layout(R.layout.item_base_alpha)
public class AlphaCell extends BaseCell<AlphaModel, AlphaCell.Listener> {

    @BindView(R.id.tv_alpha) TextView textView;

    public AlphaCell(View view) {
        super(view);
    }

    @Override
    protected void bindView() {
        textView.setText(getItem().getAlpha());
    }

    @OnClick(R.id.btn_one_press)
    public void onPressOne() {
        if (getListener() != null) getListener().onPressOne(getItem());
    }

    @OnClick(R.id.btn_two_press)
    public void onPressTwo() {
        if (getListener() != null) getListener().onPressTwo(getItem());
    }

    public interface Listener extends Cell.Listener<AlphaModel> {

        void onPressOne(AlphaModel model);

        void onPressTwo(AlphaModel model);
    }
}