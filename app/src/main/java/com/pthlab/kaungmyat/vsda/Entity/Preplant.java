package com.pthlab.kaungmyat.vsda.Entity;

import java.io.Serializable;

public class Preplant implements Serializable {
    public int getRainValue() {
        return rainValue;
    }

    public void setRainValue(int rainValue) {
        this.rainValue = rainValue;
    }

    public int getWetSeasonValue() {
        return wetSeasonValue;
    }

    public void setWetSeasonValue(int wetSeasonValue) {
        this.wetSeasonValue = wetSeasonValue;
    }

    public int getSoilNutrientValue() {
        return soilNutrientValue;
    }

    public void setSoilNutrientValue(int soilNutrientValue) {
        this.soilNutrientValue = soilNutrientValue;
    }

    public int getLimesoilValue() {
        return limesoilValue;
    }

    public void setLimesoilValue(int limesoilValue) {
        this.limesoilValue = limesoilValue;
    }

    public int getSoilTillingValue() {
        return soilTillingValue;
    }

    public void setSoilTillingValue(int soilTillingValue) {
        this.soilTillingValue = soilTillingValue;
    }

    public int getSaltTolerantRiceValue() {
        return saltTolerantRiceValue;
    }

    public void setSaltTolerantRiceValue(int saltTolerantRiceValue) {
        this.saltTolerantRiceValue = saltTolerantRiceValue;
    }

    public int getShrimpStockingDensityValue() {
        return shrimpStockingDensityValue;
    }

    public void setShrimpStockingDensityValue(int shrimpStockingDensityValue) {
        this.shrimpStockingDensityValue = shrimpStockingDensityValue;
    }

    public int getWaterColorValue() {
        return waterColorValue;
    }

    public void setWaterColorValue(int waterColorValue) {
        this.waterColorValue = waterColorValue;
    }

    private int rainValue;
    private int wetSeasonValue;
    private int soilNutrientValue;
    private int limesoilValue;
    private int soilTillingValue;
    private int saltTolerantRiceValue;
    private int shrimpStockingDensityValue;
    private int waterColorValue;
}
