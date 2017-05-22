import com.alee.laf.WebLookAndFeel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DunaevKA on 16.03.2017.
 */
public class Other {
    public static void frameDisplayCenter (int sizeWidth, int sizeHeight, Frame frame) {
        //Положение окна в зависимости от формата экрана
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locationX = (screenSize.width - sizeWidth) / 2;
        int locationY = (screenSize.height - sizeHeight) / 2;
        frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
    }
    public static void WebLFActiv(){
        WebLookAndFeel.install();
    }
    public static void Kost(JFrame Frame){
        Frame.setSize(Frame.getWidth(), Frame.getHeight()+1);
        Frame.setSize(Frame.getWidth(), Frame.getHeight()-1);
    }
}
