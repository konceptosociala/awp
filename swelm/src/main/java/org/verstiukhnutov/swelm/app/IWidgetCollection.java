package org.verstiukhnutov.swelm.app;

import org.verstiukhnutov.swelm.widgets.Widget;

public interface IWidgetCollection {

    void addWidget(String widgetName, Widget widget);

    Widget getWidget(String widgetName);

}
