package io.techery.sample.multi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.techery.celladapter.Cell;
import io.techery.celladapter.select.SelectableCellAdapter;
import io.techery.celladapter.select.mode.MultiSelectionManager;
import io.techery.sample.DividerItemDecoration;
import io.techery.sample.R;

public class MultiChoiceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SelectableCellAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        MultiSelectionManager multiSelectionManager = new MultiSelectionManager();
        adapter = new SelectableCellAdapter(multiSelectionManager);
        adapter.registerCell(MultiChoiceModel.class, MultiChoiceCell.class, new Cell.Listener<MultiChoiceModel>() {
            @Override
            public void onCellClicked(MultiChoiceModel multiChoiceModel) {

            }
        });
        recyclerView.setAdapter(adapter);

        List items = new ArrayList();
        for (int i = 0; i <= 33; i++) {
            items.add(new MultiChoiceModel(String.format("Multi select %d", i)));
        }

        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}