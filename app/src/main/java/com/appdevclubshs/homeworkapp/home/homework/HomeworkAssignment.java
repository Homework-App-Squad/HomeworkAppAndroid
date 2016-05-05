package com.appdevclubshs.homeworkapp.home.homework;

public class HomeworkAssignment {
    public String createdByDisplayName,
        createdByID,
        description,
        dueDate,
        className;
    public int datePostNum, votes;
    public HomeworkAssignment(String createdByDisplayName, String createdByID, String description,
                              String dueDate, String className, int datePostNum, int votes) {
        this.createdByDisplayName = createdByDisplayName;
        this.createdByID = createdByID;
        this.description = description;
        this.dueDate = dueDate;
        this.className = className;
        this.datePostNum = datePostNum;
        this.votes = votes;
    }


}
