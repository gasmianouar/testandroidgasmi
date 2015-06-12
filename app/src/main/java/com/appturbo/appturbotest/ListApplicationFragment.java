package com.appturbo.appturbotest;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;

import com.appturbo.appturbotest.model.Application;

public class ListApplicationFragment extends ListFragment {
	private final List<Application> list = new ArrayList<>();

    /*
     * TODO: Load the view of the Fragment, this need to be a listview with the android standard list id.
     */

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		loadData();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra(DetailActivity.EXTRA_APPLICATION, list.get(position));
                startActivity(i);
            }
        });
	}

	private void loadData() {
		/*
		 * TODO: Load the json from the Web, parse it and build a list of Application model in order to notify the Adapter with new data.
		 */
	}

    /*
     * TODO: You need to develop the ListAdapter in order to show each item in the list. This adapter need to load the @layout/list_application_item and load all of the data in it from the Application model or the Network.
     */

}
