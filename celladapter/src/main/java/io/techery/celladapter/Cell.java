package io.techery.celladapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class Cell<ITEM, LISTENER extends Cell.Listener<ITEM>> extends RecyclerView.ViewHolder {

    private ITEM item;
    private LISTENER listener;

    public Cell(View view) {
        super(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) listener.onCellClicked(getItem());
            }
        });
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {
            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                clearResources();
                v.removeOnAttachStateChangeListener(this);
            }
        });
    }

    protected final ITEM getItem() {
        return item;
    }

    protected LISTENER getListener() {
        return listener;
    }

    protected abstract void syncUiWithItem();

    protected void prepareForReuse() {
    }

    protected void clearResources() {
    }

    void setCellDelegate(LISTENER listener) {
        this.listener = listener;
    }

    void setItem(ITEM item) {
        this.item = item;
    }

    void fillWithItem(ITEM item) {
        setItem(item);
        syncUiWithItem();
    }

    public interface Listener<ITEM> {

        void onCellClicked(ITEM item);
    }
}