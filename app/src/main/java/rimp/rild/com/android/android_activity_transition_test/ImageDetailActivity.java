package rimp.rild.com.android.android_activity_transition_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.gson.Gson;

import rimp.rild.com.android.android_activity_transition_test.data.models.Article;

public class ImageDetailActivity extends AppCompatActivity {
    public static final String  EXTRA_CONTENT = "Image Detail Content";

    Article mArticle;

    ImageView mArticleImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getExtra();

        mArticleImage = (ImageView) findViewById(R.id.detail_image);
        mArticleImage.setImageBitmap(
                BitmapDecoder.decodeSampledBitmapFromResource(getResources(), mArticle.getResImageId(), 300, 300));
    }

    private void getExtra() {
        Gson parser = new Gson();
        String strObj = getIntent().getStringExtra(EXTRA_CONTENT);
        mArticle = parser.fromJson(strObj, Article.class);
    }
}
