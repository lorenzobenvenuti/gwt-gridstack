package com.tagetik.gridstack.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;

/**
 * GWT port of the Gridstack dynamic grid
 * @author lorenzob
 *
 */
public class GridstackWidget extends ComplexPanel {

    public static final String CLASSNAME = "grid-stack";
    
    private boolean initialized;

    public GridstackWidget() {
        setElement(Document.get().createDivElement());
        setStyleName(CLASSNAME);
    }
    
    @Override
    protected void onAttach() {
        super.onAttach();
        if (!initialized) {
            initialized = true;
            nativeStartGridstack(getElement());
        }
    }
    
    /**
     * Initializes the Gridstack component
     * @param container
     */
    private native void nativeStartGridstack(Element container) /*-{
        var options = {
            cell_height: 80,
            vertical_margin: 10,
            animate: true,
            always_show_resize_handle: /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent),
            draggable: {
                handle: '.grid-stack-item-header'
            }
        };
        var gs = $wnd.$(container);
        gs.gridstack(options);
    }-*/;
    
    /**
     * Starts a batch update of the Gridstack object
     */
    public void startBatch() {
        nativeBatchUpdate(getElement());
    }

    /**
     * Wrapper of the native "batch_update" function
     * @param container
     */
    private native void nativeBatchUpdate(Element container) /*-{
        var grid = $wnd.$(container).data('gridstack');
        grid.batch_update();
    }-*/;
    
    /**
     * Ends a batch update of the Gridstack object
     * @param syncState dice se va lanciato un evento di sincronizzazione
     */
    public void endBatch() {
        nativeCommit(getElement());
    }

    /**
     * Wrapper of the native "commit" function
     * @param container
     */
    private native void nativeCommit(Element container) /*-{
        var grid = $wnd.$(container).data('gridstack');
        grid.commit();
    }-*/;

    /**
     * Adds a widget to the grid
     * @param container
     * @param item
     * @param x
     * @param y
     * @param width
     * @param height
     * @param auto
     */
    private native void nativeAddWidget(
        Element container,
        Element item,
        int x,
        int y,
        int width,
        int height,
        boolean auto
    ) /*-{
        var grid = $wnd.$(container).data('gridstack');
        grid.add_widget($wnd.$(item), x, y, width, height, auto);
    }-*/;

    /**
     * Adds an item to the grid
     * @param widget
     * @param width
     * @param height
     */
    public void addItem(GridstackItemWidget widget, int width, int height) {
        addItem(widget, 0, 0, width, height, true);
    }
    
    /**
     * Adds an item to the grid
     * @param widget
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void addItem(GridstackItemWidget widget, int x, int y, int width, int height) {
        addItem(widget, x, y, width, height, false);
    }
    
    /**
     * Adds an item to the  grid; x and y are ignored if auto is <code>true</code>
     * @param widget
     * @param x
     * @param y
     * @param width
     * @param height
     * @param auto
     */
    private void addItem(GridstackItemWidget widget, int x, int y, int width, int height, boolean auto) {
        nativeAddWidget(
            getElement(),
            widget.getElement(),
            x,
            y,
            width,
            height,
            auto
        );
        add(widget, getElement());
        widget.getElement().getStyle().clearPosition();
    }

    /**
     * Removes an item from the grid
     * @param widget
     */
    public void removeItem(GridstackItemWidget widget) {
        nativeRemoveWidget(getElement(), widget.getElement());
        remove(widget);
    }

    /**
     * Removes an item from the grid
     * @param container
     * @param item
     */
    private native void nativeRemoveWidget(Element container, Element item) /*-{
        var grid = $wnd.$(container).data('gridstack');
        grid.remove_widget($wnd.$(item), false);
    }-*/;
    
}
