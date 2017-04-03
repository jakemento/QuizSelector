package jws.quizselector;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class infoActivity extends Activity {
    private int indexValue;

    @Bind(R.id.moreInfoTextView) TextView mMoreInfoTextView;
    private String[] Answers = new String[] {"The Civil War, also known as “The War Between the States,” was fought between the United States of America and the Confederate States of America, a collection of eleven southern states that left the Union in 1860 and 1861 and formed their own country in order to protect the institution of slavery.", "World War 2 ended with the unconditional surrender of the Axis powers. On 8 May 1945, the Allies accepted Germany's surrender, about a week after Adolf Hitler had committed suicide. VE Day – Victory in Europe celebrates the end of the Second World War on 8 May 1945.", "The United States Constitution was penned, edited, redrafted, and ratified on September 17th, 1787.", "The U.S. joined its allies--Britain, France, and Russia--to fight in World War I on April 6, 1917. Major General John J. Pershing, commanded more than 2 million U.S. soldiers to fight on battlefields in France. Many Americans were not in favor of the U.S. entering the war and wanted to remain neutral."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           indexValue = extras.getInt("currentIndex");
        }

        mMoreInfoTextView.setText(Answers[indexValue]);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

//        int width = dm.widthPixels;
//        int height = dm.heightPixels;

        getWindow().setLayout(600,580);
        getWindow().setGravity(0);

    }
}
