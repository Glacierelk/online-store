package com.hitwh.onlinestore.bean;

public class Comment {
    private int id;
    private String content;
    private int uid;
    private int pid;
    private String create_date;
    private String username;


    public Comment() {
    }

    public Comment(int id, String content, int uid, int pid, String create_date, String username) {
        this.id = id;
        this.content = content;
        this.uid = uid;
        this.pid = pid;
        this.create_date = create_date;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", uid=" + uid +
                ", pid=" + pid +
                ", create_date='" + create_date + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
