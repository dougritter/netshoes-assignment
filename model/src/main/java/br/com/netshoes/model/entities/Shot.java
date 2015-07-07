package br.com.netshoes.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by douglas on 7/6/15.
 */
public class Shot {

    private int id;
    private String title;
    private String description;
    private int height;
    private int width;
    @SerializedName("likes_count") private int likesCount;
    @SerializedName("comments_count") private int commentsCount;
    @SerializedName("rebounds_count") private int reboundsCount;
    private String url;
    @SerializedName("short_url") private String shortUrl;
    @SerializedName("rebound_source_id") private int reboundSourceId;
    @SerializedName("image_url") private String imageUrl;
    @SerializedName("image_teaser_url") private String imageTeaserUrl;
    @SerializedName("image_400_url") private String image400Url;
    private Player player;
    @SerializedName("created_at") private String createdAt;

    /*
    {
            "id": 2134639,
            "title": "Quick Tip to Draw Straight Lines & Avoid Shaky Hand Lettering",
            "description": "<p>Quick tip to draw straight lines &amp; avoid shaky hand lettering.</p>\n\n<p><strong>CURVES:</strong> Pull. Bend at the wrist. Follow the curve of your hand as it bends inward. This will feel very natural. Always pull those curves toward your body.</p>\n\n<p><strong>STRAIGHTS:</strong> Push. Lock your wrist and move your whole arm away from you to draw a straight line. Go slow. Pick up and start again as needed for longer lines.</p>\n\n<p><a href=\"http://seanwes.com/2015/quick-tip-to-draw-straight-lines-avoid-shaky-hand-lettering/\" rel=\"nofollow\">Blog Post »</a></p>",
            "height": 600,
            "width": 800,
            "likes_count": 584,
            "comments_count": 19,
            "rebounds_count": 0,
            "url": "http://dribbble.com/shots/2134639-Quick-Tip-to-Draw-Straight-Lines-Avoid-Shaky-Hand-Lettering",
            "short_url": "http://drbl.in/pjwN",
            "views_count": 6728,
            "rebound_source_id": null,
            "image_url": "https://d13yacurqjgara.cloudfront.net/users/4754/screenshots/2134639/push-straights-pull-curves-full.gif",
            "image_teaser_url": "https://d13yacurqjgara.cloudfront.net/users/4754/screenshots/2134639/push-straights-pull-curves-full_teaser.gif",
            "image_400_url": "https://d13yacurqjgara.cloudfront.net/users/4754/screenshots/2134639/push-straights-pull-curves-full_1x.gif",
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
            "created_at": "2015/07/05 13:02:20 -0400"
        },
     */

    public Shot() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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

    public int getReboundsCount() {
        return reboundsCount;
    }

    public void setReboundsCount(int reboundsCount) {
        this.reboundsCount = reboundsCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public int getReboundSourceId() {
        return reboundSourceId;
    }

    public void setReboundSourceId(int reboundSourceId) {
        this.reboundSourceId = reboundSourceId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTeaserUrl() {
        return imageTeaserUrl;
    }

    public void setImageTeaserUrl(String imageTeaserUrl) {
        this.imageTeaserUrl = imageTeaserUrl;
    }

    public String getImage400Url() {
        return image400Url;
    }

    public void setImage400Url(String image400Url) {
        this.image400Url = image400Url;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Shot{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", likesCount=" + likesCount +
                ", commentsCount=" + commentsCount +
                ", reboundsCount=" + reboundsCount +
                ", url='" + url + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", reboundSourceId=" + reboundSourceId +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageTeaserUrl='" + imageTeaserUrl + '\'' +
                ", image400Url='" + image400Url + '\'' +
                ", player=" + player +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
