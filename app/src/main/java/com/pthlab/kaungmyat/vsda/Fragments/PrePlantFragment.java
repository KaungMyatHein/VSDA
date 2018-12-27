package com.pthlab.kaungmyat.vsda.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pthlab.kaungmyat.vsda.Activity.Result;
import com.pthlab.kaungmyat.vsda.Entity.Preplant;
import com.pthlab.kaungmyat.vsda.R;

public class PrePlantFragment extends Fragment implements View.OnClickListener {

    //GLOBAL VARIABLE DECLARATION
    private RadioGroup prePlantRainGroup;
    private RadioGroup prePlantWetSeasonGroup;
    private RadioGroup prePlantSoilNutrientGroup;
    private RadioGroup prePlantSoilTillingGroup;
    private RadioGroup prePlantSaltTolerantRiceGroup;
    private RadioGroup prePlantShrimpStockingDensityGroup;
    private RadioGroup prePlantWaterColorManagementGroup;
    private RadioGroup prePlantLimeSoilGroup;
    private Button prePlantSubmitBtn;
    private View view;
    private Preplant preplant;
    public PrePlantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pre_plant, null);
        registerForViews();
        prePlantSubmitBtn.setOnClickListener(this);
        return view;
    }




    private void registerForViews() {
        prePlantRainGroup = view.findViewById(R.id.pre_plant_rain_group);
        prePlantWetSeasonGroup = view.findViewById(R.id.pre_plant_wet_season_group);
        prePlantSoilNutrientGroup = view.findViewById(R.id.pre_plant_soil_nutrient_group);
        prePlantSoilTillingGroup = view.findViewById(R.id.pre_plant_soil_tilling_group);
        prePlantSaltTolerantRiceGroup = view.findViewById(R.id.pre_plant_salt_tolerant_group);
        prePlantShrimpStockingDensityGroup = view.findViewById(R.id.pre_plant_shrimp_stocking_density_group);
        prePlantWaterColorManagementGroup = view.findViewById( R.id.pre_plant_water_color_management_group);
        prePlantLimeSoilGroup = view.findViewById(R.id.pre_plant_lime_soil_group);
        prePlantSubmitBtn = view.findViewById(R.id.pre_plant_submit);
    }

    @Override
    public void onClick(View v) {
        if(prePlantRainGroup.getCheckedRadioButtonId() == -1 ||
           prePlantWetSeasonGroup.getCheckedRadioButtonId() == -1 ||
           prePlantSoilNutrientGroup.getCheckedRadioButtonId() == -1 ||
           prePlantSoilTillingGroup.getCheckedRadioButtonId() == -1 ||
           prePlantSaltTolerantRiceGroup.getCheckedRadioButtonId() == -1 ||
           prePlantShrimpStockingDensityGroup.getCheckedRadioButtonId() == -1 ||
           prePlantWaterColorManagementGroup.getCheckedRadioButtonId() == -1 ||
           prePlantLimeSoilGroup.getCheckedRadioButtonId()==-1)
        {
            Toast.makeText(view.getContext(),"Please selected one the radio buttons for each type",Toast.LENGTH_SHORT).show();
        }
        else
        {
            preplant = new Preplant();
            preplant.setRainValue(getRainGroupValue());
            preplant.setWetSeasonValue(getWetSeasonValue());
            preplant.setSoilNutrientValue(getSoilNutrientValue());
            preplant.setLimesoilValue(getLimeSoilValue());
            preplant.setSoilTillingValue(getSoilTillingValue());
            preplant.setSaltTolerantRiceValue(getSaltTolerantRiceValue());
            preplant.setShrimpStockingDensityValue(getShrimpStockingDensityValue());
            preplant.setWaterColorValue(getWaterColorManagementValue());
            Intent i = new Intent(getActivity(),Result.class);
            i.putExtra("type","1");
            i.putExtra("value", preplant);
            startActivity(i);
        }
    }

    private int getWaterColorManagementValue() {
        switch (prePlantWaterColorManagementGroup.getCheckedRadioButtonId())
        {
            case R.id.pre_plant_water_color_management_zeolite : return 1;
            case R.id.pre_plant_water_color_management_DAP_URE_Kali : return 2;
        }
        return 0;
    }

    private int getSaltTolerantRiceValue() {
        switch (prePlantSaltTolerantRiceGroup.getCheckedRadioButtonId())
        {
            case R.id.pre_plant_salt_tolerant_yes : return 0;
            case R.id.pre_plant_salt_tolerant_no : return 1;
        }
        return 0;
    }

    private int getShrimpStockingDensityValue() {
        switch (prePlantShrimpStockingDensityGroup.getCheckedRadioButtonId())
        {
            case R.id.pre_plant_shrimp_stocking_density_low : return 1;
            case R.id.pre_plant_shrimp_stocking_density_medium : return 2;
            case R.id.pre_plant_shrimp_stocking_density_high : return 3;
        }
        return 0;
    }

    private int getSoilTillingValue() {
        switch (prePlantSoilTillingGroup.getCheckedRadioButtonId())
        {
            case R.id.pre_plant_soil_tilling_yes : return 1;
            case R.id.pre_plant_soil_tilling_no : return 2;
        }
        return 0;
    }

    private int getLimeSoilValue() {
        switch (prePlantLimeSoilGroup.getCheckedRadioButtonId())
        {
            case R.id.pre_plant_lime_soil_none : return 1;
            case R.id.pre_plant_lime_soil_CaO :return  2;
            case R.id.pre_plant_lime_soil_CaCO3 : return 3;
            case R.id.pre_plant_lime_soil_other : return 4;
        }
        return 0;
    }

    private int getSoilNutrientValue() {
        switch (prePlantSoilNutrientGroup.getCheckedRadioButtonId())
        {
            case R.id.pre_plant_soil_nutrient_low :return 1;
            case R.id.pre_plant_soil_nutrient_high : return 2;
        }
        return 0;
    }

    private int getWetSeasonValue() {
        switch (prePlantWetSeasonGroup.getCheckedRadioButtonId())
        {
            case R.id.pre_plant_wet_Season_Early : return 1;
            case R.id.pre_plant_wet_Season_Average : return 2;
            case R.id.pre_plant_wet_Season_Late : return 3;
        }
        return 0;
    }

    private int getRainGroupValue() {
        switch (prePlantRainGroup.getCheckedRadioButtonId())
        {
            case R.id.pre_plant_rain_high : return 1;
            case R.id.pre_plant_rain_average : return 2;
            case R.id.pre_plant_rain_low : return 3;
        }
        return 0;
    }


}
