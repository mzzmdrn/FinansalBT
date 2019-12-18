package com.muazduran.cepteoneri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

//import com.google.android.gms.ads.AdView;

public class ActivityMain extends AppCompatActivity implements Serializable {

    //private AdView mAdView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentViewPagerAdapter adapter;

    public ArrayList<PhoneInformation> AllModels = new ArrayList<>();
    public ArrayList<PhoneInformation> brandFiltered = new ArrayList<>();
    public ArrayList<PhoneInformation> specFiltered = new ArrayList<>();

    // Use another database
   /* public void createModelArrayList(){
        PhoneInformation ZENMAXPRO = new PhoneInformation("Asus" ,"Zenfone Max Pro", 4, 113900, 75, "1080x2160",5.99,"64+",5000,"Distribütör");
        PhoneInformation REDMI7    = new PhoneInformation("Xiaomi" ,"Redmi 7", 3, 103800, 80, "A12 Bionic");
        PhoneInformation A10       = new PhoneInformation("Samsung" ,"A10", 2, 89900, 80, "A12 Bionic");
        PhoneInformation K40       = new PhoneInformation("LG" ,"K40", 2, 71900, 70, "A12 Bionic");
        PhoneInformation PSMART19  = new PhoneInformation("Huawei" ,"P Smart 2019", 3, 133200, 80, "A12 Bionic");
        PhoneInformation MOTOZPLAY = new PhoneInformation("Lenovo" ,"Moto Z Play", 3, 75900, 70, "A12 Bionic");
        PhoneInformation VIA1PLUS  = new PhoneInformation("Casper" ,"Via A1 Plus", 4, 60500, 70, "A12 Bionic");
        PhoneInformation VZ20      = new PhoneInformation("Vestel" ,"Venüs Z20", 4, 89200, 65, "A12 Bionic");
        PhoneInformation XA1U      = new PhoneInformation("Sony" ,"Xperia XA1 Ultra", 4, 76000, 75, "A12 Bionic");
        PhoneInformation N51P      = new PhoneInformation("Nokia" ,"5.1 Plus", 3, 119400, 70, "A12 Bionic");
        PhoneInformation GM8       = new PhoneInformation("General Mobile" ,"GM8", 4, 60100, 65, "A12 Bionic");
        PhoneInformation AX7       = new PhoneInformation("Oppo" ,"AX7", 3, 75200, 80, "A12 Bionic");

        AllModels.add(ZENMAXPRO);AllModels.add(REDMI7);
        AllModels.add(A10);AllModels.add(K40);
        AllModels.add(PSMART19);AllModels.add(MOTOZPLAY);
        AllModels.add(VIA1PLUS);AllModels.add(VZ20);
        AllModels.add(XA1U);AllModels.add(N51P);
        AllModels.add(GM8);AllModels.add(AX7);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        /*brandName;modelName;RAM;antutu;camera;resolution;size;storage;battery;guaranty;*/

