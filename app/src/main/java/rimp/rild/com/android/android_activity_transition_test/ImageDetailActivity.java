package rimp.rild.com.android.android_activity_transition_test;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.transition.Transition;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import rimp.rild.com.android.android_activity_transition_test.data.models.Article;

public class ImageDetailActivity extends AppCompatActivity {
    public static final String EXTRA_CONTENT = "Image Detail Content";
    Activity mActivity;

    Article mArticle;

    ImageView mArticleImage;
    TextView mTitleText;
    TextView mContentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            ///
//            getWindow().requestFeature(android.view.Window.FEATURE_CONTENT_TRANSITIONS);
//            Transition ts = new Slide();  //Slide(); //Explode();
//
//            ts.setDuration(1000);
//
//            getWindow().setEnterTransition(ts);
//            getWindow().setExitTransition(ts);

//            ChangeBounds bounds = new ChangeBounds();
//            bounds.setDuration(1000);
//            getWindow().setSharedElementEnterTransition(bounds);
        }

        setContentView(R.layout.activity_detail);



        mActivity = this;

        getExtra();

        mArticleImage = (ImageView) findViewById(R.id.detail_image);
        mContentText = (TextView) findViewById(R.id.content_text);
        mTitleText = (TextView) findViewById(R.id.title_text);

        mArticleImage.setImageBitmap(
                BitmapDecoder.decodeSampledBitmapFromResource(getResources(), mArticle.getResImageId(), 300, 300));
        mContentText.setText(mArticle.getContent());
        mTitleText.setText(mArticle.getTitle());

        mArticleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Non smooth animation
//                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        mActivity,
//                        mArticleImage,
//                        getString(R.string.trans_name) );
//                Intent intent = new Intent(mActivity, MainActivity.class);
//                ActivityCompat.startActivity(mActivity, intent, options.toBundle());

                //onBackPressed can make smooth animation. why...?
                onBackPressed();
            }
        });
    }

    private void getExtra() {
        Gson parser = new Gson();
        String strObj = getIntent().getStringExtra(EXTRA_CONTENT);
        mArticle = parser.fromJson(strObj, Article.class);
    }
}
