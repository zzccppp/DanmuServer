package info.zzdirty.main;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author ZZDirty
 */
public class DanmuDataBean {

    private String version;

    @JSONField(name = "content-type")
    private String contenttype;

    private String id;
    private String type;
    private String size;
    private String color;
    private String text;
    private String encode;

    @JSONField(name = "time")
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public String getVersion() {
        return version;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }
    public String getContenttype() {
        return contenttype;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public String getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }
    public String getEncode() {
        return encode;
    }

    @Override
    public String toString() {
        return "DanmuDataBean{" +
                "version='" + version + '\'' +
                ", content-type='" + contenttype + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", text='" + text + '\'' +
                ", encode='" + encode + '\'' +
                '}';
    }
}