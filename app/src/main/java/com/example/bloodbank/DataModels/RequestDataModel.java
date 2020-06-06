package com.example.bloodbank.DataModels;

public class RequestDataModel {
    private String message;
    private String image_Url;

    public RequestDataModel(String message, String image_Url) {
        this.message = message;
        this.image_Url = image_Url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage_Url() {
        return image_Url;
    }

    public void setImage_Url(String image_Url) {
        this.image_Url = image_Url;
    }
}
