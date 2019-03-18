package nguyenngoctan44.io.viewtag;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import nguyenngoctan44.io.viewtags.UNMultiViewTags;

public class MainActivity extends AppCompatActivity {

    private final static String[] COUNTRIES = new String[]{"Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia", "Bulgaria", "Croatia",
            "Czechia", "Denmark", "Estonia", "Faroe Islands", "Finland", "France", "Germany", "Gibraltar", "Greece", "Guernsey", "Hungary",
            "Iceland", "Ireland", "Isle of Man", "Italy", "Jersey", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Malta", "Monaco",
            "Montenegro", "Netherlands", "Norway", "Poland", "Portugal", "Moldova", "Romania", "Russia", "San Marino"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        drawTags();
    }

    private void drawTags() {
        UNMultiViewTags viewTags;
        viewTags = findViewById(R.id.viewTags);
        LayoutInflater layoutInflater = getLayoutInflater();
        for (String countries : COUNTRIES) {
            View customViewTag = layoutInflater.inflate(R.layout.item_layout, null, false);
            TextView titleTag = customViewTag.findViewById(R.id.tag);
            titleTag.setText(countries);
            titleTag.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.background_text));
            viewTags.addView(customViewTag);
        }
    }
}
