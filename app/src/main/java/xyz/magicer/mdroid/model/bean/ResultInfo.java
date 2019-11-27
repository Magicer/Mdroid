package xyz.magicer.mdroid.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class ResultInfo {

    /**
     * _id : 5c4bfdc19d212243205cc7f3
     * createdAt : 2019-01-26T06:27:13.191Z
     * desc : 这篇文章聊明白管理状态这一堆看起来挺复杂的东西。
     * publishedAt : 2019-04-10T00:00:00.0Z
     * source : web
     * type : 前端
     * url : https://zhuanlan.zhihu.com/p/53599723
     * used : true
     * who : bym
     */

    @SerializedName("_id")
    private String id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultInfo that = (ResultInfo) o;
        return used == that.used &&
                Objects.equals(id, that.id) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(publishedAt, that.publishedAt) &&
                Objects.equals(source, that.source) &&
                Objects.equals(type, that.type) &&
                Objects.equals(url, that.url) &&
                Objects.equals(who, that.who);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, desc, publishedAt, source, type, url, used, who);
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "id='" + id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                '}';
    }
}
