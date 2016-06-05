package com.appdevclubshs.homeworkapp.home.homework;

public class HomeworkAssignment {
    String createdByDisplayName,
        createdByID,
        description,
        dueDate,
        className;
    public int datePostNum, votes;


    public String getCreatedByDisplayName() {
        return createdByDisplayName;
    }

    public int getVotes() {
        return votes;
    }

    public int getDatePostNum() {
        return datePostNum;
    }

    public String getClassName() {
        return className;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedByID() {
        return createdByID;
    }
}
