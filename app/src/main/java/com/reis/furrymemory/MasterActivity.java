package com.reis.furrymemory;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.icons.MaterialDrawerFont;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

public class MasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_activity);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PrimaryDrawerItem mainNav = new PrimaryDrawerItem().withName(R.string.drawer_main_nav).withSelectable(false);
        PrimaryDrawerItem subNav  = new PrimaryDrawerItem().withName(R.string.drawer_sub_nav).withSelectable(false);
        DividerDrawerItem divider = new DividerDrawerItem().withSelectable(false);

        IconicsDrawable overviewIcon    = new IconicsDrawable(this).icon(FontAwesome.Icon.faw_folder_o);
        IconicsDrawable markersIcon     = new IconicsDrawable(this).icon(FontAwesome.Icon.faw_stethoscope);
        IconicsDrawable vitalsignsIcon  = new IconicsDrawable(this).icon(FontAwesome.Icon.faw_user_md);
        SecondaryDrawerItem overview    = new SecondaryDrawerItem().withIdentifier(1).withName(R.string.drawer_overview).withIcon(overviewIcon);
        SecondaryDrawerItem markers     = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_markers).withIcon(markersIcon);
        SecondaryDrawerItem vitalsigns  = new SecondaryDrawerItem().withIdentifier(3).withName(R.string.drawer_vitalsigns).withIcon(vitalsignsIcon);

        IconicsDrawable profileIcon = new IconicsDrawable(this).icon(FontAwesome.Icon.faw_user);
        IconicsDrawable logoutIcon  = new IconicsDrawable(this).icon(FontAwesome.Icon.faw_power_off);
        SecondaryDrawerItem profile = new SecondaryDrawerItem().withIdentifier(4).withName(R.string.drawer_profile).withIcon(profileIcon);
        SecondaryDrawerItem logout  = new SecondaryDrawerItem().withIdentifier(5).withName(R.string.drawer_logout).withIcon(logoutIcon);


        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header) // 480 x 320 image
                .withSelectionListEnabledForSingleProfile(false)
                .build();

        DrawerBuilder builder = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withTranslucentStatusBar(false)
                .addDrawerItems(
                        mainNav, overview, markers, vitalsigns, divider,
                        subNav, profile, logout)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            /** set the toolbar button **/
                            String toolbarTitle = ((Nameable) drawerItem).getName().getText(getApplicationContext());
                            toolbar.setTitle(toolbarTitle);

                            Snackbar.make(view, "On View: " + toolbarTitle, Snackbar.LENGTH_LONG).show();
                        }

                        return false;
                    }
                })
                .withSelectedItem(-1);

        Drawer drawer = builder.build();
    }
}
