package com.example.googleuteq;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    private final Context mContext;

    public CustomInfoWindowAdapter(Context context) {
        mContext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
    }

    private void renderWindowText(Marker marker, View view) {
        String title = marker.getTitle();
        TextView titleTextView = view.findViewById(R.id.title);
        if (!title.equals("")) {
            titleTextView.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView snippetTextView = view.findViewById(R.id.snippet);
        if (!snippet.equals("")) {
            snippetTextView.setText(snippet);
        }

        // Carga la imagen en el ImageView
        ImageView imageView = view.findViewById(R.id.imageView);
        if (marker.getTag() != null && marker.getTag() instanceof Integer) {
            int imageResId = (Integer) marker.getTag();
            imageView.setImageResource(imageResId);
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }
}
