package com.moutamid.random_streak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView date_tv , prev_date , result;
    TextView status_text;
    Button save_btn;

    TextView date;
    TextView month;
    TextView score;
    TextView points;

    TextView date_proper;
    TextView txt_motivation;

    ImageView close , tick ;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String TEXT2 = "text2";
    public static final String TEXT3 = "text3";
    public static final String TEXT4 = "text4";

    private String text;
    private String text2;
    private String text3;
    private String text4;

    int previous_date;
    int current_date;

    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date_tv = findViewById(R.id.date_tv);
        prev_date = findViewById(R.id.prev_date);
        result = findViewById(R.id.result);
        save_btn = findViewById(R.id.save_btn);
        status_text = findViewById(R.id.status_text);

        date = findViewById(R.id.date);
        month = findViewById(R.id.month);
        score = findViewById(R.id.score);
        points = findViewById(R.id.points);

        close = findViewById(R.id.close);
        tick = findViewById(R.id.tick);

        date_proper = findViewById(R.id.date_proper);
        txt_motivation = findViewById(R.id.txt_motivation);

        String myCurrent_dateTime = SimpleDateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        date_proper.setText(myCurrent_dateTime);

        SimpleDateFormat df = new SimpleDateFormat("d", Locale.US);
        String set_date = df.format(new Date());
        date.setText(set_date);

        SimpleDateFormat mf = new SimpleDateFormat("MM", Locale.US);
        String set_month = mf.format(new Date());
        month.setText(set_month);

        loadData();
        updateData();

        final int motivation = Integer.parseInt(date.getText().toString());
        if(motivation == 1){
            txt_motivation.setText("“Leave money on a vending machine for someone“");
        }
        else if (motivation == 2){
            txt_motivation.setText("“Bake cookies for the elderly“");
        }
        else if (motivation == 3){
            txt_motivation.setText("“Serve at a homeless shelter“");
        }
        else if(motivation == 4){
            txt_motivation.setText("“Do a 5k for a good cause“");
        }
        else if (motivation == 5){
            txt_motivation.setText("“Help at a veterinarian office“");
        }
        else if (motivation == 6){
            txt_motivation.setText("“Pick up litter on the beach“");
        }
        else if(motivation == 7){
            txt_motivation.setText("“Let someone go in front of you in line“");
        }
        else if (motivation == 8){
            txt_motivation.setText("“Give a stranger a compliment“");
        }
        else if (motivation == 9){
            txt_motivation.setText("“Make dinner for a family in need“");
        }
        else if(motivation == 10){
            txt_motivation.setText("“Insert coins into someone’s parking meter“");
        }
        else if (motivation == 11){
            txt_motivation.setText("“Buy flowers to hand out on the street“");
        }
        else if (motivation == 12){
            txt_motivation.setText("“Leave letters of encouragement on people’s cars“");
        }
        else if(motivation == 13){
            txt_motivation.setText("“Buy a movie ticket for the person behind you“");
        }
        else if (motivation == 14){
            txt_motivation.setText("“Pay for someone’s meal at a restaurant“");
        }
        else if (motivation == 15){
            txt_motivation.setText("“Write letters to soldiers“");
        }
        else if(motivation == 16){
            txt_motivation.setText("“Donate Christmas gifts to an orphanage“");
        }
        else if (motivation == 17){
            txt_motivation.setText("“Participate in a fundraiser“");
        }
        else if (motivation == 18){
            txt_motivation.setText("“Use your allowance to donate to a charity“");
        }
        else if(motivation == 19){
            txt_motivation.setText("“Hold open the doors for people“");
        }
        else if (motivation == 20){
            txt_motivation.setText("“Thank a teacher with a gift“");
        }
        else if (motivation == 21){
            txt_motivation.setText("“Donate your old clothes to the Salvation Army“");
        }
        else if (motivation == 22){
            txt_motivation.setText("“Help a senior with their groceries“");
        }
        else if (motivation == 23){
            txt_motivation.setText("“Shovel a neighbor’s driveway when it snows“");
        }
        else if (motivation == 24){
            txt_motivation.setText("“Walk a neighbor’s dog“");
        }
        else if (motivation == 25){
            txt_motivation.setText("“Babysit for free“");
        }
        else if (motivation == 26){
            txt_motivation.setText("Do a favor without asking for anything in return“");
        }
        else if (motivation == 27){
            txt_motivation.setText("“Take someone new in your neighborhood on a tour of the city“");
        }
        else if (motivation == 28){
            txt_motivation.setText("“Show the new kids around your school“");
        }
        else if (motivation == 29){
            txt_motivation.setText("“Buy an ice cream cone for a child“");
        }
        else if (motivation == 30){
            txt_motivation.setText("“Learn to say hello in a different language to different people“");
        }
        else if (motivation == 31){
            txt_motivation.setText("“Prepare a meal for your family“");
        }

    }

    private void pointsScore() {
        String sCounter = score.getText().toString().trim();
        int myPoints = Integer.parseInt(sCounter) * 10;
        String mPs = Integer.toString(myPoints);
        points.setText(mPs);
    }

    @Override
    protected void onStart() {

        String dDtV = date_tv.getText().toString().trim();
        String pD = prev_date.getText().toString().trim();
        String dD = date.getText().toString().trim();
        String mM = month.getText().toString().trim();

        if (pD.matches(dD)){
            tick.setVisibility(View.VISIBLE);
            close.setVisibility(View.GONE);
            status_text.setText("Streak Available to send... Click on Button to Accept Kindness");
            result.setText("True");
            if (dDtV.matches(dD)){

            }
            else{
                String sCounter = score.getText().toString().trim();
                int myCurrentCounter =  Integer.parseInt(sCounter) + 1;
                String mCc = Integer.toString(myCurrentCounter);
                score.setText(mCc);
                pointsScore();
            }
            save_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mM.equals("01") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("02") && dD.equals("28")){
                        date_tv.setText("28");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("03") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("04") && dD.equals("30")){
                        date_tv.setText("30");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("05") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("06") && dD.equals("30")){
                        date_tv.setText("30");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("07") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("08") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("09") && dD.equals("30")){
                        date_tv.setText("30");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("10") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("11") && dD.equals("30")){
                        date_tv.setText("30");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("12") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else{
                        date_tv.setText(date.getText().toString().trim());
                        current_date = Integer.valueOf(date_tv.getText().toString().trim());
                        previous_date = current_date+1;
                        String pDate = Integer.toString(previous_date);
                        prev_date.setText(pDate);
                        saveData();
                    }
                }
            });
        }
        else if (!pD.matches(dD)) {
            tick.setVisibility(View.GONE);
            close.setVisibility(View.VISIBLE);
            status_text.setText("Already Sent Streak");
            result.setText("False");
            if (dDtV.matches(dD)){

            }
            else{
                score.setText("1");
                status_text.setText("Your Streak Has been Starting Now...");
                tick.setVisibility(View.VISIBLE);
                close.setVisibility(View.GONE);
                pointsScore();
            }
            save_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mM.equals("01") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("02") && dD.equals("28")){
                        date_tv.setText("28");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("03") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("04") && dD.equals("30")){
                        date_tv.setText("30");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("05") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("06") && dD.equals("30")){
                        date_tv.setText("30");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("07") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("08") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("09") && dD.equals("30")){
                        date_tv.setText("30");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("10") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("11") && dD.equals("30")){
                        date_tv.setText("30");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    if (mM.equals("12") && dD.equals("31")){
                        date_tv.setText("31");
                        prev_date.setText("1");
                        saveData();
                    }
                    else
                    {
                        date_tv.setText(date.getText().toString().trim());
                        current_date = Integer.valueOf(date_tv.getText().toString().trim());
                        previous_date = current_date+1;
                        String pDate = Integer.toString(previous_date);
                        prev_date.setText(pDate);
                        saveData();
                    }
                }
            });
        }
        super.onStart();
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT , date_tv.getText().toString());
        editor.putString(TEXT2 , prev_date.getText().toString());
        editor.putString(TEXT3 , score.getText().toString());
        editor.putString(TEXT4 , points.getText().toString());

        editor.apply();
        status_text.setText("Today's Streak Done - Wait till Tomorrow");
        tick.setVisibility(View.GONE);
        close.setVisibility(View.VISIBLE);
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS , MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT , "");
        text2 = sharedPreferences.getString(TEXT2 , "");
        text3 = sharedPreferences.getString(TEXT3 , "");
        text4 = sharedPreferences.getString(TEXT4 , "");
    }

    public void updateData() {
        date_tv.setText(text);
        prev_date.setText(text2);
        score.setText(text3);
        points.setText(text4);
    }
}