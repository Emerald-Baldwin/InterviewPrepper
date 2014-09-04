package com.example.interviewprepper;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends Activity {
	ArrayList<String> questions;
	int currentIndex;
	Random randomNumberGenerator;
	TextView textblock;
	Chronometer clock;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        createListOfQuestions();
        
        randomNumberGenerator = new Random();
        currentIndex = randomNumberGenerator.nextInt(questions.size());
        textblock = (TextView) findViewById(R.id.question);
        textblock.setText(questions.get(currentIndex));
        
        clock = (Chronometer) findViewById(R.id.timer);
        clock.start();
        
        System.out.println(clock.toString());
        
        Button completedButton = (Button) findViewById(R.id.completed);
        completedButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (questions.size() > 0) {
					questions.remove(currentIndex); 
					
					if (questions.size() != 0) {
						currentIndex = randomNumberGenerator.nextInt(questions.size());
						textblock.setText(questions.get(currentIndex));
					} else {
						textblock.setText("No more questions remaining");
					}
				}
			}
        });
        Button skipButton = (Button) findViewById(R.id.skip);
        skipButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (questions.size() != 0) {
					currentIndex = randomNumberGenerator.nextInt(questions.size());
					textblock.setText(questions.get(currentIndex));
				}
			} 	
        });
        
        if (questions.size() == 0) {
        	skipButton.setClickable(false);
        	completedButton.setClickable(false);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void createListOfQuestions() {
    	questions = new ArrayList<String>();
    	questions.add("What are your strengths?");
    	questions.add("What are your weaknesses?");
    	questions.add("Why are you interested in working for [insert company name here]?");
    	questions.add("Where do you see yourself in 5 years? 10 years?");
    	questions.add("Why do you want to leave your current company?");
    	questions.add("Why was there a gap in your employment between [insert date] and [insert date]?");
    	questions.add("What can you offer us that someone else can not?");
    	questions.add("What are three things your former manager would like you to improve on?");
    	questions.add("Are you willing to relocate?");
    	questions.add("Are you willing to travel?");
    	questions.add("Tell me about an accomplishment you are most proud of.");
    	questions.add("Tell me about a time you made a mistake.");
    	questions.add("What is your dream job?");
    	questions.add("How did you hear about this position?");
    	questions.add("What would you look to accomplish in the first 30 days/60 days/90 days on the job?");
    	questions.add("Discuss your resume.");
    	questions.add("Discuss your educational background.");
    	questions.add("Describe yourself.");
    	questions.add("Tell me how you handled a difficult situation.");
    	questions.add("Why should we hire you?");
    	questions.add("Why are you looking for a new job?");
    	questions.add("Would you work holidays/weekends?");
    	questions.add("How would you deal with an angry or irate customer?");
    	questions.add("What are your salary requirements?");
    	questions.add("Give a time when you went above and beyond the requirements for a project.");
    	questions.add("Who are our competitors?");
    	questions.add("What was your biggest failure?");
    	questions.add("What motivates you?");
    	questions.add("What’s your availability?");
    	questions.add("Who’s your mentor?");
    	questions.add("Tell me about a time when you disagreed with your boss.");
    	questions.add("How do you handle pressure?");
    	questions.add("What is the name of our CEO?");
    	questions.add("What are your career goals?");
    	questions.add("What gets you up in the morning?");
    	questions.add("What would your direct reports say about you?");
    	questions.add("What were your bosses’ strengths/weaknesses?");
    	questions.add("If I called your boss right now and asked him what is an area that you could improve on, what would he say?");
    	questions.add("Are you a leader or a follower?");
    	questions.add("What was the last book you’ve read for fun?");
    	questions.add("What are your co-worker pet peeves?");
    	questions.add("What are your hobbies?");
    	questions.add("What is your favorite website?");
    	questions.add("What makes you uncomfortable?");
    	questions.add("What are some of your leadership experiences?");
    	questions.add("How would you fire someone?");
    	questions.add("What do you like the most and least about working in this industry?");
    	questions.add("Would you work 40+ hours a week?");
    	questions.add("What questions haven’t I asked you?");
    	questions.add("What questions do you have for me?");
    }
    
}
