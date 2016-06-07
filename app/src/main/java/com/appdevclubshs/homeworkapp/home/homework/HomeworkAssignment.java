package com.appdevclubshs.homeworkapp.home.homework;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkAssignment that = (HomeworkAssignment) o;
        return datePostNum == that.datePostNum &&
                votes == that.votes &&
                createdByDisplayName.equals(that.createdByDisplayName) &&
                createdByID.equals(that.createdByID) &&
                description.equals(that.description) &&
                dueDate.equals(that.dueDate) &&
                className.equals(that.className);
    }

}
