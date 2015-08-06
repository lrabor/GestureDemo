package com.rabor.gesturedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import com.rabor.gesturedemo.SimpleGestureFilter.SimpleGestureListener;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.Toast;

import static android.view.GestureDetector.*;


public class MainActivity extends AppCompatActivity implements OnGestureListener,
OnDoubleTapListener, SimpleOnGestureListener {

    private TextView myMessageTextView;
    private GestureDetectorCompat gestureDetector;
    private SimpleGestureFilter detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myMessageTextView = (TextView)findViewById(R.id.myMessageTextView);
        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
        detector = new SimpleGestureFilter(this, (SimpleGestureListener) this);
    }

    //////////////// Begin Gestures ////////////////

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        myMessageTextView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        myMessageTextView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        myMessageTextView.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        myMessageTextView.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        myMessageTextView.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        myMessageTextView.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        myMessageTextView.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        myMessageTextView.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        myMessageTextView.setText("onFling");
        return true;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me){
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {
        String str = "";

        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT : str = "Swipe Right";
                break;
            case SimpleGestureFilter.SWIPE_LEFT :  str = "Swipe Left";
                break;
            case SimpleGestureFilter.SWIPE_DOWN :  str = "Swipe Down";
                break;
            case SimpleGestureFilter.SWIPE_UP :    str = "Swipe Up";
                break;

        }

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    //////////////// End Gestures ////////////////

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
