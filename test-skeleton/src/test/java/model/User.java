package model;



public class User {
    
    private int id;
    private String username;
    private String createdAt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
     public int getId() {
        return id;
    }
     public void setId(int id) {
    	 this.id = id;
     }
}
