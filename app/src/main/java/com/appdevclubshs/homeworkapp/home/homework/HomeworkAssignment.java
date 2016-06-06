package com.appdevclubshs.homeworkapp.home.homework;

public class HomeworkAssignment {
    String createdByDisplayName,
        createdByID,
        description,
        dueDate,
        className;
    public int datePostNum, votes;

    public HomeworkAssignment(String createdByDisplayName, String createdByID, String description, String dueDate, String className, long datePostNum, long votes) {
        this.createdByDisplayName = createdByDisplayName;
        this.createdByID = createdByID;
        this.description = description;
        this.dueDate = dueDate;
        this.className = className;
        this.datePostNum = (int)datePostNum;
        this.votes = (int)votes;
    }


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
