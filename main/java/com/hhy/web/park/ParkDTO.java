package com.hhy.web.park;

import lombok.Data;
import org.springframework.stereotype.Component;



@Component
public class ParkDTO {

    private String adminNumber,parkName,parkSortation,jibunAddress,
            roadAddress,latitude,longitude,sportsFacilities,playFacilities,amenities,culturalFacilities,otherFacilities;

    private String search;


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }



    public void setParkSortation(String parkSortation) {
        this.parkSortation = parkSortation;
    }


    public void setJibunAddress(String jibunAddress) {
        this.jibunAddress = jibunAddress;
    }



    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }



    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getCulturalFacilities() {
        return culturalFacilities;
    }

    public void setCulturalFacilities(String culturalFacilities) {
        this.culturalFacilities = culturalFacilities;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public String getSportsFacilities() {
        return sportsFacilities;
    }

    public void setSportsFacilities(String sportsFacilities) {
        this.sportsFacilities = sportsFacilities;
    }

    public String getPlayFacilities() {
        return playFacilities;
    }

    public void setPlayFacilities(String playFacilities) {
        this.playFacilities = playFacilities;
    }
}
