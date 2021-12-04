package com.ruth.jahan.pathoinfo;

public class Review {

    private String labname,comment;

    public Review(){

    }

    public Review(String labname,String comment) {

        this.labname=labname;
        this.comment=comment;

    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
