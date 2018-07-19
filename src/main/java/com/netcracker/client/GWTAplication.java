package com.netcracker.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class GWTAplication implements EntryPoint {

//    private final MainRestService restService = (MainRestService) GWT.create(MainRestService.class);

    @Override
    public void onModuleLoad() {

        final Button button = new Button("Click me");
        final Label label = new Label();

        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }
}
