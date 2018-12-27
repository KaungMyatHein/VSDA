package com.pthlab.kaungmyat.vsda.Entity;

import java.io.Serializable;

public class PostPlant implements Serializable {


    int soilPhValue;
    int soilNutrientValue;
    int waterTemperatureValue;
    int waterSalinityValue;
    int saltTolerantRiceValue;
    int shrimpStoclingDensityValue;
    int wateColorManagementValue;

    public int getSoilSalinityValue() {
        return soilSalinityValue;
    }

    public void setSoilSalinityValue(int soilSalinityValue) {
        this.soilSalinityValue = soilSalinityValue;
    }

    int soilSalinityValue;

    public int getSoilPhValue() {
        return soilPhValue;
    }

    public void setSoilPhValue(int soilPhValue) {
        this.soilPhValue = soilPhValue;
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

    public int getShrimpStoclingDensityValue() {
        return shrimpStoclingDensityValue;
    }

    public void setShrimpStoclingDensityValue(int shrimpStoclingDensityValue) {
        this.shrimpStoclingDensityValue = shrimpStoclingDensityValue;
    }

    public int getWateColorManagementValue() {
        return wateColorManagementValue;
    }

    public void setWateColorManagementValue(int wateColorManagementValue) {
        this.wateColorManagementValue = wateColorManagementValue;
    }

}
