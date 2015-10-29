package com.tagetik.gridstack.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;

/**
 * Utility class to initialize the Gridstack javascript libraries
 * @author lorenzob
 *
 */
public class GridstackLoader {

    private static final GridstackResources RESOURCES = GWT.create(GridstackResources.class);
    
    /**
     * Initialized the javascript libraries
     */
    public static void loadResources() {
        injectJavascript(
            RESOURCES.lodash(),
            RESOURCES.jQuery(),
            RESOURCES.jQueryUI(),
            RESOURCES.gridstack()
        );
        injectCss(RESOURCES.css(), RESOURCES.cssOverrides());
    }
    
    /**
     * Injects some javascript libraries
     * @param textResources
     */
    private static void injectJavascript(TextResource... textResources) {
        for (TextResource textResource : textResources) {
            ScriptInjector.fromString(textResource.getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }
    
    /**
     * Injects some css resources
     * @param textResources
     */
    private static void injectCss(TextResource... textResources) {
        for (TextResource textResource : textResources) {
            StyleInjector.inject(textResource.getText());
        }
    }
    
}
