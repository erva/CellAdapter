package io.techery.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import io.techery.celladapter.CellAdapter;
import io.techery.sample.cell.AlphaCell;
import io.techery.sample.cell.BetaCell;
import io.techery.sample.cell.GammaCell;
import io.techery.sample.model.AlphaModel;
import io.techery.sample.model.BetaModel;
import io.techery.sample.model.GammaModel;

import java.util.ArrayList;
import java.util.List;

public class SampleActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	CellAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);

		recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.addItemDecoration(new DividerItemDecoration(this));

		adapter = new CellAdapter(this);
		adapter.registerCell(AlphaModel.class, AlphaCell.class, new AlphaCell.Listener() {
			@Override
			public void callbackSample(AlphaModel model) {
				Toast.makeText(SampleActivity.this, model.getAlpha(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onCellClicked(AlphaModel model) {
				Log.d("CellAdapter", model.getAlpha());
			}
		});
		adapter.registerCell(BetaModel.class, BetaCell.class, new BetaCell.Listener() {
			@Override
			public void onCellClicked(BetaModel model) {
				Log.d("CellAdapter", model.getBeta());
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