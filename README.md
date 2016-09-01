# What
Main: Activity transition animation test.

Using GridView Test.

# DONE
finished in 2016/09/01

<img width="300"  alt="override_method" src="./demos/activity_transition_test_alpha.gif">

# Making

## GridView
[Android Developers : GridView](https://developer.android.com/guide/topics/ui/layout/gridview.html)

## put article object into detail activity
Used Gson Library.
[How to pass gson serialised object to Intent in android](http://stackoverflow.com/questions/21761438/how-to-pass-gson-serialised-object-to-intent-in-android)

- Article.java
- MainActivity.java
- ImageDetailActivity.java 

depends on the library.

## inflate gridview views from res/layout

```
public View getView(int position, View convertView, ViewGroup parent) {
    ...
    convertView = LayoutInflater.from(mContext).inflate(R.layout.row_list, null);
    ...
}
```
# Trouble Shooting

## OutOfMemory
Loading many drawable resource (about 300 ~ 800 px * 8) cause OutOfMemory.

### enable large heap

```
 <application
    ...
    android:largeHeap="true"
    ...
    >
```

in AndroidManifest.xml

**Postscript**
it seems to be resolved with decoding bitmap resource. 

### decode bitmap resource

reference: [Android Developers : Loading Large Bitmaps Efficiently](https://developer.android.com/training/displaying-bitmaps/load-bitmap.html)

use the method in *ImageAdapter.java* 

**Postscript**
Bitmap resource size need not be the same as layoutParam size in GridView ...? 



