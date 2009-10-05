package com.playserengeti.domain;


/**
 * A Serengeti team.
 */
public class Team {

    private Integer id;
    private String name;
    private String color;
    private String logo;

    public Team(Integer id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Team(Team b) {
    	this(b.id, b.name, b.color);
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

    // TODO: equals, hashCode, toString
}
