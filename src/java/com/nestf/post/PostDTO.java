/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nestf.post;

import com.nestf.account.AccountDTO;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class PostDTO implements Serializable {

    private int postID;
    private AccountDTO seller;
    private String title;
    private Date dateTime;
    private boolean status;
    private String filePath;
    private String image;

    public PostDTO() {
    }

    public PostDTO(int postID, AccountDTO seller, String title, Date dateTime, boolean status, String filePath, String image) {
        this.postID = postID;
        this.seller = seller;
        this.title = title;
        this.dateTime = dateTime;
        this.status = status;
        this.filePath = filePath;
        this.image = image;
    }

    public int getPostID() {
        return postID;
    }

    public AccountDTO getSeller() {
        return seller;
    }

    public String getTitle() {
        return title;
    }

    public Date getDateTime() {
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
    public void setSeller(AccountDTO seller) {
        this.seller = seller;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateTime(Date dateTime) {
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
