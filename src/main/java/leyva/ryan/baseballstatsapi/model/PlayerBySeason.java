package leyva.ryan.baseballstatsapi.model;

public class PlayerBySeason
{
    private String playerId;
    private double battingAverage;
    private double onBasePercentage;
    private int totalAtBats;
    private int totalHits;
    private int totalHitsByPitch;
    private int totalWalks;
    private int totalSacrificeFlies;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public double getOnBasePercentage() {
        return onBasePercentage;
    }

    public void setOnBasePercentage(double onBasePercentage) {
        this.onBasePercentage = onBasePercentage;
    }

    public int getTotalAtBats() {
        return totalAtBats;
    }

    public void setTotalAtBats(int totalAtBats) {
        this.totalAtBats = totalAtBats;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(int totalHits) {
        this.totalHits = totalHits;
    }

    public int getTotalHitsByPitch() {
        return totalHitsByPitch;
    }

    public void setTotalHitsByPitch(int totalHitsByPitch) {
        this.totalHitsByPitch = totalHitsByPitch;
    }

    public int getTotalWalks() {
        return totalWalks;
    }

    public void setTotalWalks(int totalWalks) {
        this.totalWalks = totalWalks;
    }

    public int getTotalSacrificeFlies() {
        return totalSacrificeFlies;
    }

    public void setTotalSacrificeFlies(int totalSacrificeFlies) {
        this.totalSacrificeFlies = totalSacrificeFlies;
    }
}
