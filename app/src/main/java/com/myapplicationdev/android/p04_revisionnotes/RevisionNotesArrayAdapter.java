package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RevisionNotesArrayAdapter extends ArrayAdapter<Note> {
	Context context;
	transient
	ArrayList<Note> notes;
	TextView tvcontent;
	int resource;
	ImageView imgv1, imgv2, imgv3, imgv4, imgv5;

	public RevisionNotesArrayAdapter(Context context, int resource, ArrayList<Note> notes) {
		super(context, resource, notes);
		this.context = context;
		this.notes = notes;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(resource, parent, false);
		//Match the UI components with Java variables
		tvcontent = (TextView)rowView.findViewById(R.id.textViewNote);
		imgv1 = (ImageView)rowView.findViewById(R.id.imageView1star);
		imgv2 = (ImageView)rowView.findViewById(R.id.imageView2star);
		imgv3 = (ImageView)rowView.findViewById(R.id.imageView3star);
		imgv4 = (ImageView)rowView.findViewById(R.id.imageView4star);
		imgv5 = (ImageView)rowView.findViewById(R.id.imageView5star);


		Note note = notes.get(position);
		int star = note.getStars();
		tvcontent.setText(note.getNoteContent());

		//Check if the property for starts >= 5, if so, "light" up the stars
		if (star==5) {
			imgv5.setImageResource(android.R.drawable.btn_star_big_on);
			imgv4.setImageResource(android.R.drawable.btn_star_big_on);
			imgv3.setImageResource(android.R.drawable.btn_star_big_on);
			imgv2.setImageResource(android.R.drawable.btn_star_big_on);
			imgv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if(star==4){
			imgv4.setImageResource(android.R.drawable.btn_star_big_on);
			imgv3.setImageResource(android.R.drawable.btn_star_big_on);
			imgv2.setImageResource(android.R.drawable.btn_star_big_on);
			imgv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if(star==3){
			imgv3.setImageResource(android.R.drawable.btn_star_big_on);
			imgv2.setImageResource(android.R.drawable.btn_star_big_on);
			imgv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if(star==2){
			imgv2.setImageResource(android.R.drawable.btn_star_big_on);
			imgv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else if(star==1){
			imgv1.setImageResource(android.R.drawable.btn_star_big_on);
		}else{

		}

		return rowView;
	}



}
