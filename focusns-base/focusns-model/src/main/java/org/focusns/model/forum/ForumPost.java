package org.focusns.model.forum;

import java.util.Date;

import org.focusns.model.common.Id;

public class ForumPost extends Id {
    
    private String title;
    private String content;
    private Date createAt;
    private Date modifyAt;
    //
    private long projectId;
    private long topicId;
    private long createById;
    private long modifyById;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(Date modifyAt) {
        this.modifyAt = modifyAt;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public long getCreateById() {
        return createById;
    }

    public void setCreateById(long createById) {
        this.createById = createById;
    }

    public long getModifyById() {
        return modifyById;
    }

    public void setModifyById(long modifyById) {
        this.modifyById = modifyById;
    }
}
