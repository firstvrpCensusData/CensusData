package com.firstvrp.censusdata;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firstvrp.censusdata.Entity.NoteEntity;
import com.firstvrp.censusdata.Http.TwitterRestClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.util.ArrayList;
import java.util.List;


public class HelpActivity extends SearchActivity implements View.OnClickListener {

    private TextView tv_help_close, help_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Bundle extras = getIntent().getExtras();

        tv_help_close = (TextView) findViewById(R.id.tv_help_close);

        tv_help_close.setOnClickListener(this);

        help_note = (TextView) findViewById(R.id.help_note);

        ArrayList<Integer> integers = extras.getIntegerArrayList("help_id");

        for (int i : integers){
            getNote(i);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_help_close:
                finish();
                break;
        }
    }

    StringBuffer sb = new StringBuffer();
    public void getNote(final int id) {
        String url = String.format(getString(R.string.url_note), id);

        TwitterRestClient.get(url, null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                if (statusCode == 200) {
                    List<NoteEntity> noteEntity = gson.fromJson(new String(responseBody), new TypeToken<List<NoteEntity>>() {
                    }.getType());

                    if (noteEntity.size() > 0) {
                        help_note.setText(noteEntity.get(0).getIndex_explanation());
                        sb.append(id).append(".").append(noteEntity.get(0).getIndex_explanation()).append("\r\n\n");
                    }

                    help_note.setText(sb.toString());

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
