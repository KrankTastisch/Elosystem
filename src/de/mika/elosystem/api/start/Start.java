package de.mika.elosystem.api.start;

import de.mika.elosystem.api.EloRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Timer;
import java.util.TimerTask;

public class Start {


    public static void main(String[] args) throws IOException {

        startGame();

    }

    public static void startGame()  {
        System.out.println("Willkommen zu Ching Chang Chong");
        System.out.println();
        System.out.println("Erklärung:");
        System.out.println("Schreibe in den Chat: Schere, Stein oder Papier.");
        System.out.println("Anschließend wird der gewinner preis gegeben und das Elo verteilt!");
        System.out.println("Du startest mit 1000 Elo (Genauso wie der Bot)!");
        System.out.println("Lets Go! :D");
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++)
                        System.out.println();
                    System.out.println("Dein Elo: " + EloRank.getElo(EloRank.Team.PLAYER));
                    System.out.println();
                    System.out.println("SCHERE, STEIN oder PAPIER");

                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                    String line = reader.readLine();
                    int zufallszahl = (int)((Math.random()) * 3 + 1);

                    //1 = Schere | 2 = Stein | 3 = Papier

                    if (line.equalsIgnoreCase("Schere")) {
                        if (zufallszahl == 1) {
                            System.out.println("Unendschieden!");
                            System.out.println("Der Bot hatte auch SCHERE ausgewählt.");
                            continueGame();
                        } else if (zufallszahl == 2) {
                            System.out.println("Verloren!");
                            System.out.println("Der Bot hatte den STEIN ausgewählt.");
                            EloRank.EloRank(EloRank.Team.BOT, EloRank.Team.PLAYER);
                            continueGame();
                        } else if (zufallszahl == 3) {
                            System.out.println("GEWONNEN!");

                            System.out.println("Der Bot hatte das PAPIER ausgewählt.");
                            EloRank.EloRank(EloRank.Team.PLAYER, EloRank.Team.BOT);
                            continueGame();
                        }

                    } else if (line.equalsIgnoreCase("Stein")) {
                        if (zufallszahl == 1) {
                            System.out.println("Gewonnen!");
                            System.out.println("Der Bot hatte die Schere ausgewählt.");
                            EloRank.EloRank(EloRank.Team.PLAYER, EloRank.Team.BOT);
                            continueGame();
                        } else if (zufallszahl == 2) {
                            System.out.println("Unendschieden!");
                            System.out.println("Der Bot hatte auch den STEIN ausgewählt.");
                            continueGame();
                        } else if (zufallszahl == 3) {
                            System.out.println("Verloren!");
                            System.out.println("Der Bot hatte das PAPIER ausgewählt.");
                            EloRank.EloRank(EloRank.Team.BOT, EloRank.Team.PLAYER);
                            continueGame();
                        }
                    } else if (line.equalsIgnoreCase("Papier")) {
                        if (zufallszahl == 1) {
                            System.out.println("VERLOREN!");
                            System.out.println("Der Bot hatte die SCHERE ausgewählt.");
                            EloRank.EloRank(EloRank.Team.BOT, EloRank.Team.PLAYER);
                            continueGame();
                        } else if (zufallszahl == 2) {
                            System.out.println("GEWONNEN!");
                            System.out.println("Der Bot hatte den STEIN ausgewählt.");
                            EloRank.EloRank(EloRank.Team.PLAYER, EloRank.Team.BOT);
                            continueGame();
                        } else if (zufallszahl == 3) {
                            System.out.println("UNENDSCHIEDEN!");
                            System.out.println("Der Bot hatte das PAPIER ausgewählt.");
                            continueGame();

                        }
                    } else {
                        System.out.println("Bitte nutze nur SCHERE, STEIN oder PAPIER");
                        continueGame();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        },10000);
    }




    public static void continueGame() throws IOException {

          new Timer().schedule(new TimerTask() {
              @Override
              public void run() {
                  try{
                      for (int i = 0; i<100; i++)
                          System.out.println();
                      System.out.println("Das Elo vom Bot: " + EloRank.getElo(EloRank.Team.BOT));
                      System.out.println("Dein Elo: " + EloRank.getElo(EloRank.Team.PLAYER));
                      System.out.println();
                      System.out.println("SCHERE, STEIN oder PAPIER");

                      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                      String line = reader.readLine();
                      int zufallszahl;
                      zufallszahl = (int)(Math.random() * 3) + 1;

                      //1 = Schere | 2 = Stein | 3 = Papier

                      if(line.equalsIgnoreCase("Schere")){
                          if(zufallszahl == 1){
                              System.out.println("Unendschieden!");
                              System.out.println("Der Bot hatte auch SCHERE ausgewählt.");
                              continueGame();
                          }else if(zufallszahl == 2){
                              System.out.println("Verloren!");
                              System.out.println("Der Bot hatte den STEIN ausgewählt.");
                              EloRank.EloRank(EloRank.Team.BOT, EloRank.Team.PLAYER);
                              continueGame();
                          }else if(zufallszahl == 3){
                              System.out.println("GEWONNEN!");
                              System.out.println("Der Bot hatte das PAPIER ausgewählt.");
                              EloRank.EloRank(EloRank.Team.PLAYER, EloRank.Team.BOT);
                              continueGame();
                          }

                      }else if(line.equalsIgnoreCase("Stein")){
                          if(zufallszahl == 1){
                              System.out.println("Gewonnen!");
                              System.out.println("Der Bot hatte die Schere ausgewählt.");
                              EloRank.EloRank(EloRank.Team.PLAYER, EloRank.Team.BOT);
                              continueGame();
                          }else if(zufallszahl == 2){
                              System.out.println("Unendschieden!");
                              System.out.println("Der Bot hatte auch den STEIN ausgewählt.");
                              continueGame();
                          }else if(zufallszahl == 3){
                              System.out.println("Verloren!");
                              System.out.println("Der Bot hatte das PAPIER ausgewählt.");
                              EloRank.EloRank(EloRank.Team.BOT, EloRank.Team.PLAYER);
                              continueGame();
                          }
                      }else if(line.equalsIgnoreCase("Papier")){
                          if(zufallszahl == 1){
                              System.out.println("VERLOREN!");
                              System.out.println("Der Bot hatte die SCHERE ausgewählt.");
                              EloRank.EloRank(EloRank.Team.BOT, EloRank.Team.PLAYER);
                              continueGame();
                          }else if(zufallszahl == 2){
                              System.out.println("GEWONNEN!");
                              System.out.println("Der Bot hatte den STEIN ausgewählt.");
                              EloRank.EloRank(EloRank.Team.PLAYER, EloRank.Team.BOT);
                              continueGame();
                          }else if(zufallszahl == 3){
                              System.out.println("UNENDSCHIEDEN!");
                              System.out.println("Der Bot hatte das PAPIER ausgewählt.");
                              continueGame();

                          }
                      }else{
                          System.out.println("Bitte nutze nur SCHERE, STEIN oder PAPIER");
                          continueGame();

                      }
                  }catch (Exception ex){
                      ex.printStackTrace();
                  }


              }
          },3000);

    }
}
