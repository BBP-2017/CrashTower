package data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import com.bbp.crashtower.R;

/**
 * Created by dongbin on 2017-07-31.
 */

public class CardInfo{

    public int cardID, level, width, height;

    public int maxHp, damage, power, sensorRange , attackSpeed, moveSpeed;

    public int dir;

    public Rect body, sensor;

    public Bitmap bitmap;

    public int resID;

    public CardInfo(Context context, int cardID, int level){
        this.cardID = cardID; this.level = level;
        setStack(context);
    }

    void setStack(Context context){
        switch (cardID){
            case 1:
                switch (level){
                    default:
                        width = 100;
                        height = 100;
                        maxHp = 200;
                        damage = 0;
                        power = 20;
                        moveSpeed = 20;
                        attackSpeed = 20;
                        dir = 1;
                        resID =  R.drawable.baba;
                        break;
                }
            break;
            case 2:
                switch (level){
                    default:
                        width = 200;
                        height = 200;
                        maxHp = 400;
                        damage = 0;
                        power = 40;
                        moveSpeed = 10;
                        attackSpeed = 10;
                        dir = -1;
                        resID =  R.drawable.pekka;
                        break;
                }
                break;
            default:
                switch (level){
                    default:
                        width = 300;
                        height = 400;
                        maxHp = 1000;
                        damage = 0;
                        power = 20;
                        moveSpeed = 0;
                        attackSpeed = 10;
                        dir = 0;
                        resID = R.drawable.king_tower;
                        break;
                }
                break;

        }
        sensorRange = width;
        body = new Rect(0,0,width,height);
        sensor = new Rect(body.centerX()-sensorRange,body.centerY()-sensorRange,body.centerX()+sensorRange,body.centerY()+sensorRange);
        bitmap = BitmapFactory.decodeResource(context.getResources(),resID);
        bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
    }
}
