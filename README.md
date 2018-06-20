# CellAdapter

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![](https://jitpack.io/v/erva/CellAdapter.svg)](https://jitpack.io/#erva/CellAdapter)

![GitHub Logo](/images/ic_launcher.png)

This library simplifies RecyclerView with multiple view types.
Main points:

* Single adapter class for all project
* Easy to use - just register Cell, Model and ClickListener (optional) in adapter
* Listen clicks on any View of any type
* Build-in single / multi select
* Supports Java / Kotlin and *androidx.recyclerview*/*support:recyclerview-v7*

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

### Java
```java
CellAdapter adapter = new CellAdapter(context);
// feel free to register multiple models and cells 
// model per cell, so your RecyclerView would represent multiple view types
adapter.registerCell(SampleModel.class, SampleCell.class, new SampleCell.Listener(){}); 
```

### Kotlin
```java
var adapter: CellAdapter = CellAdapter().let {
        it.cell(SampleCell1::class) {
            item(SampleModel1::class)
            listener(object : SampleCell1.Listener {})
        }
        it.cell(SampleCell2::class) {
            item(SampleModel2::class)
            listener(object : SampleCell2.Listener {})
        }
    }
```

where
`SampleModel.class` is POJO and `SampleCell.class` is
```java
@Layout(R.layout.cell_sample)
public class SampleCell extends Cell<SampleModel, SampleCell.Listener> {

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
Kotlin is almost the same. Check samples for details.

### Samples and hints
* [`Java + support:recyclerview-v7`](https://github.com/erva/CellAdapter/blob/master/sample-v7) 
* [`Kotlin + support:recyclerview-v7`](https://github.com/erva/CellAdapter/blob/master/sample-v7-kotlin) 
* [`Kotlin + androidx.recyclerview`](https://github.com/erva/CellAdapter/blob/master/sample-x-kotlin) 
* [`How to implement ButterKnife in Cells`](https://github.com/erva/CellAdapter/blob/master/sample-v7/src/main/java/io/erva/sample/BaseCell.java) 

## Versions

### 3.0.0
For *androidx* - `import io.erva.celladapter.x...`

For *support:recyclerview-v7* - `import io.erva.celladapter.v7...`

### 2.0.4 
You have only `import io.erva.celladapter`

*support:recyclerview-v7* by default

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
    
    // one of two
    implementation "com.android.support:recyclerview-v7:27.1.1" // any version
    implementation "androidx.recyclerview:recyclerview:1.0.0-alpha3" // any version

    
    // for java projects
    implementation ('com.github.erva.CellAdapter:celladapter:3.0.0') {
        exclude group: 'com.android.support', module: 'recyclerview-v7'
        exclude group: 'androidx.recyclerview', module: 'recyclerview'
    }
    
    // for kotlin projects
    implementation ('com.github.erva.CellAdapter:celladapter-kotlin:3.0.0') {
        exclude group: 'com.android.support', module: 'recyclerview-v7'
        exclude group: 'androidx.recyclerview', module: 'recyclerview'
    } 
}
```

## Proguard

### 3.0.0

#### Java
```
#CellAdapter
-dontwarn io.erva.celladapter.**
-keepclasseswithmembers public class * extends io.erva.celladapter.** { *; }
```

#### Kotlin
```
#CellAdapter
-dontwarn io.erva.celladapter.**
-keep public class kotlin.reflect.jvm.internal.impl.builtins.* { public *; }
-keepclassmembers class * extends io.erva.celladapter.** {
    <init>(android.view.View);
}
```

### 2.0.4
```
#CellAdapter
-dontwarn io.erva.celladapter.**
-keepclasseswithmembers public class * extends io.erva.celladapter.** { *; }
```

## License

 CellAdapter is licensed under the [MIT License](http://opensource.org/licenses/MIT).

-------

<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
