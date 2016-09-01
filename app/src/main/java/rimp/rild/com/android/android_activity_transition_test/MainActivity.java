package rimp.rild.com.android.android_activity_transition_test;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import rimp.rild.com.android.android_activity_transition_test.data.models.Article;

public class MainActivity extends AppCompatActivity {
    GridView mGridView;
    TextView mTextView;

    Activity mActivity;
    ImageAdapter mImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = this;
        mGridView = (GridView) findViewById(R.id.gridview);
        mImageAdapter = new ImageAdapter(this);
        mGridView.setAdapter(mImageAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected item number: " + position,
                        Toast.LENGTH_SHORT).show();

                Gson parser = new Gson();

                //Non animation ver.
//                Article item = (Article) mImageAdapter.getItem(position);
//                Intent intent = new Intent(mActivity, ImageDetailActivity.class);
//                intent.putExtra(ImageDetailActivity.EXTRA_CONTENT, parser.toJson(item));
//                startActivity(intent);

                //Animation ver.
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        mActivity,
                        view.findViewById(R.id.row_image),
                        getString(R.string.trans_name) );
                Article item = (Article) mImageAdapter.getItem(position);
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
}
