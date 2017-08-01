package data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;

import com.bbp.crashtower.R;

/**
 * Created by dongbin on 2017-07-31.
 */

public class CardInfo{

    public int cardID, level, width, height;

    public int maxHp, damage, power, sensorRange , attackSpeed, moveSpeed;

    public Rect body, sensor;

    public Bitmap bitmap;

    public CardInfo(Context context, int cardID, int level){
        this.cardID = cardID; this.level = level;
        setStack(context);
    }

    void setStack(Context context){
        switch (cardID){
            default:
                switch (level){
                    default:
                        width = 100;
                        height = 100;
                        maxHp = 200;
                        damage = 0;
                        power = 20;
                        moveSpeed = 20;
                        attackSpeed = 20;
                        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.baba);
                        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
                        break;
                }
            break;
        }
        sensorRange = width;
        body = new Rect(0,0,width,height);
        sensor = new Rect(body.centerX()-sensorRange,body.centerY()-sensorRange,body.centerX()+sensorRange,body.centerY()+sensorRange);
    }
}
