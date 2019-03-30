package mahamat.abagana.kachallah.com.projet_iot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MyView extends View {

    Paint paint = new Paint(Paint.FAKE_BOLD_TEXT_FLAG);
    Path starPath;
    Path curvePath;
    Paint textPaint = new Paint(Paint.LINEAR_TEXT_FLAG);
    private final Drawable drawable;

    public MyView(Context context, Drawable draw)
    {
        super(context);
        setMinimumWidth(600);
        setMinimumHeight(600);
        drawable = draw;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.save();
        drawable.draw(canvas);
        canvas.restore();

        // Un cadre
        /*Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        Rect r = canvas.getClipBounds();
        canvas.drawRect(r, paint);*/
    }

}
