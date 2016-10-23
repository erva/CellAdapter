package org.ervin.celladapterlib;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param <ITEM> is yours POJO model
 */
public class CellAdapter<ITEM> extends RecyclerView.Adapter<Cell> {

	/**
	 * Map<model, Cell child for introducing model></>
	 */
	private final Map<Class, Class<? extends Cell>> itemCellMap = new HashMap<>();
	private final List<Class> viewTypes = new ArrayList<>();
	private final SparseArray<Cell.Listener> typeListenerMapping = new SparseArray<>();
	protected List<ITEM> items = new ArrayList<>();

	private LayoutInflater layoutInflater;

	public CellAdapter(Context context) {
		layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public void registerCell(Class<?> itemClass,
							 Class<? extends Cell> cellClass) {
		registerCell(itemClass, cellClass, null);
	}

	public void registerCell(Class<?> itemClass,
							 Class<? extends Cell> cellClass,
							 @Nullable Cell.Listener<?> cellListener) {
		itemCellMap.put(itemClass, cellClass);
		int type = viewTypes.indexOf(itemClass);
		if (type == -1) {
			viewTypes.add(itemClass);
		}
		registerListener(itemClass, cellListener);
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
		Class itemClass = viewTypes.get(viewType);
		Class<? extends Cell> cellClass = itemCellMap.get(itemClass);
		Cell cell = buildCell(cellClass, parent);
		cell.setCellDelegate(typeListenerMapping.get(viewType));
		return cell;
	}

	private Cell buildCell(Class<? extends Cell> cellClass, ViewGroup parent) {
		Layout layoutAnnotation = cellClass.getAnnotation(Layout.class);
		View cellView = layoutInflater.inflate(layoutAnnotation.value(), parent, false);
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
		ITEM item = getItem(position);
		cell.prepareForReuse();
		cell.fillWithItem(item);
	}

	@Override
	public long getItemId(int position) {
		return super.getItemId(position);
	}

	@Override
	public int getItemViewType(int position) {
		ITEM ITEM = items.get(position);
		Class itemClass = ITEM.getClass();
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

	public ITEM getItem(int position) {
		return items.get(position);
	}

	public List<ITEM> getItems() {
		return items;
	}

	public void setItems(List<ITEM> items) {
		this.items = items;
	}

	public void clear() {
		items.clear();
	}
}