package com.example.cpra3_elc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class ComputerAdapter extends ArrayAdapter<Computer> {
    private Context context;
    private ArrayList<Computer> computers;

    public ComputerAdapter(Context context, ArrayList<Computer> computers) {
        super(context, R.layout.list_item_computer, computers);
        this.context = context;
        this.computers = computers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_computer, parent, false);
            
            holder = new ViewHolder();
            holder.imageComputer = (ImageView) convertView.findViewById(R.id.imageComputer);
            holder.textBrand = (TextView) convertView.findViewById(R.id.textBrand);
            holder.textModel = (TextView) convertView.findViewById(R.id.textModel);
            holder.textProcessor = (TextView) convertView.findViewById(R.id.textProcessor);
            
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Computer computer = computers.get(position);
        
        holder.imageComputer.setImageResource(computer.getImageId());
        holder.textBrand.setText(computer.getBrand());
        holder.textModel.setText(computer.getModel());
        holder.textProcessor.setText(computer.getProcessor());

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageComputer;
        TextView textBrand;
        TextView textModel;
        TextView textProcessor;
    }
}
