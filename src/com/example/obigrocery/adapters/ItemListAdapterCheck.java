package com.example.obigrocery.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.obigrocery.activities.R;

public class ItemListAdapterCheck extends ItemListAdapterGen {

    public ItemListAdapterCheck(Context context) {
        super(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_item_check, null);
        }

        // Handle TextView and display string from your list
        TextView listItemText = (TextView) view
                .findViewById(R.id.list_item_string);
        listItemText.setText(display.get(position).toString());

        CheckBox purchasedCheckbox = (CheckBox) view.findViewById(R.id.check);
        purchasedCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO test first
            }
        });

        return view;
    }
}
