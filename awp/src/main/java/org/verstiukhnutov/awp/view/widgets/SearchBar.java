package org.verstiukhnutov.awp.view.widgets;

import org.verstiukhnutov.awp.view.AwpApp;
import org.verstiukhnutov.awp.view.AwpMsg;
import org.verstiukhnutov.swelm.app.DumpMode;
import org.verstiukhnutov.swelm.widgets.Button;
import org.verstiukhnutov.swelm.widgets.ConstructWidget;
import org.verstiukhnutov.swelm.widgets.TextField;
import org.verstiukhnutov.swelm.widgets.Widget;
import org.verstiukhnutov.swelm.widgets.containers.BoxContainer;

public class SearchBar extends ConstructWidget<AwpMsg> {

    AwpApp app;
    String widgetName;
    String placeholder;

    public SearchBar(AwpApp app, String widgetName) {
        super(app, widgetName);
        this.app = app;
        this.widgetName = widgetName;
        this.placeholder = "";
    }

    public SearchBar placeholder(String placeholder) {
        this.placeholder = placeholder;
        return this;
    }

    @Override
    public void event(AwpMsg msg) {
        app.event(msg);
    }
        
    @Override
    public Widget build() {
        return new BoxContainer(app, widgetName+"_search_bar").children(new Widget[]{
            new TextField(app, widgetName+"_search_field")
                .placeholder(placeholder),
            new Button(app, widgetName+"_search_button")
                .text("Search") 
        });
    }

}
