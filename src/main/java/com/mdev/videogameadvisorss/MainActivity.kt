package com.mdev.videogameadvisorss

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGamesBtn = findViewById<Button>(R.id.find_game)

        findGamesBtn.setOnClickListener{
            //What do we do when we click on the button?
            //1. Get a reference to the spinner
            val gameChoice = findViewById<Spinner>(R.id.game_choice)
            //2. Get the selected item in the spinner
            val selectedGenres = gameChoice.selectedItem
            //2.b. Get the list of games based on genre
            val gameList = getGames(selectedGenres.toString())
            val gameFacts = getInfo(selectedGenres.toString())
            //2.c. Modify my list to include new line character
            val games = gameList.reduce { str, item -> str + '\n' + item   }
            val info = gameFacts.reduce { str, item -> str + '\n' + item   }
            //3. Get a reference to the TextView
            val finalGameList = findViewById<TextView>(R.id.games)
            val finalInfo = findViewById<TextView>(R.id.info)
            //4. Update the text to reflect the item selected in the spinner
            finalGameList.text = games
            finalInfo.text = info


        }


    }

    fun getGames(genre: String) : List<String>{
        return when (genre){
            "Action" -> listOf("Assassin's Creed Valhalla","GTA 5")
            "Adventure" -> listOf("It Takes Two","Far Cry")
            "Strategy" -> listOf("Unity of Command","StarCraft")
            "Sports" -> listOf("FIFA 2023","NBA2K23")
            "RPG" -> listOf("Pokemon","The Witcher 3: Wild Hunt")
            else -> listOf("Super Mario","Metroid")

        }
    }

    fun getInfo(genre: String) : List<String>{
        return when (genre){
            "Action" -> listOf("Assassin's Creed Valhalla is a 2020 action role-playing video game developed by Ubisoft Montreal and published by Ubisoft.","Grand Theft Auto V is a 2013 action-adventure game developed by Rockstar North and published by Rockstar Games.")
            "Adventure" -> listOf("It Takes Two is an action-adventure platform video game developed by Hazelight Studios and published by Electronic Arts.","Far Cry 4 is a first-person adventure game. Players assume control of Ajay Ghale, a Kyrati-American who is on a quest to spread his deceased mother's ashes in the fictional country of Kyrat.")
            "Strategy" -> listOf("Strategy is a video game genre that emphasizes thinking and planning over direct instant action in order to achieve victory. Although many types of video games can contain strategic elements, as a genre, strategy games are most commonly defined as those with a primary focus on high-level strategy, logistics and resource management.")
            "Sports" -> listOf("FIFA 23 is a football video game published by Electronic Arts. It is the 30th installment in the FIFA series that is developed by EA Sports, and the final installment under the FIFA banner, and released worldwide on 30 September 2022 for PC, Nintendo Switch, PlayStation 4, PlayStation 5, Xbox One and Xbox Series X/S.","NBA 2K23 is a basketball video game developed by Visual Concepts and published by 2K Sports, based on the National Basketball Association (NBA). It is the 24th installment in the NBA 2K franchise and is the successor to NBA 2K22.")
            "RPG" -> listOf("Pokémon is a series of video games developed by Game Freak and published by Nintendo and The Pokémon Company under the Pokémon media franchise.","The Witcher 3: Wild Hunt is a 2015 action role-playing game developed and published by CD Projekt. It is the sequel to the 2011 game The Witcher 2: Assassins of Kings and the third game in The Witcher video game series, played in an open world with a third-person perspective")
            else -> listOf("Super Mario is a platform game series created by Nintendo starring their mascot, Mario. It is the central series of the greater Mario franchise. ","Metroid is an action-adventure game franchise created by Nintendo. The player controls the bounty hunter Samus Aran, who protects the galaxy from Space Pirates and other malevolent forces and their attempts to harness the power of the parasitic Metroid creatures. ")
        }

    }

}

