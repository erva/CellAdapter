package org.ervin.sample;

import android.view.View;

import org.ervin.celladapterlib.Cell;

import butterknife.ButterKnife;

public abstract class BaseCell<ITEM, LISTENER extends Cell.Listener<ITEM>> extends Cell<ITEM, LISTENER> {

    public BaseCell(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}