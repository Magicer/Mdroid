package xyz.magicer.mdroid.base;

import java.util.List;

import xyz.magicer.mdroid.model.bean.DayInfo;

public class TodayResult {

    private List<String> category;
    private boolean error;
    private DayInfo results;

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public DayInfo getResults() {
        return results;
    }

    public void setResults(DayInfo results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "TodayResult{" +
                "category=" + category +
                ", error=" + error +
                ", results=" + results +
                '}';
    }
}
