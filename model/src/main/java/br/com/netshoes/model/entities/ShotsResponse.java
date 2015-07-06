package br.com.netshoes.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by douglas on 7/6/15.
 */
public class ShotsResponse {

    private int page;
    @SerializedName("per_page") private int perPage;
    private int pages;
    private int total;
    @SerializedName("shots") List<Shot> shotList;

    /*
    {
    "page": "1",
    "per_page": 15,
    "pages": 50,
    "total": 750,
    "shots": [
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

    public ShotsResponse() {}

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Shot> getShotList() {
        return shotList;
    }

    public void setShotList(List<Shot> shotList) {
        this.shotList = shotList;
    }

    @Override
    public String toString() {
        return "ShotsResponse{" +
                "page=" + page +
                ", perPage=" + perPage +
                ", pages=" + pages +
                ", total=" + total +
                ", shotList=" + shotList +
                '}';
    }
}
