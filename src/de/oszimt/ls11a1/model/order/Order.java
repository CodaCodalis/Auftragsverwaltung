package de.oszimt.ls11a1.model.order;

import de.oszimt.ls11a1.model.base.BaseObject;
import de.oszimt.ls11a1.view.IView;
import java.util.ArrayList;

public class Order extends BaseObject {
    private String comment;
    private String time;
    private String date;
    private String status;

    @Override
    public String toString() {
        return "Order{" +
                "comment='" + comment + '\'' +
                ", views='" + getAllViews() + '\'' +
                ", id=" + getId() +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Order(int id, String comment, String status, String date, String time) {
        super(id);
        this.comment = comment;
        this.time = time;
        this.date = date;
        this.status = status;
    }

    public Order(int id, String comment, String status) {
        super(id);
        this.comment = comment;
        this.status = status;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
