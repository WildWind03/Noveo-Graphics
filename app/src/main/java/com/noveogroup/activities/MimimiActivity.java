package com.noveogroup.activities;

import android.app.ListActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.noveogroup.adapter.MimimiAdapter;
import com.noveogroup.bitmap.Pair;
import com.noveogroup.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MimimiActivity extends ListActivity {

    private MimimiAdapter adapter;
    private List<Bitmap> bitmaps = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            for (String path: getAssets().list("")) {
                if (path.endsWith(".jpg")) {
                    Pair sizes = Util.getAppropriateSizes(this);
                    Bitmap bitmap = Util.decodeSampledBitmapFromResource(getAssets().open(path), sizes.getWidth(), sizes.getHeight());
                    bitmaps.add(bitmap);
                }
            }
        } catch (Exception e) {
            Log.e("Mimimi", "Something strange: ", e);
        } catch (OutOfMemoryError err) {
            Log.e("Mimimi", "Houston, we have an out of…");
        }

        adapter = new MimimiAdapter(this, bitmaps);

        setListAdapter(adapter);
    }
}
