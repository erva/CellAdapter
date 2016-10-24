# CellAdapter

## Usage

```java
CellAdapter adapter = new CellAdapter(context);
adapter.registerCell(Model.class, YourCell.class, new YourCell.Listener(){});
```
where
`Model.class` is POJO 

`Cell.class` is
```java
@Layout(R.layout.your_cell_view)
public class YourCell extends Cell<Model, YourCell.Listener> {

        @Override
	protected void syncUiWithItem() {
		getItem() // is your Model object
	}

	public interface Listener extends Cell.Listener<Model> {
		void callbackSample(Model model);
	}
}
```

## Download

The Gradle dependency is available via [jCenter](https://bintray.com/ervin/CellAdapter/celladapterlib).
jCenter is the default Maven repository used by Android Studio.

#### Gradle
```groovy
dependencies {
  compile 'com.github.ervinmartirosyan:celladapterlib:1.0.1'
}
```

#### Maven
```xml
<dependency>
  <groupId>com.github.ervinmartirosyan</groupId>
  <artifactId>celladapterlib</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
