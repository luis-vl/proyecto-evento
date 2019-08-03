/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author fernando
 */
public class PasswordField extends JPasswordField implements ComponentListener {

    private final JButton btn = new JButton();
    private Color borde_color = Color.black;
    
    private ImageIcon iconBlack = new ImageIcon(getClass().getResource("/Imagenes/metro_x_b.png"));
    private ImageIcon iconWhite = new ImageIcon(getClass().getResource("/Imagenes/metro_x_w.png"));
    private boolean x_black_icon = true;
    private Dimension dimension = new Dimension(300, 42);
    
    private int heigth_btn = dimension.height - 10;
    
    public PasswordField(){
        setSize(dimension);
        setPreferredSize(dimension);
        
        this.btn.setText("");
        this.btn.setBorderPainted(false);
        this.btn.setContentAreaFilled(false);
        this.btn.setMargin(new Insets(2, 2, 2, 2));
        this.btn.setVisible(true);
        this.btn.setFocusPainted(false);
        this.btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(this.btn);
        setVisible(true);
        addComponentListener(this);
        setSelectionColor(this.btn.getBackground());
        updateButton();
        
        this.btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ((JPasswordField)btn.getParent()).setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setOpaque(true);
                btn.setIcon((x_black_icon)?iconBlack:iconWhite);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setOpaque(false);
                btn.setIcon(null);
            }
        });
        
        
    }

    public boolean isX_black_icon() {
        return x_black_icon;
    }

    public void setX_black_icon(boolean x_black_icon) {
        this.x_black_icon = x_black_icon;
    }

    public Color getBoton_color() {
        return this.btn.getBackground();
    }

    public void setBoton_color(Color boton_color) {
        this.btn.setBackground(boton_color);
        setSelectionColor(this.btn.getBackground());
    }

    public Color getBorde_color() {
        return borde_color;
    }

    public void setBorde_color(Color borde_color) {
        this.borde_color = borde_color;
        updateBorder();
    }
    
    private void updateBorder(){
        Border border = BorderFactory.createLineBorder(borde_color, 0);
        setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder
        (10, 10, 10, this.btn.getSize().width + 5)));
    }
    
    private void updateButton(){
        this.heigth_btn = this.getSize().height - 10;
        this.btn.setSize(new Dimension(this.heigth_btn, this.heigth_btn));
        this.btn.setPreferredSize(new Dimension(this.heigth_btn, this.heigth_btn));
        this.btn.setLocation(getWidth() - this.btn.getWidth() - 5, 5);
        updateBorder();
    }
    
    

    @Override
    public void componentResized(ComponentEvent e) {
        updateButton();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
    
}
