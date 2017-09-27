package io.erva.sample.single;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.erva.celladapter.Cell;
import io.erva.celladapter.select.SelectableCellAdapter;
import io.erva.celladapter.select.mode.SingleSelectionManager;
import io.erva.sample.DividerItemDecoration;
import io.erva.sample.R;

public class SingleChoiceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SelectableCellAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        final SingleSelectionManager singleSelectionManager = new SingleSelectionManager();
        adapter = new SelectableCellAdapter(singleSelectionManager);
        adapter.registerCell(SingleChoiceModel.class, SingleChoiceCell.class, new Cell.Listener<SingleChoiceModel>() {
            @Override
            public void onCellClicked(SingleChoiceModel singleChoiceModel) {
                getSupportActionBar().setSubtitle(String.format("Selected %d", singleSelectionManager.getSelectedPosition()));
            }
        });
        recyclerView.setAdapter(adapter);

        List items = new ArrayList();
        for (int i = 0; i <= 33; i++) {
            items.add(new SingleChoiceModel(String.format("Single select %d", i)));
        }

        adapter.setItems(items);
        adapter.notifyDataSetChanged();
        getSupportActionBar().setSubtitle(String.format("Selected %d", singleSelectionManager.getSelectedPosition()));
    }
}