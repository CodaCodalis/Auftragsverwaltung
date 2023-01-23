package de.oszimt.ls11a1.model.base;

import de.oszimt.ls11a1.view.IView;

import java.util.ArrayList;

public abstract class BaseObject {
    private int id;
    private final ArrayList<IView> views = new ArrayList<>();
    public BaseObject(int id) {
        this.id = id;
    }

    public void addView(IView view) {
        views.add(view);
        view.refresh();
    }

    public void notifyViews() {
        for (IView view : views) {
            view.refresh();
        }
    }

    public ArrayList<IView> getAllViews() {
        return views;
    }

    public void removeView(IView view) {
        views.remove(view);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyViews();
    }
}
