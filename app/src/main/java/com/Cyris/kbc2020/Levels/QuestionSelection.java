package com.Cyris.kbc2020.Levels;

import com.Cyris.kbc2020.Questions.HindiQuestionSet1;
import com.Cyris.kbc2020.Questions.HindiQuestionSet2;
import com.Cyris.kbc2020.Questions.HindiQuestionSet3;
import com.Cyris.kbc2020.Questions.QuestionAnswerObjectClass;
import com.Cyris.kbc2020.Questions.QuestionSet1;
import com.Cyris.kbc2020.Questions.QuestionSet2;
import com.Cyris.kbc2020.Questions.QuestionSet3;

import java.util.ArrayList;

public class QuestionSelection {
    int level=1;
    String language="";
    int MULTIPLIER = 15;
    ArrayList<QuestionAnswerObjectClass> data;
    public QuestionSelection(int level,String language){
        this.level = level;
        this.language = language;
        /*data = QuestionSet1.getAllDataFromSet1();
        data = QuestionSet2.getAllDataFromSet2();
        data = QuestionSet3.getAllDataFromSet3();
        data = HindiQuestionSet1.getAllDataFromHindiSet1();
        data = HindiQuestionSet2.getAllDataFromHindiSet2();
        data = HindiQuestionSet3.getAllDataFromHindiSet3();*/
    }

    public ArrayList<QuestionAnswerObjectClass> getQuestionSet(){
        if(language.equals("English")) {
            if (level <= 20) {
              data = QuestionSet1.getAllDataFromSet1();
            }else if(level<=35){
                data = QuestionSet2.getAllDataFromSet2();
            }else{
                data = QuestionSet3.getAllDataFromSet3();
            }
        }else{
            if (level <= 20) {
                data = HindiQuestionSet1.getAllDataFromHindiSet1();
            }else if(level<=35){
                data = HindiQuestionSet2.getAllDataFromHindiSet2();
             }else{
                data = HindiQuestionSet3.getAllDataFromHindiSet3();
            }
        }
        return data;
    }

    public int getQuestionMaxRange(){
        switch(level){
            case 1:
            case 21:
            case 36:
                return MULTIPLIER;
            case 2:
            case 22:
            case 37:
                return MULTIPLIER*2;
            case 3:
            case 23:
            case 38:
                return MULTIPLIER*3;
            case 4:
            case 24:
            case 39:
                return MULTIPLIER*4;
            case 5:
            case 25:
            case 40:
                return MULTIPLIER*5;
            case 6:
            case 26:
            case 41:
                return MULTIPLIER*6;
            case 7:
            case 27:
            case 42:
                return MULTIPLIER*7;
            case 8:
            case 28:
            case 43:
                return MULTIPLIER*8;
            case 9:
            case 29:
                return MULTIPLIER*9;
            case 10:
            case 30:
                return MULTIPLIER*10;
            case 11:
            case 31:
                return MULTIPLIER*11;
            case 12:
            case 32:
                return MULTIPLIER*12;
            case 13:
            case 33:
                return MULTIPLIER*13;
            case 14:
            case 34:
                return MULTIPLIER*14;
            case 15:
            case 35:
                return MULTIPLIER*15;
            case 16:
                return MULTIPLIER*16;
            case 17:
                return MULTIPLIER*17;
            case 18:
                return MULTIPLIER*18;
            case 19:
                return MULTIPLIER*19;
            case 20:
                return MULTIPLIER*20;



        }
        return 56;
    }

}
