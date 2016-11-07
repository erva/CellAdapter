package io.techery.sample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.techery.celladapter.CellAdapter;
import io.techery.sample.DividerItemDecoration;
import io.techery.sample.R;
import io.techery.sample.base.cell.AlphaCell;
import io.techery.sample.base.cell.BetaCell;
import io.techery.sample.base.cell.GammaCell;
import io.techery.sample.base.model.AlphaModel;
import io.techery.sample.base.model.BetaModel;
import io.techery.sample.base.model.GammaModel;

public class BaseSampleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CellAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        adapter = new CellAdapter(this);
        adapter.registerCell(AlphaModel.class, AlphaCell.class, new AlphaCell.Listener() {
            @Override
            public void onPressOne(AlphaModel model) {
                Toast.makeText(BaseSampleActivity.this, String.format("%s\npress button %d", model.getAlpha(), 1),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPressTwo(AlphaModel model) {
                Toast.makeText(BaseSampleActivity.this, String.format("%s\npress button %d", model.getAlpha(), 2),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCellClicked(AlphaModel model) {
                Toast.makeText(BaseSampleActivity.this, String.format(model.getAlpha()),
                        Toast.LENGTH_SHORT).show();
            }
        });
        adapter.registerCell(BetaModel.class, BetaCell.class, new BetaCell.Listener() {
            @Override
            public void onCellClicked(BetaModel model) {
                Toast.makeText(BaseSampleActivity.this, String.format(model.getBeta()),
                        Toast.LENGTH_SHORT).show();
            }
        });
        adapter.registerCell(GammaModel.class, GammaCell.class, new GammaCell.Listener() {
            @Override
            public void onCellClicked(GammaModel model) {
                Log.d("CellAdapter", model.getGamma());
            }
        });
        recyclerView.setAdapter(adapter);

        List items = new ArrayList();
        for (int i = 0; i <= 33; i++) {
            items.add(new AlphaModel(String.format("AlphaModel %d", i)));
            items.add(new BetaModel(String.format("BetaModel %d", i)));
            items.add(new GammaModel(String.format("GammaModel %d", i)));
        }

        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
}