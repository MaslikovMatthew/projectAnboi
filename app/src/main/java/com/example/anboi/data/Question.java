package com.example.anboi.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Question implements Parcelable {
    private final String question;
    private String[] answers;
    private final int correctAnswer;
    private List<String> result;

    public Question(String question, String[] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    protected Question(Parcel in) {
        question = in.readString();
        answers = in.createStringArray();
        correctAnswer = in.readInt();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeStringArray(answers);
        dest.writeInt(correctAnswer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return (String[]) result.toArray();
    }

    public void shuffle(){
        result = Arrays.asList(Arrays.stream(answers).toArray(String[]::new));
        Collections.shuffle(result);
    }

    public int getCorrectAnswer() {
        for (int i = 0; i < result.size(); i++) {
            if(Objects.equals(answers[correctAnswer], result.get(i))) return i;
        }
        return 0;
    }
}
