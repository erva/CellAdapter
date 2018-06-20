package io.erva.sample.multi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import io.erva.celladapter.v7.Cell;
import io.erva.celladapter.v7.select.SelectableCellAdapter;
import io.erva.celladapter.v7.select.mode.MultiSelectionManager;
import io.erva.sample.DividerItemDecoration;
import io.erva.sample.R;

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

        final MultiSelectionManager multiSelectionManager = new MultiSelectionManager();
        //new LinkedHashSet<Integer>() just for pretty actionbar subtitle. Check lib source
        adapter = new SelectableCellAdapter(new LinkedHashSet<Integer>(), multiSelectionManager);
        adapter.registerCell(MultiChoiceModel.class, MultiChoiceCell.class, new Cell.Listener<MultiChoiceModel>() {
            @Override
            public void onCellClicked(MultiChoiceModel multiChoiceModel) {
                getSupportActionBar().setSubtitle(String.format("Selected %s", multiSelectionManager.getSelectedPositions().toString()));
            }
        });
        recyclerView.setAdapter(adapter);

        List items = new ArrayList();
        for (int i = 0; i <= 33; i++) {
            items.add(new MultiChoiceModel(String.format("Multi select %d", i)));
        }

        adapter.setItems(items);
        adapter.notifyDataSetChanged();

        getSupportActionBar().setSubtitle(String.format("Selected %s", multiSelectionManager.getSelectedPositions().toString()));
    }
}