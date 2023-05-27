package com.example.anboi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import com.example.anboi.data.Question;
import com.example.anboi.data.Wallpaper;
import com.example.anboi.fragment.QuizFragment;
import com.example.anboi.R;
import com.example.anboi.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private long backPressedTime;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ArrayList<Wallpaper> wallpapers = new ArrayList<>();
    private ArrayList<Question> easyQuestions = new ArrayList<>();
    private ArrayList<Question> mediumQuestions = new ArrayList<>();
    private ArrayList<Question> hardQuestions = new ArrayList<>();

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        TextView header = findViewById(R.id.text_header);
        TextView points = findViewById(R.id.text_points);

        String pointsText = getString(R.string.points) + ": " + sharedPreferences.getInt("points", 0);

        wallpapers.add(
                new Wallpaper(
                        10,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_1)),
                        R.drawable.img_wallpaper_1
                )
        );
        wallpapers.add(
                new Wallpaper(
                        20,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_2)),
                        R.drawable.img_wallpaper_2
                )
        );
        wallpapers.add(
                new Wallpaper(
                        30,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_3)),
                        R.drawable.img_wallpaper_3
                )
        );
        wallpapers.add(
                new Wallpaper(
                        40,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_4)),
                        R.drawable.img_wallpaper_4
                )
        );
        wallpapers.add(
                new Wallpaper(
                        50,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_5)),
                        R.drawable.img_wallpaper_5
                )
        );
        wallpapers.add(
                new Wallpaper(
                        60,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_6)),
                        R.drawable.img_wallpaper_6
                )
        );
        wallpapers.add(
                new Wallpaper(
                        70,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_7)),
                        R.drawable.img_wallpaper_7
                )
        );
        wallpapers.add(
                new Wallpaper(
                        80,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_8)),
                        R.drawable.img_wallpaper_8
                )
        );
        wallpapers.add(
                new Wallpaper(
                        90,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_9)),
                        R.drawable.img_wallpaper_9
                )
        );
        wallpapers.add(
                new Wallpaper(
                        100,
                        sharedPreferences.getString("purchased", "").contains(Integer.toString(R.drawable.img_wallpaper_10)),
                        R.drawable.img_wallpaper_10
                )
        );


        easyQuestions.add(
                new Question(
                        "What is the name of the most popular anime series in Japan?",
                        new String[]{"One Piece", "Naruto", "Dragon Ball", "Attack on Titan"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Who is the protagonist in the anime series 'Naruto'?",
                        new String[]{"Sasuke Uchiha", "Sakura Haruno", "Kakashi Hatake", "Naruto Uzumaki"},
                        3
                )
        );
        easyQuestions.add(
                new Question(
                        "What is the name of the main character in the anime series 'One Piece'?",
                        new String[]{"Monkey D. Luffy", "Zoro Roronoa", "Nami", "Sanji"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Which anime series features a group of students with supernatural powers attending a school for heroes?",
                        new String[]{"My Hero Academia", "Assassination Classroom", "Soul Eater", "Blue Exorcist"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Who is the creator of the anime series 'Dragon Ball'?",
                        new String[]{"Hayao Miyazaki", "Akira Toriyama", "Osamu Tezuka", "Masashi Kishimoto"},
                        1
                )
        );
        easyQuestions.add(
                new Question(
                        "What is the name of the giant robot in the anime series 'Gundam'?",
                        new String[]{"Eva Unit-01", "Gurren Lagann", "RX-78-2 Gundam", "Big O"},
                        2
                )
        );
        easyQuestions.add(
                new Question(
                        "Which anime series features a young boy who becomes a powerful wizard?",
                        new String[]{"Fairy Tail", "Black Clover", "Magi: The Labyrinth of Magic", "The Seven Deadly Sins"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Death Note'?",
                        new String[]{"L Lawliet", "Misa Amane", "Ryuk", "Light Yagami"},
                        3
                )
        );
        easyQuestions.add(
                new Question(
                        "Which anime series features a group of high school students who must survive a deadly game?",
                        new String[]{"Mirai Nikki", "Danganronpa", "Btooom!", "Akame ga Kill!"},
                        1
                )
        );
        easyQuestions.add(
                new Question(
                        "What is the name of the magical girl in the anime series 'Sailor Moon'?",
                        new String[]{"Usagi Tsukino", "Ami Mizuno", "Rei Hino", "Minako Aino"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Which anime series features a group of friends who become trapped in a virtual reality game?",
                        new String[]{"Sword Art Online", "Log Horizon", "No Game No Life", "Overlord"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Attack on Titan'?",
                        new String[]{"Mikasa Ackerman", "Armin Arlert", "Levi Ackerman", "Eren Yeager"},
                        3
                )
        );
        easyQuestions.add(
                new Question(
                        "What is the name of the ninja village in the anime series 'Naruto'?",
                        new String[]{"Konohagakure", "Sunagakure", "Kirigakure", "Iwagakure"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Which anime series features a young boy who dreams of becoming a pirate?",
                        new String[]{"One Piece", "Black Lagoon", "Cowboy Bebop", "Trigun"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Bleach'?",
                        new String[]{"Ichigo Kurosaki", "Rukia Kuchiki", "Uryu Ishida", "Orihime Inoue"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "What is the name of the demon who possesses the main character in the anime series 'Blue Exorcist'?",
                        new String[]{"Mephisto Pheles", "Amaimon", "Rin Okumura", "Satan"},
                        3
                )
        );
        easyQuestions.add(
                new Question(
                        "Which anime series features a group of magical girls who fight witches to protect their city?",
                        new String[]{"Puella Magi Madoka Magica", "Cardcaptor Sakura", "Sailor Moon", "Magical Girl Lyrical Nanoha"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Fullmetal Alchemist'?",
                        new String[]{"Edward Elric", "Alphonse Elric", "Roy Mustang", "Winry Rockbell"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "What is the name of the organization that fights against Titans in the anime series 'Attack on Titan'?",
                        new String[]{"Scouting Legion", "Military Police Brigade", "Garrison Regiment", "Yeagerists"},
                        0
                )
        );
        easyQuestions.add(
                new Question(
                        "Which anime series features a group of students who attend a school for assassins?",
                        new String[]{"Assassination Classroom", "Akame ga Kill!", "Black Bullet", "Code Geass"},
                        0
                )
        );



        mediumQuestions.add(
                new Question(
                        "What is the name of the main villain in the anime series 'Death Note'?",
                        new String[]{"Light Yagami", "Misa Amane", "Ryuk", "L"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Fullmetal Alchemist: Brotherhood'?",
                        new String[]{"Edward Elric", "Alphonse Elric", "Roy Mustang", "Winry Rockbell"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Which anime series features a group of people who are trapped in a time loop?",
                        new String[]{"Steins;Gate", "Erased", "The Melancholy of Haruhi Suzumiya", "Re:Zero − Starting Life in Another World"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "What is the name of the protagonist in the anime series 'One Punch Man'?",
                        new String[]{"Saitama", "Genos", "Mumen Rider", "King"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Which anime series features a group of people who are part of a secret organization that fights against supernatural threats?",
                        new String[]{"Fate/Zero", "Fate/stay night: Unlimited Blade Works", "Kara no Kyoukai", "The Garden of Sinners"},
                        2
                )
        );
        mediumQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Attack on Titan'?",
                        new String[]{"Eren Yeager", "Mikasa Ackerman", "Armin Arlert", "Levi Ackerman"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "What is the name of the protagonist in the anime series 'Naruto'?",
                        new String[]{"Naruto Uzumaki", "Sasuke Uchiha", "Kakashi Hatake", "Sakura Haruno"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Which anime series features a group of people who are part of a military organization that fights against giant robots?",
                        new String[]{"Full Metal Panic!", "Code Geass", "Gundam 00", "Macross Frontier"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Bleach'?",
                        new String[]{"Ichigo Kurosaki", "Rukia Kuchiki", "Uryu Ishida", "Orihime Inoue"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "What is the name of the organization that controls the world in the anime series 'Psycho-Pass'?",
                        new String[]{"Sibyl System", "Public Safety Bureau", "Ministry of Welfare", "Criminal Investigation Department"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Which anime series features a group of people who are part of a guild that fights against monsters in a virtual reality game?",
                        new String[]{"Sword Art Online", "Log Horizon", "No Game No Life", "Overlord"},
                        1
                )
        );
        mediumQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Death Parade'?",
                        new String[]{"Decim", "Chiyuki", "Nona", "Ginti"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "What is the name of the protagonist in the anime series 'Tokyo Ghoul'?",
                        new String[]{"Ken Kaneki", "Touka Kirishima", "Juuzou Suzuya", "Shuu Tsukiyama"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Which anime series features a group of people who are part of a school that trains assassins?",
                        new String[]{"Assassination Classroom", "Akame ga Kill!", "Kill la Kill", "Danganronpa: The Animation"},
                        1
                )
        );
        mediumQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Gintama'?",
                        new String[]{"Gintoki Sakata", "Shinpachi Shimura", "Kagura", "Sadaharu"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "What is the name of the protagonist in the anime series 'Death Note'?",
                        new String[]{"Light Yagami", "Misa Amane", "Ryuk", "L"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Which anime series features a group of people who are part of a secret organization that fights against demons?",
                        new String[]{"Blue Exorcist", "Devilman Crybaby", "Demon Slayer: Kimetsu no Yaiba", "D.Gray-man"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Fairy Tail'?",
                        new String[]{"Natsu Dragneel", "Lucy Heartfilia", "Gray Fullbuster", "Erza Scarlet"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "What is the name of the protagonist in the anime series 'Dragon Ball Z'?",
                        new String[]{"Goku", "Vegeta", "Piccolo", "Gohan"},
                        0
                )
        );
        mediumQuestions.add(
                new Question(
                        "Which anime series features a group of people who are part of a school that trains soldiers to fight against aliens?",
                        new String[]{"Neon Genesis Evangelion", "Gurren Lagann", "Aldnoah.Zero", "Mobile Suit Gundam: Iron-Blooded Orphans"},
                        0
                )
        );


        hardQuestions.add(
                new Question(
                        "What is the name of the robot in the anime series 'Neon Genesis Evangelion'?",
                        new String[]{"Eva Unit-01", "Gurren Lagann", "RX-78-2 Gundam", "Big O"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Cowboy Bebop'?",
                        new String[]{"Spike Spiegel", "Faye Valentine", "Jet Black", "Edward"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Which anime series features a group of high school students who gain supernatural powers?",
                        new String[]{"Charlotte", "K-On!", "Love Live!", "Lucky Star"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "What is the name of the main character in the anime series 'Fate/Zero'?",
                        new String[]{"Kiritsugu Emiya", "Saber", "Rider", "Lancer"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Which anime series features a group of teenagers who pilot giant robots to fight aliens?",
                        new String[]{"Evangelion", "Gundam Wing", "Macross", "Eureka Seven"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Sword Art Online'?",
                        new String[]{"Kirito", "Asuna", "Sinon", "Leafa"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "What is the name of the magical world in the anime series 'Little Witch Academia'?",
                        new String[]{"Luna Nova", "Hogwarts", "Mahoutokoro", "Ilvermorny"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Which anime series features a group of people who are transported to a fantasy world and must survive?",
                        new String[]{"Grimgar of Fantasy and Ash", "Re:Zero − Starting Life in Another World", "Log Horizon", "Overlord"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Jojo's Bizarre Adventure'?",
                        new String[]{"Jotaro Kujo", "Joseph Joestar", "Giorno Giovanna", "Jonathan Joestar"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "What is the name of the protagonist in the anime series 'My Hero Academia'?",
                        new String[]{"Izuku Midoriya", "Katsuki Bakugo", "Shoto Todoroki", "Ochaco Uraraka"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Which anime series features a group of people who must survive on a deserted island?",
                        new String[]{"Btooom!", "Highschool of the Dead", "Grisaia no Kajitsu", "Kokoro Connect"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Hunter x Hunter'?",
                        new String[]{"Gon Freecss", "Killua Zoldyck", "Kurapika", "Leorio Paradinight"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "What is the name of the school in the anime series 'Assassination Classroom'?",
                        new String[]{"Kunugigaoka Junior High School", "Yokai Academy", "Honnoji Academy", "Hachimitsu Academy"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Which anime series features a group of people who are trapped in a game-like world?",
                        new String[]{"No Game No Life", "Log Horizon", "Sword Art Online", "Overlord"},
                        2
                )
        );
        hardQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Code Geass'?",
                        new String[]{"Lelouch Lamperouge", "Suzaku Kururugi", "C.C.", "Nunnally Lamperouge"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "What is the name of the protagonist in the anime series 'Akame ga Kill!'?",
                        new String[]{"Tatsumi", "Akame", "Esdeath", "Mine"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Which anime series features a group of people who are reincarnated into a fantasy world?",
                        new String[]{"Re:Zero − Starting Life in Another World", "Grimgar of Fantasy and Ash", "Overlord", "Log Horizon"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Who is the main character in the anime series 'Black Butler'?",
                        new String[]{"Ciel Phantomhive", "Sebastian Michaelis", "Grell Sutcliff", "Undertaker"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "What is the name of the organization that fights against the Titans in the anime series 'Attack on Titan'?",
                        new String[]{"Scouting Legion", "Military Police Brigade", "Garrison Regiment", "Yeagerists"},
                        0
                )
        );
        hardQuestions.add(
                new Question(
                        "Which anime series features a group of people who are transported to a parallel world?",
                        new String[]{"Gate", "Re:Creators", "KonoSuba", "Drifters"},
                        0
                )
        );

        ShopFragment shopFragment = new ShopFragment(this, wallpapers, points);
        QuizFragment quizFragment = new QuizFragment(this, easyQuestions, mediumQuestions, hardQuestions);

        points.setText(pointsText);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.shop:
                    header.setText(getString(R.string.shop));
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, shopFragment).commit();
                    editor.putInt("fragment", R.id.shop);
                    editor.apply();
                    return true;

                case R.id.quiz:
                    header.setText(getString(R.string.quiz));
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, quizFragment).commit();
                    editor.putInt("fragment", R.id.quiz);
                    editor.apply();
                    return true;
            }
            return false;
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else {
            Toast.makeText(this, getString(R.string.click_again_to_exit), Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.setSelectedItemId(sharedPreferences.getInt("fragment", R.id.quiz));
    }
}