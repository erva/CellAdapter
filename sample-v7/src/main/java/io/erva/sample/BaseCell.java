package io.erva.sample;

import android.view.View;

import butterknife.ButterKnife;
import io.erva.celladapter.v7.Cell;

public abstract class BaseCell<ITEM, LISTENER extends Cell.Listener<ITEM>> extends Cell<ITEM, LISTENER> {

    public BaseCell(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}