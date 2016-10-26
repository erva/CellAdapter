# CellAdapter

## Usage

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
	
	protected void prepareForReuse() {
		//optional
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
[`CellAdapter/sample/src/main/java/io/techery/sample/BaseCell.java`](https://github.com/techery/CellAdapter/blob/master/sample/src/main/java/io/techery/sample/BaseCell.java) 
there is sample how to implement ButterKnife in Cells.

## Download

The dependency is available via [jCenter](https://bintray.com/ervin/CellAdapter/celladapterlib). - temp, would be changed
jCenter is the default Maven repository used by Android Studio.

#### Gradle
```groovy
dependencies {
  compile 'com.github.ervinmartirosyan:celladapterlib:1.0.1' //temp, would be changed
}
```

#### Maven
```xml
<dependency> 
  <groupId>com.github.ervinmartirosyan</groupId> //temp, would be changed
  <artifactId>celladapterlib</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

## License

Copyright (c) 2016 Techery (http://techery.io/)

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
