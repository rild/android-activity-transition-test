package rimp.rild.com.android.android_activity_transition_test;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
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
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });




    }

    private void test(){
        mTextView = (TextView) findViewById(R.id.textview);

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.startAnimation(getAnimation());
            }
        });
    }

    private AnimationSet getAnimation() {
        final AnimationSet set = new AnimationSet(true);

        //どのくらいずらすか
        float jitterX = 10; //横向きにどのくらいずらすか
        float jitterY = 10; //縦向きにどのくらいずらすか

        //初めの座標をとってくる
        float startPointX = mTextView.getX();
        float startPointY = mTextView.getY();

        TranslateAnimation translate =
                new TranslateAnimation(startPointX, startPointX + jitterX, startPointY, startPointY + jitterY);
        translate.setDuration(50);

        set.addAnimation(translate);
        return set;
    }
}
