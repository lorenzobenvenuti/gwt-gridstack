package com.tagetik.gridstack.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * A test page for {@link GridstackWidget}
 * @author lorenzob
 *
 */
public class GwtGridstack implements EntryPoint {

    private final ExampleResources RESOURCES = GWT.create(ExampleResources.class);
    
	@Override
    public void onModuleLoad() {
	    
	    // Loads the necessary javascript and css files
	    // TODO: move to standalone module!?
	    GridstackLoader.loadResources();
	    
	    // Create an istance of the grid
	    GridstackWidget gridstack = new GridstackWidget();
	    RootPanel.get().add(gridstack);

	    // Start batch (in order to calculate the alter the DOM all at once)
	    gridstack.startBatch();
	    
	    // Populate the grid
	    GridstackItemWidget first = new GridstackItemWidget();
	    first.setHeaderText("This is...");
	    Label label = new Label("A GWT port of Gridstack.js");
	    first.setContent(label);
	    gridstack.addItem(first, 2, 2);
	    
	    GridstackItemWidget second = new GridstackItemWidget();
	    second.setBackgroundColor("#ffffcc");
        second.setHeaderText("The GWTCon logo");
        Image image = new Image(RESOURCES.gwtConLogo());
        second.setContent(image);
        gridstack.addItem(second, 3, 2);
	    
        GridstackItemWidget third = new GridstackItemWidget();
        third.setBackgroundColor("#ccffff");
        third.setHeaderText("Some GWT components");
        VerticalPanel panel = new VerticalPanel();
        TextBox textBox = new TextBox();
        textBox.setValue("A TextBox");
        panel.add(textBox);
        CheckBox checkBox = new CheckBox("A checkbox");
        panel.add(checkBox);
        third.setContent(panel);
        gridstack.addItem(third, 2, 3);
        
        
        // Flush the changes
	    gridstack.endBatch();

	}
	
}
