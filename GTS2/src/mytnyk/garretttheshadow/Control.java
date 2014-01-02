package mytnyk.garretttheshadow;

//import android.util.Log;
import mytnyk.gts.kernel.Direction;
import mytnyk.gts.kernel.ManualStrategy;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class Control implements OnTouchListener {
	private Scene mScene;
	private float mScaleDist = 0;

	enum CurrentAction {
		NONE,
		MOVEMENT,
		SCALE,
	}
	private CurrentAction mAction = CurrentAction.NONE;

	public Control(Scene scene)	{
		this.mScene = scene;
	}

	@Override
	public boolean onTouch(View view, MotionEvent event) {

		int action = event.getActionMasked();
		// Get the index of the pointer associated with the action.
		//int index = event.getActionIndex();

		switch (action) {
		default:
			break;
		case MotionEvent.ACTION_DOWN:
			mAction = CurrentAction.MOVEMENT;
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			mAction = CurrentAction.SCALE;
			break;
		case MotionEvent.ACTION_UP:
			if (mAction == CurrentAction.MOVEMENT) {
				int h = view.getHeight();
				int w = view.getWidth();
				int id0 = event.getPointerId(0);
				float x = event.getX(id0); // [0, 0] - left upper corner
				float y = event.getY(id0);
				
				//Log.d("ACTION", Float.toString(x) + ":" + Float.toString(y));
				
				if (Math.abs(x - 0.5f*w) > Math.abs(y - 0.5f*h)) {
					if (x > 0.5f*w) {
						ManualStrategy.mDirection = Direction.RIGHT;
					} else {
						ManualStrategy.mDirection = Direction.LEFT;
					}
				}else {
					if (y > 0.5f*h) {
						ManualStrategy.mDirection = Direction.DOWN;
					} else {
						ManualStrategy.mDirection = Direction.UP;
					}
				}
			}

			break;
		}

		//Log.d("ACTION", actionToString(action));

		if (event.getPointerCount() > 1) {

			int id1 = event.getPointerId(0);
			int id2 = event.getPointerId(1);
			float dist = (event.getX(id1) - event.getX(id2))*(event.getX(id1) - event.getX(id2)) + 
					(event.getY(id1) - event.getY(id2))*(event.getY(id1) - event.getY(id2));

			//Log.d("ACTION","Multitouch ");

			if (mScaleDist > 0) {
				if (mScaleDist > dist)
					mScene.scaleDown();
				else
					mScene.scaleUp();
			}
			mScaleDist = dist;
		}

		return true;
	}

	// Given an action int, returns a string description
	/*
	private static String actionToString(int action) {
	    switch (action) {

	        case MotionEvent.ACTION_DOWN: return "Down";
	        case MotionEvent.ACTION_MOVE: return "Move";
	        case MotionEvent.ACTION_POINTER_DOWN: return "Pointer Down";
	        case MotionEvent.ACTION_UP: return "Up";
	        case MotionEvent.ACTION_POINTER_UP: return "Pointer Up";
	        case MotionEvent.ACTION_OUTSIDE: return "Outside";
	        case MotionEvent.ACTION_CANCEL: return "Cancel";
	    }
	    return "";
	}*/

}
