package com.example.skyhi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class TroubleshootScreen extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader, listDataHeaderVideos;
    HashMap<String, List<String>> listDataChild, listDataChildVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troubleshoot_screen);
        setTitle("Please select your problem");

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Extends the list
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Opens up youtube video
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                String movieURL = listDataChildVideos.get(
                                listDataHeaderVideos.get(groupPosition)).get(
                                childPosition);

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(movieURL)));
                return false;
            }
        });

    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataHeaderVideos =  new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        listDataChildVideos = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Movies");
        listDataHeader.add("Video Games");

        listDataHeaderVideos.add("Top 250 Videos");
        listDataHeaderVideos.add("Now Showing Videos");

        // Adding child data
        List<String> movies = new ArrayList<String>();
        List<String> moviesVideos = new ArrayList<String>();
        movies.add("The Shawshank Redemption");
        moviesVideos.add("https://www.youtube.com/watch?v=6hB3S9bIaco");
        movies.add("Pulp Fiction");
        moviesVideos.add("https://www.youtube.com/watch?v=s7EdQ4FqbhY");
        movies.add("The Good, the Bad and the Ugly");
        moviesVideos.add("https://www.youtube.com/watch?v=WCN5JJY_wiA");
        movies.add("The Dark Knight");
        moviesVideos.add("https://www.youtube.com/watch?v=EXeTwQWrcwY");


        List<String> videoGames = new ArrayList<String>();
        List<String> videoGamesVideos = new ArrayList<String>();
        videoGames.add("Uncharted 4");
        videoGamesVideos.add("https://www.youtube.com/watch?v=hh5HV4iic1Y");
        videoGames.add("Halo 5");
        videoGamesVideos.add("https://www.youtube.com/watch?v=Rh_NXwqFvHc");
        videoGames.add("The Witcher 3");
        videoGamesVideos.add("https://www.youtube.com/watch?v=c0i88t0Kacs");
        videoGames.add("Overwatch");
        videoGamesVideos.add("https://www.youtube.com/watch?v=FqnKB22pOC0");
        videoGames.add("To the Moon");
        videoGamesVideos.add("https://www.youtube.com/watch?v=sqkJuSV-23U");
        

        listDataChild.put(listDataHeader.get(0), movies); // Header, Child data
        listDataChild.put(listDataHeader.get(1), videoGames);
        
        listDataChildVideos.put(listDataHeaderVideos.get(0), moviesVideos); // Header, Child data
        listDataChildVideos.put(listDataHeaderVideos.get(1), videoGamesVideos);
    }
}
