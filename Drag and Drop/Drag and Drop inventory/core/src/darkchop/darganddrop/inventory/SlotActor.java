/* Copyright (c) 2014 PixelScientists
 * 
 * The MIT License (MIT)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package darkchop.darganddrop.inventory;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import darkchop.darganddrop.MainGame;

public class SlotActor extends ImageButton implements SlotListener {


    private Slot slot;
    MainGame game;
    private Skin skin;


    public SlotActor(Skin skin, Slot slot, MainGame game) {
        super(createStyle(skin, slot, game));
        this.slot = slot;
        this.skin = skin;
        this.game = game;
        slot.addListener(this);


    }

    private static ImageButtonStyle createStyle(Skin skin, Slot slot, MainGame game) {
        TextureAtlas icons = game.textureAtlasIcons();
        TextureRegion image;
        if (slot.getItem() != null) {
            image = icons.findRegion(slot.getItem().getTextureRegion());
        } else {
            image = icons.findRegion("nothing");
        }
        ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
        style.imageUp = new TextureRegionDrawable(image);
        style.imageDown = new TextureRegionDrawable(image);

        return style;
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public void hasChanged(Slot slot) {
        setStyle(createStyle(skin, slot, game));
    }

}
