/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.post;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class PostDTO implements Serializable{
    
    private int postID;
    private int sellerID;
    private String title;
    private Date dateTime;
    private boolean status;
    private String filePath;
    private String image;

    public PostDTO() {
    }

    public PostDTO(int postID, int sellerID, String title, Date dateTime, boolean status, String filePath, String image) {
        this.postID = postID;
        this.sellerID = sellerID;
        this.title = title;
        this.dateTime = dateTime;
        this.status = status;
        this.filePath = filePath;
        this.image = image;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "PostDTO{" + "postID=" + postID + ", sellerID=" + sellerID + ", title=" + title + ", dateTime=" + dateTime + ", status=" + status + ", filePath=" + filePath + ", image=" + image + '}';
    }
    
}
