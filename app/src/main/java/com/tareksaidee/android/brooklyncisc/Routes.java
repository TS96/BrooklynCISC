package com.tareksaidee.android.brooklyncisc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tareksaidee.android.brooklyncisc.fragments.CgsMnElec;
import com.tareksaidee.android.brooklyncisc.fragments.CgsMnOther;
import com.tareksaidee.android.brooklyncisc.fragments.CgsMnReq;
import com.tareksaidee.android.brooklyncisc.fragments.CmAppElec;
import com.tareksaidee.android.brooklyncisc.fragments.CmAppOther;
import com.tareksaidee.android.brooklyncisc.fragments.CmAppReq;
import com.tareksaidee.android.brooklyncisc.fragments.CmThElec;
import com.tareksaidee.android.brooklyncisc.fragments.CmThOther;
import com.tareksaidee.android.brooklyncisc.fragments.CmThReq;
import com.tareksaidee.android.brooklyncisc.fragments.CsMElec;
import com.tareksaidee.android.brooklyncisc.fragments.CsMOther;
import com.tareksaidee.android.brooklyncisc.fragments.CsMReq;
import com.tareksaidee.android.brooklyncisc.fragments.CsMnElec;
import com.tareksaidee.android.brooklyncisc.fragments.CsMnOther;
import com.tareksaidee.android.brooklyncisc.fragments.CsMnReq;
import com.tareksaidee.android.brooklyncisc.fragments.IsMElec;
import com.tareksaidee.android.brooklyncisc.fragments.IsMOther;
import com.tareksaidee.android.brooklyncisc.fragments.IsMReq;
import com.tareksaidee.android.brooklyncisc.fragments.MmcMElec;
import com.tareksaidee.android.brooklyncisc.fragments.MmcMOther;
import com.tareksaidee.android.brooklyncisc.fragments.MmcMReq;
import com.tareksaidee.android.brooklyncisc.fragments.MmcMnElec;
import com.tareksaidee.android.brooklyncisc.fragments.MmcMnOther;
import com.tareksaidee.android.brooklyncisc.fragments.MmcMnReq;
import com.tareksaidee.android.brooklyncisc.fragments.PdcMnElec;
import com.tareksaidee.android.brooklyncisc.fragments.PdcMnOther;
import com.tareksaidee.android.brooklyncisc.fragments.PdcMnReq;

public class Routes extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;
    int sourceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sourceID = getIntent().getExtras().getInt("buttonID");
        setContentView(pickRoute());
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pickFragments();
        viewPager.setAdapter(adapter);
    }

    private void pickFragments() {
        switch (sourceID) {
            case R.id.major_cm_comp:
                adapter.addFragment(new CmAppReq(), "Requirements");
                adapter.addFragment(new CmAppElec(), "Electives");
                adapter.addFragment(new CmAppOther(), "Other");
                break;
            case R.id.major_cm_theor:
                adapter.addFragment(new CmThReq(), "Requirements");
                adapter.addFragment(new CmThElec(), "Electives");
                adapter.addFragment(new CmThOther(), "Other");
                break;
            case R.id.major_cs:
                adapter.addFragment(new CsMReq(), "Requirements");
                adapter.addFragment(new CsMElec(), "Electives");
                adapter.addFragment(new CsMOther(), "Other");
                break;
            case R.id.major_is:
                adapter.addFragment(new IsMReq(), "Requirements");
                adapter.addFragment(new IsMElec(), "Electives");
                adapter.addFragment(new IsMOther(), "Other");
                break;
            case R.id.major_mmc:
                adapter.addFragment(new MmcMReq(), "Requirements");
                adapter.addFragment(new MmcMElec(), "Electives");
                adapter.addFragment(new MmcMOther(), "Other");
                break;
            case R.id.minor_cgs:
                adapter.addFragment(new CgsMnReq(), "Requirements");
                adapter.addFragment(new CgsMnElec(), "Electives");
                adapter.addFragment(new CgsMnOther(), "Other");
                break;
            case R.id.minor_cs:
                adapter.addFragment(new CsMnReq(), "Minor #1");
                adapter.addFragment(new CsMnElec(), "Minor #2");
                adapter.addFragment(new CsMnOther(), "Minor #3");
                break;
            case R.id.minor_mmc:
                adapter.addFragment(new MmcMnReq(), "Requirements");
                adapter.addFragment(new MmcMnElec(), "Electives");
                adapter.addFragment(new MmcMnOther(), "Other");
                break;
            case R.id.minor_pdc:
                adapter.addFragment(new PdcMnReq(), "Requirements");
                adapter.addFragment(new PdcMnElec(), "Electives");
                adapter.addFragment(new PdcMnOther(), "Other");
                break;
        }
    }

    public void goToCourse(View view) {
        Intent intent = new Intent(this, Courses.class);
        intent.putExtra("code", ((Button) view).getText().toString());
        startActivityForResult(intent, 0);
    }

    private int pickRoute() {
        switch (sourceID) {
            case R.id.minor_cs:
                getSupportActionBar().setTitle(R.string.CSMajor);
                return R.layout.csminor;
            case R.id.major_mmc:
                getSupportActionBar().setTitle(R.string.MMCMajor);
                return R.layout.mmcmajor;
            case R.id.minor_mmc:
                getSupportActionBar().setTitle(R.string.MMCMinor);
                return R.layout.mmcminor;
            case R.id.minor_pdc:
                getSupportActionBar().setTitle(R.string.PDCMinor);
                return R.layout.pdcminor;
            case R.id.major_cm_comp:
                getSupportActionBar().setTitle(R.string.CMMajorApp);
                return R.layout.cmmajor;
            case R.id.major_cm_theor:
                getSupportActionBar().setTitle(R.string.CMMajorThe);
                return R.layout.cmmajor;
            case R.id.major_cs:
                getSupportActionBar().setTitle(R.string.CSMinor);
                return R.layout.csmajor;
            case R.id.minor_cgs:
                getSupportActionBar().setTitle(R.string.CGSMinor);
                return R.layout.cgsminor;
            case R.id.major_is:
                getSupportActionBar().setTitle(R.string.ISMajor);
                return R.layout.ismajor;
            default:
                return R.layout.csmajor;
        }
    }

    public void goToElectives(View view) {
        Intent intent = new Intent(this, Electives.class);
        startActivity(intent);
    }
}
