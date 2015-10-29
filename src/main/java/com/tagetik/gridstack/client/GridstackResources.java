package com.tagetik.gridstack.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * The {@link ClientBundle} for loading the necessary files
 * @author lorenzob
 *
 */
public interface GridstackResources extends ClientBundle {

    @Source("js/jquery.min.js")
    TextResource jQuery();
    
    @Source("js/jquery-ui.min.js")
    TextResource jQueryUI();
    
    @Source("js/lodash.min.js")
    TextResource lodash();
    
    @Source("js/gridstack.min.js")
    TextResource gridstack();
 
    @Source("css/gridstack.css")
    TextResource css();

    @Source("css/gridstack-overrides.css")
    TextResource cssOverrides();
    
}
