package com.pthlab.kaungmyat.vsda.Entity;

import java.io.Serializable;

public class Plant implements Serializable {
    public int getSoilSalinityValue() {
        return soilSalinityValue;
    }

    public void setSoilSalinityValue(int soilSalinityValue) {
        this.soilSalinityValue = soilSalinityValue;
    }

    private int soilSalinityValue;
    private int soilPHValue;
    private int soilNutrientValue;
    private int waterTemperatureValue;
    private int waterSalinityValue;
    private int saltTolerantRiceValue;
    private int shrimpStockingDensityValue;
    private int waterColorManagementValue;

    public int getSoilPHValue() {
        return soilPHValue;
    }

    public void setSoilPHValue(int soilPHValue) {
        this.soilPHValue = soilPHValue;
    }

    public int getSoilNutrientValue() {
        return soilNutrientValue;
    }

    public void setSoilNutrientValue(int soilNutrientValue) {
        this.soilNutrientValue = soilNutrientValue;
    }

    public int getWaterTemperatureValue() {
        return waterTemperatureValue;
    }

    public void setWaterTemperatureValue(int waterTemperatureValue) {
        this.waterTemperatureValue = waterTemperatureValue;
    }

    public int getWaterSalinityValue() {
        return waterSalinityValue;
    }

    public void setWaterSalinityValue(int waterSalinityValue) {
        this.waterSalinityValue = waterSalinityValue;
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

    public int getWaterColorManagementValue() {
        return waterColorManagementValue;
    }

    public void setWaterColorManagementValue(int waterColorManagementValue) {
        this.waterColorManagementValue = waterColorManagementValue;
    }
}
