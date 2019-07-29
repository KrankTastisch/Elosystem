package de.mika.elosystem.api;

public class EloRank {




    public static int bot = 1000;
    public static int player = 1000;


    public static enum Team{
        BOT , PLAYER
    }




    public static void setElo(Team team, int elo){
        if(team.equals(Team.BOT)){
            bot = elo;
        }else if(team.equals(Team.PLAYER)){
            player = elo;
        }
    }

    public static void removeElo(Team team, int elo){
        if(team.equals(Team.PLAYER)){
            player -= elo;
        }else if(team.equals(Team.BOT)){
            bot -= elo;
        }
    }


    public static void addElo(Team team, int elo){
        if(team.equals(Team.PLAYER)){
            player += elo;
        }else if(team.equals(Team.BOT)){
            bot += elo;
        }
    }

    public static int getElo(Team team){
        if(team.equals(Team.BOT)){
            return player;
        }else{
            return bot;
        }
    }

    public static  void EloRank(Team winner, Team looser) {
        try {
            System.out.println(getElo(winner));
            System.out.println(getElo(looser));
            int k = 50;
            int elo =  (int) (k * (1 - (1 / (1 + (Math.pow(10, (getElo(looser)*1.0 - getElo(winner)*1.0) / 400))))));
            System.out.println(elo);
            removeElo(winner, elo);
            addElo(looser, elo);
        }catch (NullPointerException ex){
            System.err.println("FEHLER");
            ex.printStackTrace();
        }


    }


}