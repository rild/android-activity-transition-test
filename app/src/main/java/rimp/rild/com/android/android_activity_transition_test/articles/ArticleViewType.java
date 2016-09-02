package rimp.rild.com.android.android_activity_transition_test.articles;

import jp.satorufujiwara.binder.ViewType;

/**
 * Created by rild on 16/09/02.
 */
public enum  ArticleViewType implements ViewType {
    Article;

    @Override
    public int viewType() {
        return ordinal();
    }
}
