# What
Main: Activity transition animation test.

Using GridView Test.


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
