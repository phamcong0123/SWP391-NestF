/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.post;

import com.nestf.seller.SellerDTO;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class PostDTO implements Serializable {

    private int postID;
    private String adPhone;
    private String title;
    private String dateTime;
    private boolean status;
    private String filePath;
    private String image;

    public PostDTO() {
    }

    public PostDTO(int postID, String adPhone, String title, String dateTime, boolean status, String filePath, String image) {
        this.postID = postID;
        this.adPhone = adPhone;
        this.title = title;
        this.dateTime = dateTime;
        this.status = status;
        this.filePath = filePath;
        this.image = image;
    }

    public int getPostID() {
        return postID;
    }

    public String getAdPhone() {
        return adPhone;
    }

    public void setAdPhone(String adPhone) {
        this.adPhone = adPhone;
    }

    public String getTitle() {
        return title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getImage() {
        return image;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
