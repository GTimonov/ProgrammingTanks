package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 01.02.2017.
 */

public abstract class RunningActor extends MainActor {

    public RunningActor() {
        super();

    }

    private Interpolation interpolation;
    private float deltaTime;
    private float distance;
    private float angle;
    private float duration;
    private float angleOFMoving;
    private Boolean isRunningNow = false;
    private Boolean isRotateNow = false;
    private Vector2 currentPosition;
    private float currentRotation;
    ///////////////////////////////////////////////////////////////////////////
    // public properties
    ///////////////////////////////////////////////////////////////////////////

    public Boolean getIsRunningNow(){return isRunningNow;}

    public Boolean getIsRotateNow(){return isRotateNow;}

    ///////////////////////////////////////////////////////////////////////////
    //  public methods
    ///////////////////////////////////////////////////////////////////////////


    public void move(Vector2 position){
        currentPosition = new Vector2(getX(), getY());
        interpolation = Interpolation.sine;
        deltaTime = 0f;
        distance = position.len();
        duration = distance / Settings.TANK_SPEED;
        angleOFMoving = position.angleRad();
        isRunningNow = true;
    }
    public void rotate(int angle){
        currentRotation = getRotation();
        interpolation = Interpolation.sine;
        deltaTime = 0f;
        this.angle = angle;
        duration = Math.abs(angle / Settings.TANK_ROTATION_SPEED);
        isRotateNow = true;
    }


    ///////////////////////////////////////////////////////////////////////////
    // override methods
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,this.getX(),getY(),this.getOriginX(),this.getOriginY(),this.getWidth(),
                this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),0,0,
                texture.getWidth(),texture.getHeight(),false,false);
    }

    @Override
    public void act(float delta){
        super.act(delta);
        if (isRunningNow)
            updateMoving(delta);
        else if (isRotateNow)
            updateRotation(delta);
    }

    ///////////////////////////////////////////////////////////////////////////
    // private methods
    ///////////////////////////////////////////////////////////////////////////


    private void updateMoving(float delta){
        deltaTime += delta;
        float progress = deltaTime / duration;
        if (progress > 1) {
            isRunningNow = false;
            return;
        }
        float distanceProgress = interpolation.apply(progress) * distance;

        setX((float)Math.cos(angleOFMoving) * distanceProgress + currentPosition.x);
        setY((float)Math.sin(angleOFMoving) * distanceProgress + currentPosition.y);
    }

    private void updateRotation(float delta){
        deltaTime += delta;
        float progress = deltaTime / duration;
        if (progress > 1){
            isRotateNow = false;
            return;
        }

        float rotateProgress = interpolation.apply(progress) * angle;
        setRotation(rotateProgress);

    }


}
