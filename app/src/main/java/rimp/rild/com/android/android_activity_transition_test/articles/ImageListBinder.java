package rimp.rild.com.android.android_activity_transition_test.articles;

import android.app.Activity;
import android.view.View;

import jp.satorufujiwara.binder.recycler.RecyclerBinder;
import rimp.rild.com.android.android_activity_transition_test.data.models.Article;

/**
 * Created by rild on 16/09/02.
 */
public class ImageListBinder extends RecyclerBinder<ArticleViewType> {

    public ImageListBinder(Activity activity, Article item) {
        super(activity, ArticleViewType.Article);
    }

    @Override
    public int layoutResId() {
        return 0;
    }

    @Override
    public android.support.v7.widget.RecyclerView.ViewHolder onCreateViewHolder(View v) {
        return null;
    }

    @Override
    public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int position) {

    }
}
