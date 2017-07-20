package io.erva.sample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.erva.celladapter.CellAdapter;
import io.erva.sample.DividerItemDecoration;
import io.erva.sample.R;
import io.erva.sample.base.cell.AlphaCell;
import io.erva.sample.base.cell.BetaCell;
import io.erva.sample.base.cell.GammaCell;
import io.erva.sample.base.model.AlphaModel;
import io.erva.sample.base.model.BetaModel;
import io.erva.sample.base.model.GammaModel;

public class BaseSampleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CellAdapter adapter;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_recycler_view);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        adapter = new CellAdapter();
        adapter.registerCell(AlphaModel.class, AlphaCell.class, new AlphaCell.Listener() {

            @Override
            public void onPressOne(AlphaModel model) {
                showToast(String.format("%s%npress button %d", model.getAlpha(), 1));
            }

            @Override
            public void onPressTwo(AlphaModel model) {
                showToast(String.format("%s%npress button %d", model.getAlpha(), 2));
            }

            @Override
            public void onCellClicked(AlphaModel model) {
                showToast(model.getAlpha());
            }
        });
        adapter.registerCell(BetaModel.class, BetaCell.class, new BetaCell.Listener() {
            @Override
            public void onCellClicked(BetaModel model) {
                showToast(model.getBeta());
            }
        });
        adapter.registerCell(GammaModel.class, GammaCell.class, null);
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

    @Override
    protected void onStop() {
        super.onStop();
        dismissToast();
    }

    private void showToast(String text) {
        dismissToast();
        toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void dismissToast() {
        if (toast != null) toast.cancel();
    }
}