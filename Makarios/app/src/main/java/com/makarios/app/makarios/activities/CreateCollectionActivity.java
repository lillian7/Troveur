package com.makarios.app.makarios.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.makarios.app.makarios.R;
import com.makarios.app.makarios.database.DatabaseManager;
import com.makarios.app.makarios.models.MyCollection;

public class CreateCollectionActivity extends Activity{
    private TextView collection_name;
    private ImageView collection_image;
    private Spinner collection_style;
    private Spinner collection_season;
    private Button save_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_collection);

        collection_name = (TextView) findViewById(R.id.insert_name);
        collection_image = (ImageView) findViewById(R.id.collection_image);
        collection_style = (Spinner) findViewById(R.id.select_style);
        collection_season = (Spinner) findViewById(R.id.select_season);
        save_button = (Button) findViewById(R.id.save_button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCollection collection = new MyCollection(collection_style.getSelectedItem().toString()
                        , collection_name.getText().toString(), collection_season.getSelectedItem().toString());
                DatabaseManager.getInstance().create(collection);
            }
        });
    }
}
