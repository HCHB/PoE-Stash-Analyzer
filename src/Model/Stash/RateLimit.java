package Model.Stash;

import java.util.LinkedList;

public class RateLimit {

    private int limit;          // 45
    private long timer;         // 60
    private long timeout;       // 60
    private String identifier;  // 45:60:60
    private String policy;      // backend-item-request-limit
    private String rule;        // Account

    private LinkedList<Long> messages;
    private long timedOut;

    public RateLimit(String identifier, String policy, String rule) {
        this.messages = new LinkedList<>();
        this.timedOut = 0;

        String[] rateValues = identifier.split(":");

        this.limit = Integer.parseInt(rateValues[0]);
        this.timer = Long.parseLong(rateValues[1]) * 1000;
        this.timeout = Long.parseLong(rateValues[2]) * 1000;
        this.identifier = identifier;
        this.policy = policy;
        this.rule = rule;
    }

    public void addMessage(int recordedMessages){
        this.pruneMessages();

        while (messages.size() < recordedMessages){
            this.addMessage();
        }
    }

    public void addMessage(){
        messages.addFirst(System.currentTimeMillis());
    }

    public boolean allowMessage(){
        this.pruneMessages();
        boolean timedOut = this.timedOut > System.currentTimeMillis();
        boolean belowMessageLimit = messages.size() < limit;

        return belowMessageLimit && !timedOut;
    }

    public void setTimeout(int duration){
        this.timedOut = System.currentTimeMillis() + duration * 1000;
    }

    private void pruneMessages(){
        long now = System.currentTimeMillis();

        while (messages.size() > 0) {
            if (messages.getLast() + timer < now) {
                messages.removeLast();
            }
        }
    }
}