       /* db.collection("cities")
                .whereEqualTo("capital", true)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });*/
/*
        //Google Ads
        MobileAds.initialize(this,"ca-app-pub-7744054273647441~3103645066");
        mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("BEFD8BA88A0599EC040C9CCA7111EBC7").build();
        mAdView.loadAd(adRequest);
*/

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new FragmentViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new FragmentBrands() ,"MARKA");
        adapter.addFragment(new FragmentSpecs(),"ÖZELLİK");
        adapter.addFragment(new FragmentExtras(),"DİĞER");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_brands);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_specs);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_extras);

        // Creating all phone models from PhoneInformation Class
        //createModelArrayList();


    }


    // Checkboxes at Brand Page
    public void onCheckBoxChecked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        Iterator<PhoneInformation> itr = brandFiltered.iterator();
        switch (view.getId()){
            case R.id.brand_asus:
                if (checked) {
                    for (PhoneInformation i : AllModels) {
                        if (i.getBrandName().equals("Asus"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Asus"))
                            itr.remove();
                    }
                }
                break;
            case R.id.brand_casper:
                if(checked) {
                    for (PhoneInformation i : AllModels) {
                        if (i.getBrandName().equals("Casper"))
                            brandFiltered.add(i);
                    }
                }
                else {
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Casper"))
                            itr.remove();
                    }
                }
                break;
            case R.id.brand_gm:
                if(checked){
                    for (PhoneInformation i : AllModels) {
                        if (i.getBrandName().equals("General Mobile"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("General Mobile"))
                            itr.remove();
                    }
                }
                break;
            case R.id.brand_huawei:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("Huawei"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Huawei")){
                            itr.remove();
                        }
                    }
                }
                break;
            case R.id.brand_lenovo:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("Lenovo"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Lenovo")){
                            itr.remove();
                        }
                    }
                }
                break;
            case R.id.brand_lg:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("LG"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("LG")){
                            itr.remove();
                        }
                    }
                }
                break;
            case R.id.brand_nokia:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("Nokia"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Nokia")){
                            itr.remove();
                        }
                    }
                }
                break;
            case R.id.brand_oppo:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("Oppo"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Oppo")){
                            itr.remove();
                        }
                    }
                }
                break;
            case R.id.brand_samsung:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("Samsung"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Samsung")){
                            itr.remove();
                        }
                    }
                }
                break;
            case R.id.brand_sony:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("Sony"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Sony")){
                            itr.remove();
                        }
                    }
                }
                break;
            case R.id.brand_vestel:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("Vestel"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Vestel")){
                            itr.remove();
                        }
                    }
                }
                break;
            case R.id.brand_xiaomi:
                if(checked){
                    for (PhoneInformation i : AllModels){
                        if (i.getBrandName().equals("Xiaomi"))
                            brandFiltered.add(i);
                    }
                }
                else{
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(brandFiltered.size()!= 0 && i.getBrandName().equals("Xiaomi")){
                            itr.remove();
                        }
                    }
                }
                break;
        }
    }

    // Radiobuttons at Specs Page
    public void onRadioButtonTicked(View view){
        boolean ticked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.level1_guc:
                if(ticked){
                    for (PhoneInformation i : brandFiltered){
                        if (i.getRAM()<=3)
                            specFiltered.add(i);
                    }

                    Iterator<PhoneInformation> itr = specFiltered.iterator();
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(specFiltered.size()!= 0 && i.getRAM()>3){
                            itr.remove();
                        }
                    }

                    System.out.println("LVL1 - SecList: " + specFiltered);
                    Toast.makeText(this,"Level 1 Güç",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level2_guc:
                if(ticked){
                    for (PhoneInformation i : brandFiltered){
                        if (4 <= i.getRAM() && 8>=i.getRAM())
                            specFiltered.add(i);
                    }

                    Iterator<PhoneInformation> itr = specFiltered.iterator();
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(specFiltered.size()!= 0 && (i.getRAM()<4 || i.getRAM()>8) ){
                            itr.remove();
                        }
                    }
                    System.out.println("LVL2 - SecList: " + specFiltered);
                    Toast.makeText(this,"Level 2 Güç",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level3_guc:
                if(ticked){
                    Toast.makeText(this,"Level 3 Güç",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level1_kamera:
                if(ticked){
                    Toast.makeText(this,"Level 1 Kamera",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level2_kamera:
                if(ticked){
                    Toast.makeText(this,"Level 2 Kamera",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level3_kamera:
                if(ticked){
                    Toast.makeText(this,"Level 3 Kamera",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level1_pil:
                if(ticked){
                    Toast.makeText(this,"Level 1 Pil",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level1_depo:
                if(ticked){
                    for (PhoneInformation i : brandFiltered){
                        if (i.getStorage() <= 32)
                            specFiltered.add(i);
                    }

                    Iterator<PhoneInformation> itr = specFiltered.iterator();
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(specFiltered.size()!= 0 && i.getStorage()>32){
                            itr.remove();
                        }
                    }
                    Toast.makeText(this,"Level 1 Depo",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level2_depo:
                if(ticked){
                    for (PhoneInformation i : brandFiltered){
                        if (i.getStorage() >32 || i.getStorage()<128)
                            specFiltered.add(i);
                    }

                    Iterator<PhoneInformation> itr = specFiltered.iterator();
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(specFiltered.size()!= 0 && i.getStorage()<32 || i.getStorage()>128){
                            itr.remove();
                        }
                    }
                    Toast.makeText(this,"Level 2 Depo",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.level3_depo:
                if(ticked){
                    for (PhoneInformation i : brandFiltered){
                        if (i.getStorage() >=128)
                            specFiltered.add(i);
                    }

                    Iterator<PhoneInformation> itr = specFiltered.iterator();
                    while(itr.hasNext()){
                        PhoneInformation i = itr.next();
                        if(specFiltered.size()!= 0 && i.getStorage()<128){
                            itr.remove();
                        }
                    }
                    Toast.makeText(this,"Level 3 Depo",Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    // Result (radio)button at Extras Page
    public void rbResult(View view) {
        boolean ticked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.results_button:
                if (ticked) {
                    Intent intent = new Intent(this, ActivityResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("brandFilteredList", brandFiltered);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            break;
        }
    }
}

