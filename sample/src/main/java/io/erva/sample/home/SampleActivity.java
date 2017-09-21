package io.erva.sample.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import io.erva.celladapter.Cell;
import io.erva.celladapter.CellAdapter;
import io.erva.sample.DividerItemDecoration;
import io.erva.sample.R;
import io.erva.sample.base.BaseSampleActivity;
import io.erva.sample.multi.MultiChoiceActivity;
import io.erva.sample.single.SingleChoiceActivity;

public class SampleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CellAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recycler_view);
        setTitle(R.string.toolbar_title);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        adapter = new CellAdapter();
        adapter.registerCell(MenuItemModel.class, MenuItemCell.class, new Cell.Listener<MenuItemModel>() {
            @Override
            public void onCellClicked(MenuItemModel menuItemModel) {
                startActivity(new Intent(SampleActivity.this, menuItemModel.clazz));
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.setItems(Arrays.asList(
                new MenuItemModel(R.string.sample_base, BaseSampleActivity.class),
                new MenuItemModel(R.string.sample_single_choice, SingleChoiceActivity.class),
                new MenuItemModel(R.string.sample_multi_choice, MultiChoiceActivity.class)
        ));
        adapter.notifyDataSetChanged();
    }
}