# CellAdapter

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![](https://jitpack.io/v/erva/CellAdapter.svg)](https://jitpack.io/#erva/CellAdapter)

This library simplifies RecyclerView with multiple view types.
Main points:

* Single adapter class for all project
* Extend item types in RecyclerView - just register in adapter and extend Cell.class for mapping model with UI (below more details + [`sample`](https://github.com/erva/CellAdapter/tree/master/sample/src/main/java/io/erva/sample))
* Add any UI listeners to each item type

No more code like this:
```java
@Override
public int getItemViewType(int position) {
	// Just as an example, return 0 or 2 depending on position
	return position % 2 * 2;
}

@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
	switch (viewType) {
		case 0: return new ViewHolder0(...);
		case 2: return new ViewHolder2(...);
		...
	}
}
```

## Usage

```java
CellAdapter adapter = new CellAdapter(context);
//feel free to register multiple models and cells (model per cell, so your RecyclerView would represent multiple view types)
adapter.registerCell(Model.class, YourCell.class, new YourCell.Listener(){}); 

List items = new ArrayList();
items.add(new Model());
adapter.setItems(items);
adapter.notifyDataSetChanged();
```
where
`Model.class` is POJO and `YourCell.class` is
```java
@Layout(R.layout.your_cell_view)
public class YourCell extends Cell<Model, YourCell.Listener> {

 	@Override
	protected void bindView() {
		getItem(); // is your Model object
	}
    
	protected void clearResources() {
		//optional
	}

	public interface Listener extends Cell.Listener<Model> {
		void callbackSample(Model model);
	}
}
```
Also please find 
[`CellAdapter/sample/src/main/java/io/erva/sample/BaseCell.java`](https://github.com/erva/CellAdapter/blob/master/sample/src/main/java/io/erva/sample/BaseCell.java) 
there is sample how to implement ButterKnife in Cells.

## Download

Add the JitPack repository in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
Add the dependency:
```groovy
dependencies {
  compile 'com.github.erva.CellAdapter:celladapter:2.0.4'
  compile 'com.github.erva.CellAdapter:celladapter-kotlin:2.0.4' //for kotlin projects
}
```

## Proguard
```
#CellAdapter
-keepclasseswithmembers public class * extends io.erva.celladapter.** { *; }
-keepclassmembers class * extends io.erva.celladapter.Cell {
    <init>(android.view.View);
}
```

## License

 CellAdapter is licensed under the [MIT License](http://opensource.org/licenses/MIT).

-------

<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
