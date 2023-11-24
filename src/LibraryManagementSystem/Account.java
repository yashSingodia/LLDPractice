package LibraryManagementSystem;

import java.util.Date;

public abstract class Account {

    private String id;
    private String password;
    private Date createdAt;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

}
