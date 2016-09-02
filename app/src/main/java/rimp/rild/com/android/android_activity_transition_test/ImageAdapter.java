package rimp.rild.com.android.android_activity_transition_test;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import rimp.rild.com.android.android_activity_transition_test.data.models.Article;


/**
 * Created by rild on 16/09/01.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.anime01, R.drawable.anime02,
            R.drawable.anime03, R.drawable.anime04,
            R.drawable.anime05, R.drawable.anime06,
            R.drawable.anime07, R.drawable.anime08,
//            R.drawable.anime01, R.drawable.anime02,
//            R.drawable.anime03, R.drawable.anime04,
//            R.drawable.anime05, R.drawable.anime06,
//            R.drawable.anime07, R.drawable.anime08,

    };

    List<Article> articles;

    public void addDummyObjects() {
        for (int resId : mThumbIds) {
            articles.add(new Article(resId, "sample title " + resId, "sample content " + resId));
        }
    }

    public void addDummyObject() {
        articles.clear();
        Log.d("Article", "article objects size: " + articles.size());
        articles.add(new Article(mThumbIds[0], "sample title " + 0, "sample content " + 0));
        articles.add(new Article(mThumbIds[1], "sample title " + 0, "sample content " + 0));
        Log.d("Article", "article objects size: " + articles.size());
    }

    public ImageAdapter(Context c) {
        mContext = c;
        articles = new ArrayList();
    }

    public int getCount() {
        return articles.size();
    }

    //return Article Object
    public Object getItem(int position) {
        return articles.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        //use the size in gridview argument/scale bitmap resource
        int layoutParams = 100;
        Log.d("Article", "position: " + position);
        final Article item = articles.get(position);

        final ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_list, null);
            imageView = (ImageView) convertView.findViewById(R.id.row_image);
            imageView.setLayoutParams(new GridView.LayoutParams(layoutParams * 3, layoutParams  * 3));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        //Resize bitmap resource after setting image to imageview
        //report: reqWidth / reqHeight over 300 required large heap and logged "The application may be doing too much work on its main thread."
//        if (layoutParams > 200) {
//            layoutParams = layoutParams / 3;
//        }

//        Picasso.with(mContext).load(item.getResImageId()).centerCrop().resize(100, 100).into(imageView);
        //report: running smoothly with reqW / H under 100.
        imageView.setImageBitmap(
                BitmapDecoder.decodeSampledBitmapFromResource(mContext.getResources(), item.getResImageId(), layoutParams, layoutParams));
        return imageView;
    }

}
