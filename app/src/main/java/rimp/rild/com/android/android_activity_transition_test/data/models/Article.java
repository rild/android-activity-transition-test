package rimp.rild.com.android.android_activity_transition_test.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by rild on 16/09/01.
 */
public class Article implements Serializable {
    @SerializedName("article_image")
    private int resImageId;

    @SerializedName("article_title")
    private String title;

    @SerializedName("article_content")
    private String content;

    public Article(int resImageId, String title, String content) {
        this.resImageId = resImageId;
        this.title = title;
        this.content = content;
    }

    public int getResImageId() {
        return resImageId;
    }
}
