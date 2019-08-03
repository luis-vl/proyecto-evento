/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import javax.swing.Icon;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author luisv
 */
public class IconFontUtil {
    
    private final Color green;
    
    public IconFontUtil() {
        IconFontSwing.register(FontAwesome.getIconFont());
        green = new Color(100,221,23);
    }

    public Icon getEvt_G() {
        return IconFontSwing.buildIcon(FontAwesome.CALENDAR, 30, green);
    }
    
    public Icon getEvt_B() {
        return IconFontSwing.buildIcon(FontAwesome.CALENDAR, 30, Color.BLACK);
    }
    
    public Icon getServicio_G() {
        return IconFontSwing.buildIcon(FontAwesome.SHOPPING_BAG, 30, green);
    }
    
    public Icon getServicio_B() {
        return IconFontSwing.buildIcon(FontAwesome.SHOPPING_BAG, 30, Color.BLACK);
    }
    
    public Icon getMant_G() {
        return IconFontSwing.buildIcon(FontAwesome.WRENCH, 30, green);
    }
    
    public Icon getMant_B() {
        return IconFontSwing.buildIcon(FontAwesome.WRENCH, 30, Color.BLACK);
    }
    
    public Icon getTablas_G() {
        return IconFontSwing.buildIcon(FontAwesome.TABLE, 30, green);
    }
    
    public Icon getTablas_B() {
        return IconFontSwing.buildIcon(FontAwesome.TABLE, 30, Color.BLACK);
    }
    
    public Icon getUsuarios_G() {
        return IconFontSwing.buildIcon(FontAwesome.USERS, 30, green);
    }
    
    public Icon getUsuarios_B() {
        return IconFontSwing.buildIcon(FontAwesome.USERS, 30, Color.BLACK);
    }
}
