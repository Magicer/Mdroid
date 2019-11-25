package xyz.magicer.mdroid.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DayInfo {
    private List<ResultInfo> iOS;
    private List<ResultInfo> Android;
    //瞎推荐
    @SerializedName("瞎推荐")
    private List<ResultInfo> blind;
    //拓展资源
    @SerializedName("拓展资源")
    private List<ResultInfo> resource;
    @SerializedName("福利")
    private List<ResultInfo> welfare;
    @SerializedName("休息视频")
    private List<ResultInfo> videos;

    public List<ResultInfo> getiOS() {
        return iOS;
    }

    public void setiOS(List<ResultInfo> iOS) {
        this.iOS = iOS;
    }

    public List<ResultInfo> getAndroid() {
        return Android;
    }

    public void setAndroid(List<ResultInfo> android) {
        Android = android;
    }

    public List<ResultInfo> getBlind() {
        return blind;
    }

    public void setBlind(List<ResultInfo> blind) {
        this.blind = blind;
    }

    public List<ResultInfo> getResource() {
        return resource;
    }

    public void setResource(List<ResultInfo> resource) {
        this.resource = resource;
    }

    public List<ResultInfo> getWelfare() {
        return welfare;
    }

    public void setWelfare(List<ResultInfo> welfare) {
        this.welfare = welfare;
    }

    public List<ResultInfo> getVideos() {
        return videos;
    }

    public void setVideos(List<ResultInfo> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "DayInfo{" +
                "iOS=" + iOS +
                ", Android=" + Android +
                ", blind=" + blind +
                ", resource=" + resource +
                ", welfare=" + welfare +
                ", videos=" + videos +
                '}';
    }
}
