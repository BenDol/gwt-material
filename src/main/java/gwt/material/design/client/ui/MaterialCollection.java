package gwt.material.design.client.ui;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import gwt.material.design.client.custom.ComplexWidget;
import gwt.material.design.client.custom.CustomH4;
import gwt.material.design.client.custom.HasActive;
import gwt.material.design.client.custom.HasGrid;

import com.google.gwt.dom.client.Document;

//@formatter:off
/**
* Collections allow you to group list objects together.
* @author kevzlou7979
*<p>
*<h3>UiBinder Usage:</h3>
*<pre>
*{@code 
*Simple
<m:MaterialCollection >
	<m:MaterialCollectionItem><m:MaterialLabel text="Collecton 1"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLabel text="Collecton 2"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLabel text="Collecton 3"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLabel text="Collecton 4"/></m:MaterialCollectionItem>
</m:MaterialCollection>

Links
<m:MaterialCollection >
	<m:MaterialCollectionItem><m:MaterialLink text="Collecton 1"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLink text="Collecton 2"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLink text="Collecton 3"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLink text="Collecton 4"/></m:MaterialCollectionItem>
</m:MaterialCollection>

Header
<m:MaterialCollection header="Header Title">
	<m:MaterialCollectionItem><m:MaterialLink text="Collecton 1"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLink text="Collecton 2"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLink text="Collecton 3"/></m:MaterialCollectionItem>
	<m:MaterialCollectionItem><m:MaterialLink text="Collecton 4"/></m:MaterialCollectionItem>
</m:MaterialCollection>

Secondary Content
<m:MaterialCollection header="Header Title">
	<m:MaterialCollectionItem>
		<m:MaterialLink text="Collecton 1"/>
		<m:MaterialSecondaryContent><m:MaterialIcon icon="polymer" iconPosition="right" waves="default"/></m:MaterialSecondaryContent>
	</m:MaterialCollectionItem>
	<m:MaterialCollectionItem>
		<m:MaterialLink text="Collecton 2"/>
		<m:MaterialSecondaryContent><m:MaterialIcon icon="polymer" iconPosition="right" waves="default"/></m:MaterialSecondaryContent>
	</m:MaterialCollectionItem>
	<m:MaterialCollectionItem>
		<m:MaterialLink text="Collecton 3"/>
		<m:MaterialSecondaryContent><m:MaterialIcon icon="polymer" iconPosition="right" waves="default"/></m:MaterialSecondaryContent>	
	</m:MaterialCollectionItem>
	<m:MaterialCollectionItem>
		<m:MaterialLink text="Collecton 4"/>
		<m:MaterialSecondaryContent><m:MaterialIcon icon="polymer" iconPosition="right" waves="default"/></m:MaterialSecondaryContent>
	</m:MaterialCollectionItem>
</m:MaterialCollection>

*}
*</pre>
* </p>
* @see <a href="http://gwt-material-demo.herokuapp.com/#collections">Material Collections</a>
*/

//@formatter:on
public class MaterialCollection extends ComplexWidget implements HasActive, HasGrid{
	
	private CustomH4 span = new CustomH4();
	private int index;
	
	/**
	 * Creates an empty collection component
	 */
	public MaterialCollection() {
		setElement(Document.get().createULElement());
		setStyleName("collection");		
	}
	
	/**
	 * Sets the header of the collection component
	 * @param header
	 */
	public void setHeader(String header){
		span.getElement().setInnerHTML(header);
		addStyleName("with-header");
		ListItem item = new ListItem(span);
		MaterialUiHelper.addMousePressedHandlers(item);
		item.setStyleName("collection-header");
		insert(item, 0);
	}

	@Override
	public void setActive(int index) {
		this.index = index;
		getWidget(index).addStyleName("active");
	}

	@Override
	public int getActive() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public void setGrid(String grid) {
		this.addStyleName("col " + grid);
	}

	@Override
	public void setOffset(String offset) {
		String tobeadded = "";
		String[] vals = offset.split(" ");
		for(String val : vals){
			tobeadded = tobeadded + " offset-" +  val;
		}
		this.addStyleName(tobeadded);
	}
}
