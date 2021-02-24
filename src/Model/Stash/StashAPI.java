package Model.Stash;

import TestResources.User;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

import static java.lang.Thread.sleep;

public class StashAPI {

    private HttpClient httpClient;
    private String url = "https://www.pathofexile.com/character-window/get-stash-items?league={league}&tabs={tabs}&tabIndex={tabIndex}&accountName={accountName}";
    private String league;
    private String sessionID;
    private String userName;

    private int rateLimitSleepTimer;
    private HashMap<String, RateLimit> rateLimits;    // Account:backend-item-request-limit:45:60:60

    public StashAPI(){
        this.httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
        this.rateLimits = new HashMap<>();

        this.rateLimitSleepTimer = 1000;

        //TODO
        this.league = "ritual";
        this.userName = User.TESTUSER.getName();
        this.sessionID = User.TESTUSER.getSessionID();
    }

    public String getTabInfo(){
        String url = this.createURL(league, "1", "", userName);

        //TODO
        try {
            return this.sendGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getTab(int index){
        String url = this.createURL(league, "", index + "", userName);

        //TODO
        try {
            return this.sendGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    private String createURL(String league, String tab, String index, String accountName){
        String readyURL = this.url.
                replace("{league}", league).
                replace("{tabs}", tab).
                replace("{tabIndex}", index).
                replace("{accountName}", accountName);

        if (index.isEmpty()) {
            readyURL = readyURL.replace("&tabIndex=", "");
        }

        if (tab.isEmpty()) {
            readyURL = readyURL.replace("&tabs=", "");
        }

        return readyURL;
    }

    private String sendGet(String url) throws Exception {
        this.rateLimiter();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .setHeader("User-Agent", "GitHub.com/HCHB/PoE-Stash-Analyzer")
                .header("cookie", "POESESSID=" + sessionID)
                .header("accept", "text/html")
                .header("accept-language", "en-US")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();

        this.readRateLimit(response);

        if (statusCode != 200) {
            throw new Exception();
        }

        return response.body();
    }

    private void readRateLimit(HttpResponse<String> response) {
        HttpHeaders headers = response.headers();

        List<String> limits = headers.allValues("x-rate-limit-account");            // 45:60:60,240:240:900
        List<String> states = headers.allValues("x-rate-limit-account-state");      // 1:60:0,1:240:0
        String policy = headers.allValues("x-rate-limit-account-policy").get(0);    // backend-item-request-limit
        String rule = headers.allValues("x-rate-limit-rules").get(0);               // Account

        for (int index = 0; index < limits.size(); index++) {
            String limit = limits.get(index);
            String state = states.get(index);
            String identifier = rule + "" + policy + "" + limit;

            RateLimit rateLimit = this.rateLimits.get(identifier);
            if (rateLimit == null) {
                rateLimit = new RateLimit(limit, policy, rule);
                this.rateLimits.put(identifier, rateLimit);
            }

            int timeOutDuration = Integer.parseInt(state.split(":")[2]);
            if (timeOutDuration != 0) {
                rateLimit.setTimeout(timeOutDuration);
            }

            int recordedMessages = Integer.parseInt(state.split(":")[0]);

            rateLimit.addMessage(recordedMessages);
        }
    }

    private void rateLimiter() throws InterruptedException {
        boolean sleept;

        do {
            sleept = false;
            for (RateLimit rateLimit : this.rateLimits.values()) {
                if (!rateLimit.allowMessage()) {
                    sleep(this.rateLimitSleepTimer);
                    sleept = true;
                    break;
                }
            }
        } while(sleept);
    }

}
