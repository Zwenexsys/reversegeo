package com.zwenexsys.reversegeo.sample;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.zwenexsys.reverse.ReverseGeo;

public class MainActivity extends Activity {

  private ReverseGeo reverseGeo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    reverseGeo = new ReverseGeo("16.780833,96.149722");
    reverseGeo.setType(ReverseGeo.LOCALITY);

    new GetLocation().execute();
  }

  private class GetLocation extends AsyncTask<Void, Void, String> {

    @Override protected String doInBackground(Void... voids) {
      String st = reverseGeo.getSyncShortName();
      Log.d("short name", "sn : " + st);
      return st;
    }

    @Override protected void onPostExecute(String s) {
      super.onPostExecute(s);
      Log.d("short name", "sn : " + s);
    }
  }
}

