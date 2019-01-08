package com.pthlab.kaungmyat.vsda.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.pthlab.kaungmyat.vsda.Entity.Plant;
import com.pthlab.kaungmyat.vsda.Entity.PostPlant;
import com.pthlab.kaungmyat.vsda.Entity.Preplant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper  {

    //VARIABLE DECLARATION
    private static final String DB_NAME = "VSDADB.sqlite";
    private float probability_of_rice_faliure;
    private float probability_of_shrimp_faliure;

    private Context context;

    public DatabaseHelper(Context context) {
        super();
        this.context = context;
    }

    public SQLiteDatabase openDatabase() {
        File dbFile = context.getDatabasePath(DB_NAME);

        if (!dbFile.exists()) {
            try {
                copyDatabase(dbFile);
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }

        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READONLY);
    }

    private void copyDatabase(File dbFile) throws IOException {
        InputStream is = context.getAssets().open(DB_NAME);
        OutputStream os = new FileOutputStream(dbFile);

        byte[] buffer = new byte[1024];
        while (is.read(buffer) > 0) {
            os.write(buffer);
        }

        os.flush();
        os.close();
        is.close();
    }

    public float getPreplantRiceFaliureRate(Preplant preplant) {
        String query="select probability_of_rice_faliure from preplant WHERE " +
                "Rain = '" +preplant.getRainValue()+
                "' AND wet_season = '" + preplant.getWetSeasonValue() +
                "' AND soil_nutrient = '" + preplant.getSoilNutrientValue() +
                "' AND lime_soil = '" + preplant.getLimesoilValue() +
                "' AND soil_tilling = '" + preplant.getSoilTillingValue() +
                "' AND sali_tolerant_rice = '" + preplant.getSaltTolerantRiceValue() +
                "' AND water_color_management = '" + preplant.getWaterColorValue() +
                "' AND shrimp_stocking_density = '"+preplant.getShrimpStockingDensityValue()+"';";
        SQLiteDatabase db = openDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst())
        {
            int index = c.getColumnIndex("probability_of_rice_faliure");
            probability_of_rice_faliure = c.getFloat(index);
        }
        return  probability_of_rice_faliure;
    }

    public float getPreplantShrimpFaliureRate(Preplant preplant) {
        String query="select probability_of_shrimp_faliure from preplant WHERE " +
                "Rain = '" +preplant.getRainValue()+
                "' AND wet_season = '" + preplant.getWetSeasonValue() +
                "' AND soil_nutrient = '" + preplant.getSoilNutrientValue() +
                "' AND lime_soil = '" + preplant.getLimesoilValue() +
                "' AND soil_tilling = '" + preplant.getSoilTillingValue() +
                "' AND sali_tolerant_rice = '" + preplant.getSaltTolerantRiceValue() +
                "' AND water_color_management = '" + preplant.getWaterColorValue() +
                "' AND shrimp_stocking_density = '"+preplant.getShrimpStockingDensityValue()+"';";
        SQLiteDatabase db = openDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst())
        {
            int index = c.getColumnIndex("probability_of_shrimp_faliure");
            probability_of_shrimp_faliure = c.getFloat(index);
        }
        return  probability_of_shrimp_faliure;
    }

    public float getPlantRiceFaliureRate(Plant plant) {
        String query="select probability_of_rice_faliure from plant WHERE " +
                "soil_salinity = '" +plant.getSoilSalinityValue()+
                "' AND soil_ph = '" + plant.getSoilPHValue() +
                "' AND watertemperature = '" + plant.getWaterTemperatureValue()+
                "' AND soil_nutrient = '" + plant.getSoilNutrientValue() +
                "' AND water_salinity = '" + plant.getWaterSalinityValue()+
                "' AND salt_tolerant_rice = '" + plant.getSaltTolerantRiceValue() +
                "' AND water_color_management = '" + plant.getWaterColorManagementValue() +
                "' AND shrimp_stocking_density = '"+ plant.getShrimpStockingDensityValue() +"';";
        SQLiteDatabase db = openDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst())
        {
            int index = c.getColumnIndex("probability_of_rice_faliure");
            probability_of_rice_faliure = c.getFloat(index);
        }
        return  probability_of_rice_faliure;
    }

    public float getPlantShrimpFaliureRate(Plant plant) {
        String query="select probability_of_shrimp_faliure from plant WHERE " +
                "soil_salinity = '" +plant.getSoilSalinityValue()+
                "' AND soil_ph = '" + plant.getSoilPHValue() +
                "' AND watertemperature = '" + plant.getWaterTemperatureValue()+
                "' AND soil_nutrient = '" + plant.getSoilNutrientValue() +
                "' AND water_salinity = '" + plant.getWaterSalinityValue()+
                "' AND salt_tolerant_rice = '" + plant.getSaltTolerantRiceValue() +
                "' AND water_color_management = '" + plant.getWaterColorManagementValue() +
                "' AND shrimp_stocking_density = '"+ plant.getShrimpStockingDensityValue() +"';";
        SQLiteDatabase db = openDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst())
        {
            int index = c.getColumnIndex("probability_of_shrimp_faliure");
            probability_of_shrimp_faliure = c.getFloat(index);
        }
        return  probability_of_shrimp_faliure;
    }

    public float getPostPlantRiceFaliureRate(PostPlant postPlant) {
        String query="select probability_of_rice_faliure from postplant WHERE " +
                "soil_salinity = '" +postPlant.getSoilSalinityValue()+
                "' AND soil_ph = '" + postPlant.getSoilPhValue() +
                "' AND watertemperature = '" + postPlant.getWaterTemperatureValue()+
                "' AND soil_nutrient = '" + postPlant.getSoilNutrientValue() +
                "' AND water_salinity = '" + postPlant.getWaterSalinityValue()+
                "' AND salt_tolerant_rice = '" + postPlant.getSaltTolerantRiceValue() +
                "' AND water_color_management = '" + postPlant.getWateColorManagementValue() +
                "' AND rice_color = '" + postPlant.getRiceColorValue() +
                "' AND shrimp_stocking_density = '"+ postPlant.getShrimpStoclingDensityValue() +"';";
        SQLiteDatabase db = openDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst())
        {
            int index = c.getColumnIndex("probability_of_rice_faliure");
            probability_of_rice_faliure = c.getFloat(index);
        }
        return  probability_of_rice_faliure;
    }

    public float getPostPlantShrimpFaliureRate(PostPlant postPlant) {
        String query="select probability_of_shrimp_faliure from postplant WHERE " +
                "soil_salinity = '" +postPlant.getSoilSalinityValue()+
                "' AND soil_ph = '" + postPlant.getSoilPhValue() +
                "' AND watertemperature = '" + postPlant.getWaterTemperatureValue()+
                "' AND soil_nutrient = '" + postPlant.getSoilNutrientValue() +
                "' AND water_salinity = '" + postPlant.getWaterSalinityValue()+
                "' AND salt_tolerant_rice = '" + postPlant.getSaltTolerantRiceValue() +
                "' AND water_color_management = '" + postPlant.getWateColorManagementValue() +
                "' AND rice_color = '" + postPlant.getRiceColorValue() +
                "' AND shrimp_stocking_density = '"+ postPlant.getShrimpStoclingDensityValue() +"';";
        SQLiteDatabase db = openDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst())
        {
            int index = c.getColumnIndex("probability_of_shrimp_faliure");
            probability_of_shrimp_faliure = c.getFloat(index);
        }
        return  probability_of_shrimp_faliure;
    }
}
