package com.firstvrp.censusdata.CensusTaker.Main.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firstvrp.censusdata.R;

/**
 * Created by chenyuan on 16/6/20.
 */
public class HelpDialog {
    public TextView help_note;
    private Button help_ok;
    private String helpContent;
    private Context context;

    public HelpDialog(Context context, String helpContent) {
        this.helpContent = helpContent;
        this.context = context;
        createDialogAdd();
    }

    public void createDialogAdd() {
        View viewAdd = LayoutInflater.from(context).inflate(R.layout.dialog_help, null);
        final Dialog dialogAdd = new Dialog(context);
        dialogAdd.setContentView(viewAdd);
        dialogAdd.setTitle("指标解释说明");
        help_note = (TextView) viewAdd.findViewById(R.id.help_note);
        help_note.setText(helpContent);
        help_ok = (Button) viewAdd.findViewById(R.id.help_ok);
        help_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialogAdd.dismiss();
            }
        });

        dialogAdd.show();
    }
}
