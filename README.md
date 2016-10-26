# CellAdapter

## Usage

```java
CellAdapter adapter = new CellAdapter(context);
adapter.registerCell(Model.class, YourCell.class, new YourCell.Listener(){}); //feel free to register multiple models and cells (model per cell, so your RecyclerView would represent multiple view types)

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

    The MIT License (MIT)

    Copyright (c) 2016 Techery (http://techery.io/)

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.

-------

<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
