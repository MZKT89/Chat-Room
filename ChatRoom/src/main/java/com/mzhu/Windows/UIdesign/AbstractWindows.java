package com.mzhu.Windows.UIdesign;

import javax.swing.*;
import java.awt.*;


/**
 * 此抽象类将被其他window、UI继承
 * window、UI基本属性
 */
public abstract class AbstractWindows extends JFrame {
 private String title;
 private Dimension defaultSize;
 private boolean resizeable;
private double outerWeight;
private double outerHeight;
private double innerWeight;
private double innerHeight;


    public AbstractWindows() {
    }

    public AbstractWindows(String title, Dimension defaultSize, boolean resizeable) {
        this.setTitle(title);
        this.setResizeable(resizeable);
        this.setDefaultSize(defaultSize);
        //设置位置(位于屏幕中央)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(calcCenter(screenSize.getWidth(),defaultSize.getWidth(),screenSize.getHeight(),defaultSize.getHeight()));
    }

    public AbstractWindows(String title, Dimension defaultSize, boolean resizeable, double outerWeight, double outerHeight, double innerWeight, double innerHeight) {
        this.title = title;
        this.defaultSize = defaultSize;
        this.resizeable = resizeable;
        this.outerWeight = outerWeight;
        this.outerHeight = outerHeight;
        this.innerWeight = innerWeight;
        this.innerHeight = innerHeight;
    }

    private Point calcCenter(double outerWidth, double outerHeight, double innerWidth, double innerHeight){
        int x = (int) ((outerWidth - innerWidth) / 2);
        int y = (int) ((outerHeight - innerHeight) / 2);
        return new Point(x, y);
    }
    public final void open(){
        super.setVisible(true);
    }
    protected abstract void initWindowContent();

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return defaultSize
     */
    public Dimension getDefaultSize() {
        return defaultSize;
    }

    /**
     * 设置
     * @param defaultSize
     */
    public void setDefaultSize(Dimension defaultSize) {
        this.defaultSize = defaultSize;
    }

    /**
     * 获取
     * @return resizeable
     */
    public boolean isResizeable() {
        return resizeable;
    }

    /**
     * 设置
     * @param resizeable
     */
    public void setResizeable(boolean resizeable) {
        this.resizeable = resizeable;
    }

    public String toString() {
        return "AbstractWindows{title = " + title + ", defaultSize = " + defaultSize + ", resizeable = " + resizeable + "}";
    }

    /**
     * 获取
     * @return outerWeight
     */
    public double getOuterWeight() {
        return outerWeight;
    }

    /**
     * 设置
     * @param outerWeight
     */
    public void setOuterWeight(double outerWeight) {
        this.outerWeight = outerWeight;
    }

    /**
     * 获取
     * @return outerHeight
     */
    public double getOuterHeight() {
        return outerHeight;
    }

    /**
     * 设置
     * @param outerHeight
     */
    public void setOuterHeight(double outerHeight) {
        this.outerHeight = outerHeight;
    }

    /**
     * 获取
     * @return innerWeight
     */
    public double getInnerWeight() {
        return innerWeight;
    }

    /**
     * 设置
     * @param innerWeight
     */
    public void setInnerWeight(double innerWeight) {
        this.innerWeight = innerWeight;
    }

    /**
     * 获取
     * @return innerHeight
     */
    public double getInnerHeight() {
        return innerHeight;
    }

    /**
     * 设置
     * @param innerHeight
     */
    public void setInnerHeight(double innerHeight) {
        this.innerHeight = innerHeight;
    }
}
