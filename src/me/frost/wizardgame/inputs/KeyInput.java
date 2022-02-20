package me.frost.wizardgame.inputs;

import me.frost.wizardgame.framework.GameObject;
import me.frost.wizardgame.framework.Handler;
import me.frost.wizardgame.framework.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++){
            GameObject obj = handler.objects.get(i);

            if (obj.getID() == ID.Player) {
                //key events for player 1

                if (key == KeyEvent.VK_W) { obj.setVelY(-5); keyDown[0] = true; }
                if (key == KeyEvent.VK_A) { obj.setVelX(-5); keyDown[1] = true; }
                if (key == KeyEvent.VK_S) { obj.setVelY(5); keyDown[2] = true; }
                if (key == KeyEvent.VK_D) { obj.setVelX(5); keyDown[3] = true;}
            }
        }

        if (key == KeyEvent.VK_ESCAPE) System.exit(1);

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++){
            GameObject obj = handler.objects.get(i);

            if (obj.getID() == ID.Player) {
                //key events for player 1

                if (key == KeyEvent.VK_W) { obj.setVelY(0); keyDown[0] = false; }
                if (key == KeyEvent.VK_A) { obj.setVelX(0); keyDown[1] = false; }
                if (key == KeyEvent.VK_S) { obj.setVelY(0); keyDown[2] = false; }
                if (key == KeyEvent.VK_D) { obj.setVelX(0); keyDown[3] = false;}
            }
        }


    }

}