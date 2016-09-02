# What
Main: Activity transition animation test.

Using GridView Test.

# DONE
finished in 2016/09/01

<img width="300" height="519" alt="override_method" src="./demos/activity_transition_test_alpha.gif">

# Bugs Report

## Animation Do Not Move Slimy
There is situation that animation would not move slimy.
### went well
Google Nexus 5 (Genymotion)

(Back)onBackPressed

### something trouble
Sony Xperia Z3 (Actual equipment)

(Back) Intent from ImageDetailActivity to MainActivity 

#### Error Log

```
E/ActivityThread: Performing stop of activity that is not resumed: {rimp.rild.com.android.android_activity_transition_test/rimp.rild.com.android.android_activity_transition_test.MainActivity}
                                                                                                      java.lang.RuntimeException: Performing stop of activity that is not resumed: {rimp.rild.com.android.android_activity_transition_test/rimp.rild.com.android.android_activity_transition_test.MainActivity}
                                                                                                          at android.app.ActivityThread.performStopActivityInner(ActivityThread.java:3412)
                                                                                                          at android.app.ActivityThread.handleStopActivity(ActivityThread.java:3493)
                                                                                                          at android.app.ActivityThread.access$1100(ActivityThread.java:149)
                                                                                                          at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1355)
                                                                                                          at android.os.Handler.dispatchMessage(Handler.java:102)
                                                                                                          at android.os.Looper.loop(Looper.java:211)
                                                                                                          at android.app.ActivityThread.main(ActivityThread.java:5335)
                                                                                                          at java.lang.reflect.Method.invoke(Native Method)
                                                                                                          at java.lang.reflect.Method.invoke(Method.java:372)
                                                                                                          at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:1016)
                                                                                                          at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:811)
```


```
W/art: Suspending all threads took: 6.515ms
```


```


09-01 20:30:02.155 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:02.155 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xdfffe520, error=EGL_SUCCESS
09-01 20:30:02.239 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:02.239 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xe0ad6e60, error=EGL_SUCCESS
09-01 20:30:02.697 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=true
09-01 20:30:02.709 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b2830
09-01 20:30:03.285 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-01 20:30:03.325 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:03.325 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xdfe07d20, error=EGL_SUCCESS
09-01 20:30:03.341 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-01 20:30:03.757 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b3390
09-01 20:30:04.132 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b28a0
09-01 20:30:04.856 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:04.856 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xdfe07100, error=EGL_SUCCESS
                                                                                                      
                                                                                                      [ 09-01 20:30:04.857   606: 2101 D/         ]
                                                                                                      HostConnection::get() New Host Connection established 0xf6c3e580, tid 2101
09-01 20:30:04.958 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:04.958 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xe0ad6b00, error=EGL_SUCCESS
09-01 20:30:05.400 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=true
09-01 20:30:05.418 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b2360
09-01 20:30:08.454 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-01 20:30:08.485 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:08.485 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xdfffe500, error=EGL_SUCCESS
09-01 20:30:08.501 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-01 20:30:08.691 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b3240
09-01 20:30:08.913 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b32b0
09-01 20:30:11.566 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:11.566 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xdfe070e0, error=EGL_SUCCESS
09-01 20:30:11.684 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:11.684 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xdfffed60, error=EGL_SUCCESS
09-01 20:30:12.098 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=true
09-01 20:30:12.110 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b27c0
09-01 20:30:12.781 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-01 20:30:12.821 1612-1630/rimp.rild.com.android.android_activity_transition_test W/EGL_emulation: eglSurfaceAttrib not implemented
09-01 20:30:12.821 1612-1630/rimp.rild.com.android.android_activity_transition_test W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0xdfe07440, error=EGL_SUCCESS
09-01 20:30:12.834 1612-1612/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-01 20:30:13.244 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b28a0
09-01 20:30:13.536 1612-1630/rimp.rild.com.android.android_activity_transition_test E/Surface: getSlotFromBufferLocked: unknown buffer: 0xeb0b3320
```

```
09-02 09:32:55.853 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_launch_request id:rimp.rild.com.android.android_activity_transition_test time:228435587
09-02 09:32:56.080 12377-12463/rimp.rild.com.android.android_activity_transition_test V/RenderScript: Application requested CPU execution
09-02 09:32:56.089 12377-12463/rimp.rild.com.android.android_activity_transition_test V/RenderScript: 0xa0455600 Launching thread(s), CPUs 4
09-02 09:32:56.524 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_idle id: android.os.BinderProxy@24d58f0 time:228436258
09-02 09:32:56.565 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=true
09-02 09:32:57.661 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-02 09:32:57.713 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-02 09:32:58.189 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_idle id: android.os.BinderProxy@252599db time:228437923
09-02 09:33:00.029 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_launch_request id:rimp.rild.com.android.android_activity_transition_test time:228439763
09-02 09:33:00.337 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_idle id: android.os.BinderProxy@9b4cb98 time:228440072
09-02 09:33:00.631 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=true
09-02 09:33:02.174 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-02 09:33:02.205 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-02 09:33:02.264 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-02 09:33:02.735 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_idle id: android.os.BinderProxy@252599db time:228442469
09-02 09:33:03.878 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_launch_request id:rimp.rild.com.android.android_activity_transition_test time:228443612
09-02 09:33:04.215 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_idle id: android.os.BinderProxy@30949527 time:228443949
09-02 09:33:04.445 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=true
09-02 09:33:05.763 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-02 09:33:05.818 12377-12377/rimp.rild.com.android.android_activity_transition_test D/ViewRootImpl: changeCanvasOpacity: opaque=false
09-02 09:33:06.278 12377-12377/rimp.rild.com.android.android_activity_transition_test I/Timeline: Timeline: Activity_idle id: android.os.BinderProxy@252599db time:228446012
```

# Making Process

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

## call onBackPressed

[](http://stackoverflow.com/questions/10718789/how-to-press-back-button-in-android-programatically)


# Reference

- [画像ライブラリPicassoの使い方](http://qiita.com/hotchemi/items/33ebd5faa42d2d05c2b6)
