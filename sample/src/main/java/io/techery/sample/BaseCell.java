package io.techery.sample;

import android.view.View;

import io.techery.celladapter.Cell;

import butterknife.ButterKnife;

public abstract class BaseCell<ITEM, LISTENER extends Cell.Listener<ITEM>> extends Cell<ITEM, LISTENER> {

    public BaseCell(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}