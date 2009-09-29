package com.playserengeti.domain;

/**
 * A Serengeti team.
 */
public class Team {

    private Integer id;
    private String name;
    private String logo;

    public Team(Integer id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    // TODO: equals, hashCode, toString
}
