package upf.edu.lsds2018.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Serializable;
import java.util.Optional;

public class SimplifiedTweet implements Serializable {

    private static JsonParser parser = new JsonParser();

    private final long tweetId;		        // the id of the tweet ('id')
    private final String text;  	        // the content of the tweet ('text')
    private final long userId;		        // the user id ('user->id')
    private final String userName;	        // the user name ('user'->'name')
    private final long followersCount;	    // the number of followers ('user'->'followers_count')
    private final boolean isRetweeted;	    // is it a retweet? (the object 'retweeted_status' exists?)
    private final Long retweetedUserId;     // [if retweeted] ('retweeted_status'->'user'->'id')
    private final String retweetedUserName; // [if retweeted] ('retweeted_status'->'user'->'name')
    private final long timestampMs;		    // seconds from epoch ('timestamp_ms')

    public SimplifiedTweet(long tweetId, String text, long userId, String userName,
                           long followersCount, boolean isRetweeted,
                           Long retweetedUserId, String retweetedUserName, long timestampMs) {
        // Assign values of constructor
        this.tweetId = tweetId;
        this.text = text;
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followersCount;
        this.isRetweeted = isRetweeted;
        this.retweetedUserId = retweetedUserId;
        this.retweetedUserName = retweetedUserName;
        this.timestampMs = timestampMs;
    }

    /**
     * Returns a {@link SimplifiedTweet} from a JSON String.
     * If parsing fails, for any reason, return an {@link Optional#empty()}
     *
     * @param jsonStr
     * @return an {@link Optional} of a {@link SimplifiedTweet}
     */
    public static Optional<SimplifiedTweet> fromJson(String jsonStr) {
        // IMPLEMENT ME
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(jsonStr);
        JsonObject jo = je.getAsJsonObject();
        String text = jo.get("text").getAsString();
        String userName = null;
        boolean isRetweeted = false;
        Long retweetedUserId = null;
        String retweetedUserName = null;
        long timestampMs = jo.get("timestamp_ms").getAsLong();
        long tweetId = jo.get("id").getAsLong();
        JsonObject userObj = jo.get("name").getAsJsonObject(); // cast method
        long userId = userObj.get("name").getAsLong();
        long followersCount = userObj.get("followers_count").getAsLong();
        if (userObj.has("name")) {
            userName = userObj.get("name").getAsString();
        }
        if(jo.has("retweeted")) {
            isRetweeted = jo.get("retweeted").getAsBoolean();
            if(isRetweeted){

            }
        }
        Optional<SimplifiedTweet> op = Optional.of(new SimplifiedTweet(tweetId, text, userId, userName, followersCount, isRetweeted, retweetedUserId, retweetedUserName, timestampMs));
        return op;
    }

    @Override
    public String toString() {
        // IMPLEMENT ME
        return "AA";
    }
}

