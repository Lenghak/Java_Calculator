package resource.font;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class QuickSand {

    private static Font quickSand;


    public static Font getFont(int style, float size){

            try {
                quickSand = Font.createFont(Font.TRUETYPE_FONT, new File("static/font/Quicksand-Bold.ttf"));
                quickSand = QuickSand.quickSand.deriveFont(style, size);

            } catch (FontFormatException | IOException e) {
                throw new RuntimeException(e);
            }

        return quickSand;
    }

}
