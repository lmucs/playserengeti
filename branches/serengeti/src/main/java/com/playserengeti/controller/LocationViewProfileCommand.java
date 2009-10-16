package com.playserengeti.controller;

/**
 * The commander for viewing a team's profile.
 *
 */
public class LocationViewProfileCommand {

	private Integer locationId;

	/**
	 * Returns the team's id.
	 * @return
	 */
    public Integer getLocationId() {
		return locationId;
	}

    /**
     * Sets the location's id.
     * @param locationId
     */
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
}
