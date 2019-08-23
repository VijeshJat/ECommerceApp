package jat.vijesh.ecommerceapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NavItems implements Serializable {


    private int id;
    private String name;
    private String logo;

    private List<NavItems> subItems = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<NavItems> getSubItems() {
        return subItems;
    }

    public void setSubItems(List<NavItems> subItems) {
        this.subItems = subItems;
    }
}
