package TestResources;

public enum User {
    TESTUSER("", "");

    private final String name;
    private final String sessionID;

    User(String name, String sessionID){
        this.name = name;
        this.sessionID = sessionID;
    }

    public String getName() {
        return this.name;
    }

    public String getSessionID() {
        return this.sessionID;
    }
}
