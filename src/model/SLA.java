package model;

public class SLA {
    private int slaId;
    private int categoryId;
    private int maxResponseTime;
    private int maxResolutionTime;
    private String slaName;

    public int getSlaId() { return slaId; }
    public void setSlaId(int slaId) { this.slaId = slaId; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getMaxResponseTime() { return maxResponseTime; }
    public void setMaxResponseTime(int maxResponseTime) { this.maxResponseTime = maxResponseTime; }

    public int getMaxResolutionTime() { return maxResolutionTime; }
    public void setMaxResolutionTime(int maxResolutionTime) { this.maxResolutionTime = maxResolutionTime; }

    public String getSlaName() { return slaName; }
    public void setSlaName(String slaName) { this.slaName = slaName; }
}
