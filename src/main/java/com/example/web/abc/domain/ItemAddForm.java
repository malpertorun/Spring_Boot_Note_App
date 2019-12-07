package com.example.web.abc.domain;


import org.hibernate.validator.constraints.NotEmpty;


import javax.validation.constraints.Size;



public class ItemAddForm {
    @NotEmpty
    @Size(min=2, max=250)
    private String itemType;

 	public String getItemType() {
        return itemType;
    }
    private String assingUser;
    
 	 public String getAssingUser() {
 		return assingUser;
 	}
 	public void setAssingUser(String assingUser) {
		this.assingUser = assingUser;
	}

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

 
}