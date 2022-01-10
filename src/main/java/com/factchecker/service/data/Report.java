package com.factchecker.service.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String page;

    private String userName;

    private String complaintText;

    private String supportingLink;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getComplaintText() {
        return complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }

    public String getSupportingLink() {
        return supportingLink;
    }

    public void setSupportingLink(String supportingLink) {
        this.supportingLink = supportingLink;
    }

//    TODO: need to convert this to a one-to-many model with separate page / reports schemas so that 1 page can have multiple reports
//    TODO: links and usernames should be stored in lower case
//    TODO: need to properly sanitize inputs

}