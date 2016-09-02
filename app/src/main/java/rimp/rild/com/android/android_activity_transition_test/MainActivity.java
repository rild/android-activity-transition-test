package rimp.rild.com.android.android_activity_transition_test;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import rimp.rild.com.android.android_activity_transition_test.data.models.Article;

public class MainActivity extends AppCompatActivity {

    ImageView singleImage;
    GridView mGridView;
    TextView mTextView;

    Activity mActivity;
    ImageAdapter mImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;
//        singleImageTest();
        setContentView(R.layout.activity_main);

        mGridView = (GridView) findViewById(R.id.gridview);
        mImageAdapter = new ImageAdapter(this);
        mImageAdapter.addDummyObjects();
        mImageAdapter.addDummyObjects();
        mGridView.setAdapter(mImageAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected item number: " + position,
                        Toast.LENGTH_SHORT).show();

                Gson parser = new Gson();

                Article item = (Article) mImageAdapter.getItem(position);
                //Non animation ver.
//                ImageDetailActivity.launch(mActivity, item);
                ImageView targetImageView = (ImageView) view.findViewById(R.id.row_image);
//                ImageDetailActivity.launch(mActivity, item, targetImageView); //cannot launch


                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        mActivity,
                        targetImageView,
                        getString(R.string.trans_name) );
                Intent intent = new Intent(mActivity, ImageDetailActivity.class);
                intent.putExtra(ImageDetailActivity.EXTRA_CONTENT, parser.toJson(item));

                ActivityCompat.startActivity(mActivity, intent, options.toBundle());

            }
        });


        //Not related
        test();

    }


    //Not related
    private void test(){
        mTextView = (TextView) findViewById(R.id.textview);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.startAnimation(getAnimation());
            }
        });
    }

    //Not related
    private AnimationSet getAnimation() {
        final AnimationSet set = new AnimationSet(true);

        //どのくらいずらすか
        float jitterX = 0; //横向きにどのくらいずらすか
        float jitterY = 0; //縦向きにどのくらいずらすか

        //初めの座標をとってくる
        float startPointX = mTextView.getX();
        float startPointY = mTextView.getY();


        TranslateAnimation translate =
                new TranslateAnimation(0, startPointX + jitterX, 0, startPointY + jitterY);
        translate.setDuration(500);

        set.addAnimation(translate);
        return set;
    }


    //debug
    private void singleImageTest() {
        setContentView(R.layout.activity_main_single_image_test);

        final Article item = new Article(R.drawable.anime01, "single title", "single content");
        singleImage = (ImageView) findViewById(R.id.row_image);
        singleImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        singleImage.setImageBitmap(
                BitmapDecoder.decodeSampledBitmapFromResource(getResources(), item.getResImageId(), 100, 100));
        singleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Selected item",
                        Toast.LENGTH_SHORT).show();

                Gson parser = new Gson();
                //Non animation ver.
//                ImageDetailActivity.launch(mActivity, item);
                ImageView targetImageView = (ImageView) findViewById(R.id.row_image);
//                ImageDetailActivity.launch(mActivity, item, targetImageView); //cannot launch


                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        mActivity,
                        targetImageView,
                        getString(R.string.trans_name) );
                Intent intent = new Intent(mActivity, ImageDetailActivity.class);
                intent.putExtra(ImageDetailActivity.EXTRA_CONTENT, parser.toJson(item));

                ActivityCompat.startActivity(mActivity, intent, options.toBundle());
            }
        });
    }

    private void transitionAnimation() {
        if (Build.VERSION.SDK_INT >= 21) {
        /*
        To enable window content transitions in your code instead, call the Window.requestFeature() method:
         */
            getWindow().requestFeature(android.view.Window.FEATURE_CONTENT_TRANSITIONS);
            Transition ts = new Explode();  //Slide(); //Explode();

            ts.setStartDelay(1000);
            ts.setDuration(2000);

        /*
        If you have set an enter transition for the second activity,
        the transition is also activated when the activity starts.
         */

            getWindow().setEnterTransition(ts);
            getWindow().setExitTransition(ts);

            ChangeBounds bounds = new ChangeBounds();
            bounds.setDuration(1000);
            getWindow().setSharedElementEnterTransition(bounds);
        }
    }
}
