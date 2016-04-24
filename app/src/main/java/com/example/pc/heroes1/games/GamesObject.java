package com.example.pc.heroes1.games;

/**
 * Created by pc on 4/23/2016.
 */
public class  GamesObject {

    private String game_name;
    private String game_hardness;

    public GamesObject() {
    }

    public GamesObject(String game_name, String game_hardness ) {
        this.game_name = game_name;
        this.game_hardness= game_hardness;
    }

    public String getGame_hardness() {
        return game_hardness;
    }

    public String getGame_name() {
        return game_name;
    }

}
