package com.samseng.vehicles.editors;

import java.beans.PropertyEditorSupport;

public class VehicleCheckinEditor extends PropertyEditorSupport {
	
	@Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);
    }
 
    @Override
    public String getAsText() {
        return "Nada";
    }

}
