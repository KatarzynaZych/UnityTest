package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;

class JsonHelper {

    public static GitResponse responseMapper(String response) {
        try {
            JSONObject jsonObj = new JSONObject(response);
            String fullName = getStringValue(jsonObj, "full_name");
            String description = getStringValue(jsonObj, "description");
            String cloneUrl = getStringValue(jsonObj, "clone_url");
            String createdAt = getStringValue(jsonObj, "created_at");
            int stars = getIntValue(jsonObj, "stargazers_count");

            return new GitResponse(fullName, description, cloneUrl, stars, createdAt);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getStringValue(JSONObject jsonObj, String parameter) {
        try {
            return jsonObj.getString(parameter);
        } catch (JSONException e) {
            return "parameter not found";
        }
    }

    private static int getIntValue(JSONObject jsonObj, String parameter) {
        try {
            return Integer.parseInt(jsonObj.getString(parameter));
        } catch (JSONException e) {
            return 0;
        }
    }
}
