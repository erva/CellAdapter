package io.erva.celladapter.v7

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import io.erva.celladapter.Layout
import java.util.*
import kotlin.reflect.KClass

open class CellAdapter : RecyclerView.Adapter<Cell<out Any, Cell.Listener<out Any>>>() {

    private val itemCellMapping = HashMap<KClass<*>, KClass<out Cell<out Any, Cell.Listener<out Any>>>>()
    private val viewTypes: MutableList<KClass<*>> = mutableListOf()
    private val itemListenerMapping = SparseArray<Cell.Listener<out Any>>()

    val items: MutableList<Any> = mutableListOf()

    open fun cell(cellClass: KClass<out Cell<out Any, Cell.Listener<out Any>>>,
                  cellDataBuilderFunc: CellDataBuilder.() -> CellDataBuilder): CellAdapter {
        val cellDataBuilder = CellDataBuilder().cellDataBuilderFunc()
        itemCellMapping.put(cellDataBuilder.itemClass, cellClass)
        val type = viewTypes.indexOf(cellDataBuilder.itemClass)
        if (type == -1) {
            this.viewTypes.add(cellDataBuilder.itemClass)
            if (cellDataBuilder.listener != null)
                itemListenerMapping.put(viewTypes.indexOf(cellDataBuilder.itemClass), cellDataBuilder.listener)
        }
        return this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cell<out Any, Cell.Listener<out Any>> {
        val cellClass = itemCellMapping[viewTypes[viewType]]!!
        val layoutAnnotation = cellClass.annotations
                .filter { it is Layout }
                .map { it as Layout }
                .firstOrNull() ?: throw IllegalStateException("You have to specify Layout annotation")

        val cellView = LayoutInflater.from(parent.context).inflate(layoutAnnotation.layout, parent, false)
        return cellClass.constructors.first().call(cellView)
    }

    override fun getItemViewType(position: Int): Int {
        val baseItemClass = this.items[position]
        val index = viewTypes.indexOf(baseItemClass.javaClass.kotlin)
        if (index < 0) {
            throw IllegalArgumentException(baseItemClass.javaClass.simpleName + " is not registered")
        }
        return index
    }

    override fun onBindViewHolder(cell: Cell<out Any, Cell.Listener<out Any>>, position: Int) {
        val item = getItem(position)
        cell.listener(itemListenerMapping.get(getItemViewType(position)))
        cell.item(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    operator fun contains(item: Any): Boolean {
        return items.contains(item)
    }

    fun indexOf(item: Any): Int {
        return items.indexOf(item)
    }

    fun replaceItem(position: Int, item: Any) {
        items[position] = item
    }

    fun getItem(position: Int): Any {
        return items[position]
    }

    fun addItem(item: Any) {
        items.add(item)
    }

    fun addItem(position: Int, item: Any) {
        items.add(position, item)
    }

    fun addItems(items: List<Any>?) {
        if (items != null) {
            this.items.addAll(items)
        }
    }

    fun remove(item: Any?) {
        items.remove(item)
    }

    fun remove(position: Int) {
        items.removeAt(position)
    }

    fun clear() {
        items.clear()
    }

    class CellDataBuilder() {

        lateinit var itemClass: KClass<*>
        var listener: Cell.Listener<out Any>? = null

        fun item(itemClass: KClass<*>): CellDataBuilder {
            this.itemClass = itemClass
            return this
        }

        fun listener(listener: Cell.Listener<out Any>): CellDataBuilder {
            this.listener = listener
            return this
        }
    }
}