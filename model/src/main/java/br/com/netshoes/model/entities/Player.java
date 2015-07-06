package br.com.netshoes.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by douglas on 7/6/15.
 */
public class Player {

    private int id;
    private String name;
    private String location;
    @SerializedName("followers_count") private int followersCount;
    @SerializedName("draftees_count") private int drafteesCount;
    @SerializedName("likes_count") private int likesCount;
    @SerializedName("comments_count") private int commentsCount;
    @SerializedName("comments_received_count") private int commentsReceivedCount;
    @SerializedName("rebounds_count") private int reboundsCount;
    @SerializedName("rebounds_received_count") private int reboundsReceivedCount;
    private String url;
    @SerializedName("avatar_url") private String avatarUrl;
    private String username;
    @SerializedName("twitter_screen_name") private String twitterScreenName;
    @SerializedName("website_url") private String websiteUrl;
    @SerializedName("drafted_by_player_id") private int draftedByPlayerId;
    @SerializedName("shots_count") private int shotsCount;
    @SerializedName("following_count") private int followingCount;
    @SerializedName("created_at") private String createdAt;

    /*
    "player": {
                "id": 4754,
                "name": "Sean McCabe",
                "location": "San Antonio, TX",
                "followers_count": 19237,
                "draftees_count": 24,
                "likes_count": 11670,
                "likes_received_count": 56948,
                "comments_count": 1468,
                "comments_received_count": 3918,
                "rebounds_count": 101,
                "rebounds_received_count": 115,
                "url": "http://dribbble.com/seanwes",
                "avatar_url": "https://d13yacurqjgara.cloudfront.net/users/4754/avatars/normal/seanwes-avatar-300.jpg?1386637918",
                "username": "seanwes",
                "twitter_screen_name": "seanwes",
                "website_url": "http://seanwes.com",
                "drafted_by_player_id": null,
                "shots_count": 388,
                "following_count": 58,
                "created_at": "2010/10/01 12:07:16 -0400"
            },
     */

    public Player() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public int getDrafteesCount() {
        return drafteesCount;
    }

    public void setDrafteesCount(int drafteesCount) {
        this.drafteesCount = drafteesCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getCommentsReceivedCount() {
        return commentsReceivedCount;
    }

    public void setCommentsReceivedCount(int commentsReceivedCount) {
        this.commentsReceivedCount = commentsReceivedCount;
    }

    public int getReboundsCount() {
        return reboundsCount;
    }

    public void setReboundsCount(int reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    public int getReboundsReceivedCount() {
        return reboundsReceivedCount;
    }

    public void setReboundsReceivedCount(int reboundsReceivedCount) {
        this.reboundsReceivedCount = reboundsReceivedCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public int getDraftedByPlayerId() {
        return draftedByPlayerId;
    }

    public void setDraftedByPlayerId(int draftedByPlayerId) {
        this.draftedByPlayerId = draftedByPlayerId;
    }

    public int getShotsCount() {
        return shotsCount;
    }

    public void setShotsCount(int shotsCount) {
        this.shotsCount = shotsCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", followersCount=" + followersCount +
                ", drafteesCount=" + drafteesCount +
                ", likesCount=" + likesCount +
                ", commentsCount=" + commentsCount +
                ", commentsReceivedCount=" + commentsReceivedCount +
                ", reboundsCount=" + reboundsCount +
                ", reboundsReceivedCount=" + reboundsReceivedCount +
                ", url='" + url + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", username='" + username + '\'' +
                ", twitterScreenName='" + twitterScreenName + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", draftedByPlayerId=" + draftedByPlayerId +
                ", shotsCount=" + shotsCount +
                ", followingCount=" + followingCount +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
