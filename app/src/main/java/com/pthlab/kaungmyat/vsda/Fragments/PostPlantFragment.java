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

import com.pthlab.kaungmyat.vsda.Activity.Result;
import com.pthlab.kaungmyat.vsda.Entity.PostPlant;
import com.pthlab.kaungmyat.vsda.R;

public class PostPlantFragment extends Fragment implements View.OnClickListener{

    //GLOBAL VARIABLE DECLARATION
    private RadioGroup postPlantSoilSalinityGroup;
    private RadioGroup postPlantSoilPhGroup;
    private RadioGroup postPlantSoilNutrientGroup;
    private RadioGroup postPlantWaterTemperatureGroup;
    private RadioGroup postPlantWaterSalinityGroup;
    private RadioGroup postPlantSaltTolerantRiceGroup;
    private RadioGroup postPlantShrimpStockingDensityGroup;
    private RadioGroup postPlantWaterColorManagementGroup;
    private Button postPlantSubmitButton;
    private View view;

    public PostPlantFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_post_plant, container, false);
        registerForViews();
        postPlantSubmitButton.setOnClickListener(this);
        return view;
    }

    private void registerForViews() {
        postPlantSoilSalinityGroup = view.findViewById(R.id.post_pant_soil_salinity_group);
        postPlantSoilPhGroup = view.findViewById(R.id.post_pant_soil_pH_group);
        postPlantSoilNutrientGroup = view.findViewById(R.id.post_plant_soil_nutrient_group);
        postPlantWaterTemperatureGroup = view.findViewById(R.id.post_plant_water_temperature_group);
        postPlantWaterSalinityGroup = view.findViewById(R.id.plant_water_salinity_group);
        postPlantSaltTolerantRiceGroup = view.findViewById(R.id.post_plant_salt_tolerant_group);
        postPlantShrimpStockingDensityGroup = view.findViewById(R.id.post_plant_shrimp_stocking_density_group);
        postPlantWaterColorManagementGroup = view.findViewById(R.id.post_plant_water_color_management_group);
        postPlantSubmitButton = view.findViewById(R.id.post_plant_submit);
    }


    @Override
    public void onClick(View v) {
        if(postPlantSoilSalinityGroup.getCheckedRadioButtonId() == -1 ||
            postPlantSoilPhGroup.getCheckedRadioButtonId() == -1 ||
            postPlantSoilNutrientGroup.getCheckedRadioButtonId() == -1 ||
            postPlantWaterTemperatureGroup.getCheckedRadioButtonId() == -1 ||
            postPlantWaterSalinityGroup.getCheckedRadioButtonId() == -1 ||
            postPlantSaltTolerantRiceGroup.getCheckedRadioButtonId() == -1 ||
            postPlantShrimpStockingDensityGroup.getCheckedRadioButtonId() == -1 ||
            postPlantWaterColorManagementGroup.getCheckedRadioButtonId() == -1)
        {
            PostPlant postPlant = new PostPlant();
            postPlant.setSoilSalinityValue(getSoilSalinityValue());
            postPlant.setSoilPhValue(getSoilPhValue());
            postPlant.setSoilNutrientValue(getSoilNutrientValue());
            postPlant.setWaterTemperatureValue(getWaterTemperatureValue());
            postPlant.setWaterSalinityValue(getWaterSalinityValue());
            postPlant.setSaltTolerantRiceValue(getSaltTolerantRiceValue());
            postPlant.setShrimpStoclingDensityValue(getShrimpStockingDensityValue());
            postPlant.setWateColorManagementValue(getWaterColorManagementValue());
            Intent i = new Intent(getActivity(),Result.class);
            i.putExtra("type","3");
            i.putExtra("value", postPlant);
            startActivity(i);
        }
    }

    private int getWaterColorManagementValue() {
        switch (postPlantWaterColorManagementGroup.getCheckedRadioButtonId())
        {
            case R.id.post_plant_water_color_management_zeolite : return 1;
            case R.id.post_plant_water_color_management_DAP_URE_Kali : return 2;
        }
        return 0;
    }

    private int getShrimpStockingDensityValue() {
        switch (postPlantShrimpStockingDensityGroup.getCheckedRadioButtonId())
        {
            case R.id.post_plant_shrimp_stocking_density_low : return 1;
            case R.id.post_plant_shrimp_stocking_density_medium : return 2;
            case R.id.post_plant_shrimp_stocking_density_high : return 3;
        }
        return 0;
    }

    private int getSaltTolerantRiceValue() {
        switch (postPlantSaltTolerantRiceGroup.getCheckedRadioButtonId())
        {
            case R.id.post_plant_salt_tolerant_yes : return 1;
            case R.id.post_plant_salt_tolerant_no : return 2;
        }
        return 0;
    }

    private int getWaterSalinityValue() {
        switch (postPlantWaterSalinityGroup.getCheckedRadioButtonId())
        {
            case R.id.post_plant_water_salinity_high : return 1;
            case R.id.post_plant_water_salinity_moderate : return 2;
            case R.id.post_plant_water_salinity_low : return 3;
        }
        return 0;
    }

    private int getWaterTemperatureValue() {
        switch (postPlantWaterTemperatureGroup.getCheckedRadioButtonId())
        {
            case R.id.post_plant_water_temperature_low : return 1;
            case R.id.post_plant_water_temperature_high : return 2;
        }
        return 0;
    }

    private int getSoilNutrientValue() {
        switch (postPlantSoilNutrientGroup.getCheckedRadioButtonId())
        {
            case R.id.post_plant_soil_nutrient_low : return 1;
            case R.id.post_plant_soil_nutrient_high : return 2;
        }
        return 0;
    }

    private int getSoilPhValue() {
        switch (postPlantSoilPhGroup.getCheckedRadioButtonId())
        {
            case  R.id.post_pant_soil_pH_acid : return 1;
            case  R.id.post_pant_soil_pH_balanced : return 2;
            case  R.id.post_pant_soil_pH_alkaline : return 3;
        }
        return 0;
    }

    private int getSoilSalinityValue() {
        switch (postPlantSoilSalinityGroup.getCheckedRadioButtonId())
        {
            case R.id.post_pant_soil_salinity_high : return 1;
            case R.id.post_pant_soil_salinity_moderate : return 2;
            case R.id.post_pant_soil_salinity_low : return 3;
        }
        return 0;
    }
}
