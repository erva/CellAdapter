package io.techery.sample.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import io.techery.celladapter.Cell;
import io.techery.celladapter.CellAdapter;
import io.techery.sample.DividerItemDecoration;
import io.techery.sample.R;
import io.techery.sample.base.BaseSampleActivity;
import io.techery.sample.multi.MultiChoiceActivity;
import io.techery.sample.single.SingleChoiceActivity;

public class SampleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CellAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        adapter = new CellAdapter();
        adapter.registerCell(MenuItem.class, MenuItemCell.class, new Cell.Listener<MenuItem>() {
            @Override
            public void onCellClicked(MenuItem menuItem) {
                startActivity(new Intent(SampleActivity.this, menuItem.clazz));
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.setItems(Arrays.asList(
                new MenuItem(R.string.sample_base, BaseSampleActivity.class),
                new MenuItem(R.string.sample_single_choice, SingleChoiceActivity.class),
                new MenuItem(R.string.sample_multi_choice, MultiChoiceActivity.class)
        ));
        adapter.notifyDataSetChanged();
    }
}