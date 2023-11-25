package com.example.Service_1.controller;

import org.json.*;

public class JSONHandler {

    public JSONObject createJSONObject (String text){

        JSONObject jsonObject = new JSONObject(text);

        return jsonObject;
    }
}
