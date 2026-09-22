package com.gharar.emon;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }

    private TextView makeText(String text, float size, int color, boolean bold) {
        TextView view = new TextView(this);
        view.setText(text);
        view.setTextSize(size);
        view.setTextColor(color);
        view.setGravity(Gravity.CENTER);

        if (bold) {
            view.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        }

        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showHome();
    }

    private void showHome() {

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(dp(25), dp(40), dp(25), dp(25));

        root.setBackgroundColor(Color.rgb(255, 235, 242));

        TextView heart = makeText("❤️", 70, Color.RED, false);
        root.addView(heart, new LinearLayout.LayoutParams(
                -1, dp(100)
        ));

        TextView title = makeText(
                "قرارمون",
                34,
                Color.rgb(190, 25, 90),
                true
        );

        root.addView(title, new LinearLayout.LayoutParams(
                -1, dp(60)
        ));

        TextView subtitle = makeText(
                "جایی برای خاطره‌های قشنگ دونفره‌مون 💕",
                18,
                Color.rgb(100, 70, 80),
                false
        );

        root.addView(subtitle, new LinearLayout.LayoutParams(
                -1, dp(60)
        ));

        Button enter = new Button(this);

        enter.setText("ورود به قرارمون ❤️");
        enter.setTextSize(18);
        enter.setTextColor(Color.WHITE);
        enter.setAllCaps(false);

        enter.setBackgroundColor(Color.rgb(225, 45, 105));

        LinearLayout.LayoutParams buttonParams =
                new LinearLayout.LayoutParams(
                        -1,
                        dp(60)
                );

        buttonParams.setMargins(
                dp(10),
                dp(30),
                dp(10),
                dp(10)
        );

        root.addView(enter, buttonParams);

        enter.setOnClickListener(v -> {

            TextView message = makeText(
                    "اینجا قراره دنیای دونفره‌مون ساخته بشه 💕\n\n📸 عکس‌ها\n💌 پیام‌ها\n📝 خاطره‌ها",
                    21,
                    Color.rgb(150, 30, 80),
                    true
            );

            root.removeAllViews();

            root.addView(message, new LinearLayout.LayoutParams(
                    -1,
                    dp(300)
            ));

            Button back = new Button(this);

            back.setText("برگشت ❤️");
            back.setTextSize(18);
            back.setAllCaps(false);

            root.addView(back, new LinearLayout.LayoutParams(
                    -1,
                    dp(60)
            ));

            back.setOnClickListener(x -> showHome());
        });

        setContentView(root);
    }
}
