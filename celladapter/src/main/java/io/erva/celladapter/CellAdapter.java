package io.erva.celladapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CellAdapter extends RecyclerView.Adapter<Cell> {

    private final Map<Class, Class<? extends Cell>> itemCellMap = new ArrayMap<>();
    private final List<Class> viewTypes = new ArrayList<>();
    private final SparseArray<Cell.Listener<?>> typeListenerMapping = new SparseArray<>();
    private List items = new ArrayList<>();

    public void registerCell(@NonNull Class<?> itemClass,
                             @NonNull Class<? extends Cell> cellClass) {
        registerCell(itemClass, cellClass, null);
    }

    public void registerCell(@NonNull Class<?> itemClass,
                             @NonNull Class<? extends Cell> cellClass,
                             @Nullable Cell.Listener<?> cellListener) {
        itemCellMap.put(itemClass, cellClass);
        int type = viewTypes.indexOf(itemClass);
        if (type == -1) viewTypes.add(itemClass);
        if (cellListener != null) registerListener(itemClass, cellListener);
    }

    private void registerListener(Class<?> itemClass,
                                  @Nullable Cell.Listener<?> cellListener) {
        int index = viewTypes.indexOf(itemClass);
        if (index < 0)
            throw new IllegalStateException(itemClass.getSimpleName() + " is not registered as Cell");
        typeListenerMapping.put(index, cellListener);
    }

    @Override
    public Cell onCreateViewHolder(ViewGroup parent, int viewType) {
        Class<? extends Cell> cellClass = itemCellMap.get(viewTypes.get(viewType));
        Cell cell = buildCell(cellClass, parent);
        cell.setCellDelegate(typeListenerMapping.get(viewType));
        return cell;
    }

    private Cell buildCell(Class<? extends Cell> cellClass, ViewGroup parent) {
        Layout layoutAnnotation = cellClass.getAnnotation(Layout.class);
        View cellView = LayoutInflater.from(parent.getContext()).inflate(layoutAnnotation.value(), parent, false);
        RecyclerView.ViewHolder cellObject = null;
        try {
            Constructor<? extends RecyclerView.ViewHolder> constructor = cellClass.getConstructor(View.class);
            cellObject = constructor.newInstance(cellView);
        } catch (Exception e) {
            Log.e("CellAdapter", "Can't create cell: " + e.getMessage());
        }
        return (Cell) cellObject;
    }

    @Override
    public void onBindViewHolder(Cell cell, int position) {
        cell.bindViewInternal(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        Class itemClass = items.get(position).getClass();
        int index = viewTypes.indexOf(itemClass);
        if (index < 0) {
            throw new IllegalArgumentException(itemClass.getSimpleName() + " is not registered");
        }
        return index;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public boolean contains(Object item) {
        return items.contains(item);
    }

    public int indexOf(Object item) {
        return items.indexOf(item);
    }

    public void replaceItem(int position, Object item) {
        items.set(position, item);
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public void addItem(int position, Object item) {
        items.add(position, item);
    }

    public void addItems(List items) {
        if (items != null) {
            this.items.addAll(items);
        }
    }

    public void remove(Object item) {
        if (item != null) {
            int position = indexOf(item);
            if (position != -1) remove(position);
        }
    }

    public void remove(int position) {
        items.remove(position);
    }

    public void clear() {
        items.clear();
    }
}