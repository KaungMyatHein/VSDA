package com.pthlab.kaungmyat.vsda.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pthlab.kaungmyat.vsda.Activity.Result;
import com.pthlab.kaungmyat.vsda.Entity.Plant;
import com.pthlab.kaungmyat.vsda.R;


public class PlantFragment extends Fragment implements View.OnClickListener {

    //GLOBAL VARIABLE DECLARATION
    private View view;
    private RadioGroup plantSoilSalinityGroup;
    private RadioGroup plantSoilPHGroup;
    private RadioGroup plantSoilNutrientGroup;
    private RadioGroup plantWaterTemperatureGroup;
    private RadioGroup plantWaterSalinityGroup;
    private RadioGroup plantSaltTolerantRiceGroup;
    private RadioGroup plantShrimpStockingDensityGroup;
    private RadioGroup plantWaterColorManagementGroup;
    private Button submit;
    private Plant plant;

    public PlantFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_plant, null);
        registerForViews();
        submit.setOnClickListener(this);
        return view;

    }

    private void registerForViews() {
        plantSoilSalinityGroup = view.findViewById(R.id.plant_soil_salinity_group);
        plantSoilPHGroup = view.findViewById(R.id.plant_soil_ph_group);
        plantSoilNutrientGroup = view.findViewById(R.id.plant_soil_nutrient_group);
        plantWaterTemperatureGroup = view.findViewById(R.id.plant_water_temperature_group);
        plantWaterSalinityGroup = view.findViewById(R.id.plant_water_salinity_group);
        plantSaltTolerantRiceGroup = view.findViewById(R.id.plant_salt_tolerant_group);
        plantShrimpStockingDensityGroup = view.findViewById(R.id.plant_shrimp_stocking_density_group);
        plantWaterColorManagementGroup = view.findViewById(R.id.plant_water_color_management_group);
        submit = view.findViewById(R.id.plant_submit);
    }

    @Override
    public void onClick(View v) {
        if(plantSoilSalinityGroup.getCheckedRadioButtonId() == -1 ||
           plantSoilPHGroup.getCheckedRadioButtonId() == -1 ||
           plantSoilNutrientGroup.getCheckedRadioButtonId() == -1 ||
           plantWaterTemperatureGroup.getCheckedRadioButtonId() == -1 ||
           plantWaterSalinityGroup.getCheckedRadioButtonId() == -1 ||
           plantSaltTolerantRiceGroup.getCheckedRadioButtonId() == -1 ||
           plantShrimpStockingDensityGroup.getCheckedRadioButtonId() == -1 ||
           plantWaterColorManagementGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(view.getContext(),"Please selected one the radio buttons for each type",Toast.LENGTH_SHORT).show();
        }
        else
        {
            plant = new Plant();
            plant.setSoilSalinityValue(getSoilSalinityValue());
            plant.setSoilPHValue(getSoilPHValue());
            plant.setSoilNutrientValue(getSoilNutrientValue());
            plant.setWaterTemperatureValue(getWaterTemperatureValue());
            plant.setWaterSalinityValue(getWaterSalinityValue());
            plant.setSaltTolerantRiceValue(getSaltTolerantRiceValue());
            plant.setShrimpStockingDensityValue(getShrimpStockingDensityValue());
            plant.setWaterColorManagementValue(getWaterColorManagementValue());
            Intent i = new Intent(getActivity(),Result.class);
            i.putExtra("type","2");
            i.putExtra("value", plant);
            startActivity(i);
        }
    }

    private int getWaterColorManagementValue() {
        switch (plantWaterColorManagementGroup.getCheckedRadioButtonId())
        {
            case (R.id.plant_water_color_management_zeolite) : return 1;
            case (R.id.plant_water_color_management_DAP_URE_Kali) : return 2;
        }
        return 0;
    }

    private int getShrimpStockingDensityValue() {
        switch (plantShrimpStockingDensityGroup.getCheckedRadioButtonId())
        {
            case (R.id.plant_shrimp_stocking_density_low) : return 1;
            case (R.id.plant_shrimp_stocking_density_medium) : return 2;
            case (R.id.plant_shrimp_stocking_density_high) : return 3;
        }
        return 0;
    }

    private int getSaltTolerantRiceValue() {
        switch (plantSaltTolerantRiceGroup.getCheckedRadioButtonId())
        {
            case (R.id.plant_salt_tolerant_yes) : return 1;
            case (R.id.plant_salt_tolerant_no) : return 2;
        }
        return 0;
    }

    private int getWaterSalinityValue() {
        switch (plantWaterSalinityGroup.getCheckedRadioButtonId())
        {
            case (R.id.plant_water_salinity_high) : return 1;
            case (R.id.plant_water_salinity_moderate) : return 2;
            case (R.id.plant_water_salinity_low) : return 3;
        }
        return 0;
    }

    private int getWaterTemperatureValue() {
        switch (plantWaterTemperatureGroup.getCheckedRadioButtonId())
        {
            case (R.id.plant_water_temperature_low) : return 1;
            case (R.id.plant_water_temperature_high) : return 2;
        }
        return 0;
    }

    private int getSoilNutrientValue() {
        switch (plantSoilNutrientGroup.getCheckedRadioButtonId())
        {
            case (R.id.plant_soil_nutrient_low) : return 1;
            case (R.id.plant_soil_nutrient_high) : return 2;
        }
        return 0;
    }

    private int getSoilPHValue() {
        switch (plantSoilPHGroup.getCheckedRadioButtonId())
        {
            case (R.id.plant_soil_ph_acid) : return 1;
            case (R.id.plant_soil_ph_balanced) : return 2;
            case (R.id.plant_soil_ph_alkaline) : return 3;
        }
        return 0;
    }

    private int getSoilSalinityValue() {
        switch (plantSoilSalinityGroup.getCheckedRadioButtonId())
        {
            case (R.id.plant_soil_salinity_high) : return  1;
            case (R.id.plant_soil_salinity_moderate) : return 2;
            case (R.id.plant_soil_salinity_low) : return 3;
        }
        return 0;
    }
}
