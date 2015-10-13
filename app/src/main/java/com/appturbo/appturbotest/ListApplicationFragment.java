package com.appturbo.appturbotest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.appturbo.appturbotest.model.Application;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListApplicationFragment extends ListFragment {
	private final List<Application> list = new ArrayList<>();
    // JSON Node names

    ArrayList contactList ;
    private static final String TAG_NAME = "name";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_LOGO = "logo";
    private static final String TAG_SCREENSHOT = "screenshot";
    private static final String TAG_ID = "id";


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

        // URL to get contacts JSON
        final String url = "http://mobile-team.appturbo.net/exerciceAndroid.json";

        class getApplication extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... params) {
               ArrayList contactList = new ArrayList<HashMap<String, String>>();
                // Creating service handler class instance
                ServiceHandler sh = new ServiceHandler();

                // Making a request to url and getting response
                String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

                if (jsonStr != null) {
                    try {
                        JSONObject jsonObj = new JSONObject(jsonStr);


                        // looping through All Contacts
                        for (int i = 0; i < jsonObj.length(); i++) {
                            JSONObject c = jsonObj.getJSONObject(String.valueOf(i)) ;

                            String id = c.getString(TAG_ID);
                            String name = c.getString(TAG_NAME);
                            String logo = c.getString(TAG_LOGO);
                            String description = c.getString(TAG_DESCRIPTION);
                            String screenshot = c.getString(TAG_SCREENSHOT);


                            // tmp hashmap for single contact
                            HashMap<String, String> contact = new HashMap<String, String>();

                            // adding each child node to HashMap key => value
                            contact.put(TAG_ID, id);
                            contact.put(TAG_NAME, name);
                            contact.put(TAG_DESCRIPTION, description);
                            contact.put(TAG_LOGO, logo);
                            contact.put(TAG_SCREENSHOT , screenshot)  ;

                            // adding contact to contact list
                            contactList.add(contact);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("ServiceHandler", "Couldn't get any data from the url");
                }

                        return null;
            }


        }


	}

    /*
     * TODO: You need to develop the ListAdapter in order to show each item in the list. This adapter need to load the @layout/list_application_item and load all of the data in it from the Application model or the Network.
     */

}
