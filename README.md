# CellAdapter
============

## Usage
-------

```java
CellAdapter adapter = new CellAdapter(context);
adapter.registerCell(Model.class, YourCell.class, new YourCell.Listener(){});
```
where
`Model.class` is POJO and `YourCell.class` is
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
Also please find 
[`https://github.com/ervinmartirosyan/CellAdapter/blob/master/sample/src/main/java/org/ervin/sample/BaseCellAdapter.java`](CellAdapter/sample/src/main/java/org/ervin/sample/BaseCell.java)there is sample how to implement Butterknife in Cells.

## Download
-------

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

## License
-------

    Copyright 2016 Ervin Martirosyan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

-------

<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
