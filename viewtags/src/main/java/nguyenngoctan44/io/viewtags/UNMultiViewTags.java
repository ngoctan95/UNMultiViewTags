package nguyenngoctan44.io.viewtags;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class UNMultiViewTags extends ViewGroup {

    public UNMultiViewTags(Context context) {
        super(context);
    }

    public UNMultiViewTags(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UNMultiViewTags(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int currentWidth, currentLeft, currentHeight, currentTop, maximumHeight;

        int childLeft = this.getPaddingLeft();
        int childTop = this.getPaddingTop();

        int childRight = this.getMeasuredWidth() - this.getPaddingRight();
        int childBottom = this.getMeasuredHeight() - this.getPaddingBottom();

        int childWidth = childRight - childLeft;
        int childHeight = childBottom - childTop;

        maximumHeight = 0;
        currentLeft = childLeft;
        currentTop = childTop;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE)
                return;

            child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST),
                    MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
            currentWidth = child.getMeasuredWidth();
            currentHeight = child.getMeasuredHeight();

            if (currentLeft + currentWidth >= childRight) {
                currentLeft = childLeft;
                currentTop += maximumHeight;
                maximumHeight = 0;
            }

            child.layout(currentLeft, currentTop, currentLeft + currentWidth, currentTop + currentHeight);

            if (maximumHeight < currentHeight)
                maximumHeight = currentHeight;
            currentLeft += currentWidth;
        }
    }
}
