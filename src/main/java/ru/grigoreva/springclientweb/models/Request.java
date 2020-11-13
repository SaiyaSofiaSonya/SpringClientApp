package ru.grigoreva.springclientweb.models;

public class Request {
    private Message message;
    private User user;


    public Request(User user, Message message) {
        this.message = message;
        this.user = user;
    }




    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
