package com.nice.wealthrating;

import org.springframework.nativex.json.JSONException;
import org.springframework.nativex.json.JSONObject;

public class ClientDetails {
    private String  id;
    private String  firstName;
    private String  lastName;
    private String  city;
    private Long    cash;
    private Integer numberOfAssets;

    private String checkValidation(String id, String firstName, String lastName, String city, Long cash, Integer numberOfAssets) {
        String rc = "OK";
        // Check that the strings are not empty.
        if (id.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || city.isEmpty()) {
            rc = "One field or more are empty.";
//            return -1;
        }

        // Check cash and numberOfAssets are valid.
        if (cash == null || cash < 0 || numberOfAssets == null ||  numberOfAssets < 0) {
            rc = "Cash or number of assets not valid";
//            return -1;
        }

        // Check id contains only numbers
        if (!id.matches("[0-9]+")) {
            rc = "ID not valid";
//            return -1;
        }

        // All input arguments are valid
        return rc;
    }

    public String setClientDetails(String info) throws JSONException {
        // Parse json
        final JSONObject obj = new JSONObject(info);

        String id = obj.getString("id");

        JSONObject personalInfo = obj.getJSONObject("personalInfo");
        String firstName = personalInfo.getString("firstName");
        String lastName  = personalInfo.getString("lastName");
        String city      = personalInfo.getString("city");

        JSONObject financialInfo = obj.getJSONObject("financialInfo");
        Long    cash           = financialInfo.getLong("cash");
        Integer numberOfAssets = financialInfo.getInt("numberOfAssets");

        // Check input validation
        String rc = checkValidation(id, firstName, lastName, city, cash, numberOfAssets);
        if (!rc.equals("OK"))
            return rc;

        // Set all client's details
        this.id             = id;
        this.firstName      = firstName;
        this.lastName       = lastName;
        this.city           = city;
        this.cash           = cash;
        this.numberOfAssets = numberOfAssets;

        return rc;
    }

    // Getters functions
    public String getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCity() {
        return city;
    }
    public Long getCash() {
        return cash;
    }
    public Integer getNumberOfAssets() {
        return numberOfAssets;
    }
}
