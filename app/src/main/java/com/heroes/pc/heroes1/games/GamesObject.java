package com.heroes.pc.heroes1.games;

/**
 * Created by pc on 4/23/2016.
 */
public class  GamesObject {

    private String game_name;
    private String game_hardness;
    private String game_details;
    private String game_degree;
    private String game_performance;


    public GamesObject() {
    }

    public GamesObject(String game_name, String game_hardness, String game_details,String game_degree,String game_performance ) {
        this.game_name = game_name;
        this.game_hardness= game_hardness;
        this.game_details = game_details;
        this.game_degree = game_degree;
        this.game_performance = game_performance;
    }


    public String getGame_hardness() {
        return game_hardness;
    }

    public String getGame_name() {
        return game_name;
    }

    public String getGame_degree() {
        return game_degree;
    }

    public String getGame_details() {
        return game_details;
    }

    public String getGame_performance() {
        return game_performance;
    }
}
