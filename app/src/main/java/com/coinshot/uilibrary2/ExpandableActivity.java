package com.coinshot.uilibrary2;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import net.cachapa.expandablelayout.ExpandableLayout;


public class ExpandableActivity extends Activity {

   ExpandableLayout layout;
   TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);

        layout = findViewById(R.id.expandableLayout);
        text = findViewById(R.id.textView);

        layout.collapse();

        layout.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("LAYOUT", "layout");
            }
        });

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout.isExpanded()){
                    layout.collapse();
                }else{
                    layout.expand();
                }
            }
        });
    }
}
