package mahamat.abagana.kachallah.com.projet_iot;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Boussole extends Drawable {

    private ColorFilter filter;
    private int opacity;
    private float direction;
    private int cx;
    private int cy;
    private int lenght;

    public Boussole(float degres)
    {
        direction = degres;
        cx = 300;
        cy = 300;
        lenght = 550;
        opacity = 100;
    }

    public void setDirection(float degres)
    {
        direction = degres;
    }

    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();

        paint.setColorFilter(filter);
        paint.setAlpha(opacity);
        paint.setTextSize(30);

        canvas.save();

        Path sudPath = creerSudPath();
        Path nordPath = creerNordPath();

        float fontHeight = paint.getFontMetrics().ascent  +  paint.getFontMetrics().descent;

        // Centrer le compas au milieu de l'écran
        canvas.translate(cx, cy);

        // Effectuer une rotation de canvas, de sorte que la flèche indique le nord
        // quand on la dessine verticalement
        canvas.rotate(direction);

        // Définir le cadran
        paint.setColor(0xFFEEEEEE);
        canvas.drawCircle(0, 0, (lenght+20) / 2, paint);

        // Dessiner le cercle de la boussole
        paint.setColor(Color.GRAY);
        canvas.drawCircle(0, 0, lenght / 2, paint);

        // Dessiner la graduation du compas
        paint.setColor(Color.WHITE);
        float hText = - lenght/2 - fontHeight+3;

        // Tous les 15° faire une graduation
        int step = 15;
        for (int degree = 0; degree < 360; degree = degree + step)
        {
            // Si ce n'est pas un point cardinal, dessiner une graduation
            if ((degree % 90) != 0)
            {
                canvas.drawText("|", 0, hText, paint);
            }
            canvas.rotate(-step);
        }

        // Dessiner les points cardinaux
        canvas.drawText("N", 0, hText, paint);
        canvas.rotate(-90);
        canvas.drawText("W", 0, hText, paint);
        canvas.rotate(-90);
        canvas.drawText("S", 0, hText, paint);
        canvas.rotate(-90);
        canvas.drawText("E", 0, hText, paint);
        canvas.rotate(-90);

        // Dessiner les flèches
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawPath(nordPath, paint);
        paint.setColor(Color.BLUE);
        canvas.drawPath(sudPath, paint);

        // Restaurer l'état initial du canvas
        canvas.restore();
    }

    private Path creerSudPath()
    {
        Path sudPath = new Path();

        sudPath.moveTo(-10,0);
        sudPath.lineTo(0,lenght/3);
        sudPath.lineTo(10,0);
        sudPath.close();

        return  sudPath;
    }

    private Path creerNordPath()
    {
        Path nordPath = new Path();

        nordPath.moveTo(0, -(lenght/3));
        nordPath.lineTo(-10, 0);
        nordPath.lineTo(10,0);
        nordPath.close();

        return  nordPath;
    }

    @Override
    public int getOpacity()
    {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setAlpha(int alpha)
    {
    }

    @Override
    public void setColorFilter(ColorFilter cf)
    {
    }
}

