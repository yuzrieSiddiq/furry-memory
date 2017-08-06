package com.reis.furrymemory;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

public class MasterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_activity);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerBuilder builder = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        // .withIcon(R.drawable.menu_icon) // for an icon
                        new SecondaryDrawerItem().withName(R.string.drawer_title1).withIdentifier(1),
                        new SecondaryDrawerItem().withName(R.string.drawer_title2).withIdentifier(2),
                        new SecondaryDrawerItem().withName(R.string.drawer_title3).withIdentifier(3),
                        new SecondaryDrawerItem().withName(R.string.drawer_title4).withIdentifier(4),
                        new SecondaryDrawerItem().withName(R.string.drawer_title5).withIdentifier(5)
                )
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
                });

        Drawer drawer = builder.build();
    }
}
